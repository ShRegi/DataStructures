package datastructures.shavaleevar.datastructures.maps;

import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class AssociativeArray<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAX_CAPACITY = 536870912;
    private static final int INITIAL_CAPACITY = 15;

    private Entry<? extends K, ? extends V>[] array;
    private float threshold;
    private int size;

    @SuppressWarnings("unchecked")
    AssociativeArray(int capacity) {
        array = new Entry[capacity];
        threshold = array.length * LOAD_FACTOR;
    }

    AssociativeArray() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        int indexValue = (key == null) ? 0 : key.hashCode() % array.length;
        if (indexValue < 0) {
            indexValue = array.length - 1 & indexValue;
        }
        if (array[indexValue] == null) {
            throw new NoSuchElementException("There is no element with key: " + key);
        } else {
            Entry<K, V> current = (Entry<K, V>) array[indexValue];
            if (current.key == key || current.key != null && current.key.equals(key)) {
                return current.value;
            }
            while (current != null) {
                if (current.key == key || current.key != null && current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }
        }
        throw new NoSuchElementException("There is no element with key: " + key);
    }

    @SuppressWarnings("unchecked")
    public Entry<K, V> add(K key, V value) {
        checkLoading();
        int indexValue = (key == null) ? 0 : key.hashCode() % array.length;
        if (indexValue < 0) {
            indexValue = array.length - 1 & indexValue;
        }
        Entry<K,V> current = (Entry<K, V>) array[indexValue];
        Entry<K, V> newEntry = new Entry<>(key, value, indexValue);
        if (array[indexValue] == null) {
            array[indexValue] = newEntry;
            size++;
            return current;
        } else {
            if (current.hash == indexValue && (current.key == key || current.key != null && current.key.equals(key))) {
                newEntry.next = current.next;
                array[indexValue] = newEntry;
                return current;
            } else {
                while (current.next != null) {
                    Entry<K, V> previous = current;
                    current = current.next;
                    if (current.key == key || current.key != null && current.key.equals(key)) {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return current;
                    }
                }
                current.next = newEntry;
                size++;
                return null;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void remove(K key) {
        int indexValue = (key == null) ? 0 : key.hashCode() % array.length;
        if (indexValue < 0) {
            indexValue = array.length - 1 & indexValue;
        }
        Entry<K, V> current = (Entry<K, V>) array[indexValue];
        if (current != null) {
            if (current.hash == indexValue && (current.key == key || current.key != null && current.key.equals(key))) {
                array[indexValue] = current.next;
                size--;
            } else {
                Entry<K, V> previous = current;
                while (current.next != null) {
                    current = current.next;
                    if (current.key == key || current.key != null && current.key.equals(key)) {
                        previous.next = current.next;
                        size--;
                    }
                    previous = current;
                }
            }
        }
    }

    private static class Entry<K, V> {
        final int hash;
        final K key;
        final V value;
        Entry<K, V> next;

        Entry(K key, V value, int indexValue) {
            this.key = key;
            this.value = value;
            hash = indexValue;
        }

        @Override
        public String toString() {
            return key != null ? key + ":" + value : "null:" + value;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Entry) {
                @SuppressWarnings("unchecked")
                Entry<? extends K,? extends V> e = (Entry<K,V>)obj;
                if (Objects.equals(key, e.key) && Objects.equals(value, e.value)) {
                    return true;
                }
            }
            return false;
        }
    }

    private void increaseCapacity() {
        if (array.length == MAX_CAPACITY) {
            throw new OutOfMemoryError("Capacity can't be increased");
        } else if (array.length * LOAD_FACTOR > MAX_CAPACITY) {
            reHash(MAX_CAPACITY);
            threshold = (int) (array.length * LOAD_FACTOR);
        } else {
            int capacity = array.length * 2;
            reHash(capacity);
        }
    }

    @SuppressWarnings("unchecked")
    private void reHash(int capacity) {
        Entry<K, V>[] temporaryArray = (Entry<K, V>[]) array;
        array = new Entry[capacity];
        size = 0;
        for (Entry<? extends K, ? extends V> i : temporaryArray) {
            if (i != null) {
                add(i.key, i.value);
                while (i.next != null) {
                    add(i.next.key, i.next.value);
                    i = i.next;
                }
            }
        }
        threshold = array.length * LOAD_FACTOR;
    }

    private void checkLoading() {
        if (size > threshold) {
            increaseCapacity();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (Entry<? extends K, ? extends V> anArray : array) {
            if (anArray != null) {
                @SuppressWarnings("unchecked") Entry<K, V> current = (Entry<K, V>) anArray;
                while (current != null) {
                    stringBuilder.append(current.key).append(':').append(current.value).append(System.lineSeparator());
                    current = current.next;
                }
            }
        }
        return stringBuilder.toString();
    }

    @SuppressWarnings("unchecked")
    private Set<Entry> toSet() {
        Set<Entry> set = new LinkedHashSet<>();
        for (Entry<? extends K, ? extends V> entry : array) {
            Entry<K, V> current = (Entry<K, V>) entry;
            if (entry != null) {
                Entry<K, V> newEntry = new Entry(current.key, current.value, current.hash);
                set.add(newEntry);
                while (current != null) {
                    set.add(newEntry);
                    current = current.next;
                }
            }
        }
        return set;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(array);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof AssociativeArray) {
            @SuppressWarnings("unchecked")
            AssociativeArray<K, V> associativeObject = (AssociativeArray<K, V>) obj;
            Set<Entry> thisSet = this.toSet();
            Set<Entry> objSet = associativeObject.toSet();
            return this.size == associativeObject.size && thisSet.containsAll(objSet);

        }
        return true;
    }
}
