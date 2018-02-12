package datastructures.shavaleevar.datastructures.dynamicarray;

import datastructures.shavaleevar.datastructures.AbstractList;

import static java.lang.System.arraycopy;
import static java.util.Arrays.copyOf;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;

public class DynamicArray<V> extends AbstractList<V> implements List<V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double INCREASE_CAPACITY_INDEX = 1.5;
    private static final Object[] EMPTY_ARRAY = {};

    private int currentCapacity;
    private int size;
    private int modCount;
    private transient Object[] dynamicArray;


    DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    DynamicArray(int size) {
        if (size > 0) {
            dynamicArray = new Object[size];
            currentCapacity = size;
        } else if (size == 0) {
            dynamicArray = EMPTY_ARRAY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + size);
        }
    }

    DynamicArray(Collection<? extends V> collection) {
        dynamicArray = collection.toArray();
        if ((size = dynamicArray.length) != 0) {
            if (dynamicArray.getClass() != Object[].class) {
                dynamicArray = copyOf(dynamicArray, size, Object[].class);
            }
        } else {
            this.dynamicArray = EMPTY_ARRAY;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    @Override
    public Object[] toArray() {
        return copyOf(dynamicArray, size);
    }

    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] array) {
        if (array.length < size) {
            return (E[]) copyOf(dynamicArray, size, array.getClass());
        }
        arraycopy(dynamicArray, 0, array, 0, size);
        if (array.length > size) {
            array[size] = null;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    private V dynamicArray(int index) {
        return (V) dynamicArray[index];
    }

    @Override
    public V get(int i) {
        rangeCheck(i);
        return dynamicArray(i);
    }

    @Override
    public V set(int i, V e) {
        rangeCheck(i);
        V previousValue = dynamicArray(i);
        dynamicArray[i] = e;
        return previousValue;
    }

    @Override
    public boolean add(V e) {
        ensureCapacity(size + 1);
        dynamicArray[size++] = e;
        return e.equals(dynamicArray[size - 1]);
    }

    @Override
    public boolean remove(Object e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(dynamicArray[i])) {
                modCount++;
                int numMoved = size - i - 1;
                arraycopy(dynamicArray, i + 1, dynamicArray, i, numMoved);
                dynamicArray[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(int i, V e) {
        rangeCheckForAdd(i);
        ensureCapacity(size + 1);
        arraycopy(dynamicArray, i, dynamicArray, i + 1, size - i);
        dynamicArray[i] = e;
        size++;
    }

    @Override
    public V remove(int i) {
        rangeCheck(i);
        modCount++;
        V removedObject = dynamicArray(i);
        int numMoved = size - i - 1;
        if (numMoved > 0) {
            arraycopy(dynamicArray, i + 1, dynamicArray, i, numMoved);
        }
        dynamicArray[--size] = null;
        return removedObject;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < dynamicArray.length; i++) {
            if (e.equals(dynamicArray[i])) {
                return i;
            }
        }
        return -1;
    }

    private void rangeCheck(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Illegal Index: " + i);
        }
    }

    private void rangeCheckForAdd(int i) {
        if (i > size || i < 0) {
            throw new IndexOutOfBoundsException("Illegal Index: " + i);
        }
    }

    private void ensureCapacity(int i) {
        modCount++;
        if (i > currentCapacity) {
            increaseCapacity();
        }
    }

    private void increaseCapacity() {
        currentCapacity = (int) (dynamicArray.length * INCREASE_CAPACITY_INDEX);
        dynamicArray = copyOf(dynamicArray, currentCapacity);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        int i;
        for (i = 0; i < size - 1; i++) {
            stringBuilder.append(dynamicArray[i]).append(", ");
        }
        stringBuilder.append(dynamicArray[i]).append(']');
        return stringBuilder.toString();
    }

    @Override
    public ListIteratorImpl listIterator() {
        return new ListIteratorImpl(0);
    }

    @Override
    public ListIteratorImpl listIterator(int index) {
        return new ListIteratorImpl(index);
    }

    class ListIteratorImpl implements ListIterator<V> {
        int cursor;
        int lastReturned = -1;
        int expectedModCount = modCount;

        ListIteratorImpl(int index) {
            cursor = index;
        }

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public V next() {
            checkForComodification();
            int i = cursor;
            rangeCheck(i);
            cursor = i + 1;
            return dynamicArray(lastReturned = i);
        }

        @Override
        public void remove() {
            checkCursor();
            checkForComodification();

            try {
                DynamicArray.this.remove(lastReturned);
                cursor = lastReturned;
                lastReturned = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public V previous() {
            checkForComodification();
            int i = cursor - 1;
            rangeCheck(i);
            cursor = i;
            return dynamicArray(lastReturned = i);
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void set(V e) {
            checkCursor();
            checkForComodification();

            try {
                DynamicArray.this.set(lastReturned, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void add(V e) {
            checkForComodification();

            try {
                int i = cursor;
                DynamicArray.this.add(i, e);
                cursor = i + 1;
                lastReturned = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        private void checkCursor() {
            if (lastReturned < 0) {
                throw new IllegalStateException("You should use next method before removing objects");
            }
        }

        private void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
