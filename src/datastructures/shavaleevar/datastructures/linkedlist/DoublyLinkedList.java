package datastructures.shavaleevar.datastructures.linkedlist;

import datastructures.shavaleevar.datastructures.AbstractList;

import static java.lang.reflect.Array.newInstance;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<V> extends AbstractList<V> implements List<V> {
    private int size;
    private int modifications;
    private Element<V> first;
    private Element<V> last;

    public DoublyLinkedList() {
    }

    DoublyLinkedList(Collection<? extends V> collection) {
        for (V element : collection) {
            add(element);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Element<V> i = first; i != null; i = i.next) {
            if (o.equals(i.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private Element<V> getElement(int index) {
        if (index < (size / 2)) {
            Element<V> element = first;
            for (int i = 0; i < index; i++) {
                element = element.next;
            }
            return element;
        } else {
            Element<V> element = last;
            for (int i = size - 1; i > index; i--) {
                element = element.prev;
            }
            return element;
        }
    }

    @Override
    public V get(int index) {
        checkIndex(index);
        return getElement(index).item;
    }

    @Override
    public V set(int index, V o) {
        checkIndex(index);
        Element<V> element = getElement(index);
        V previousValue = element.item;
        element.item = o;
        return previousValue;
    }

    private void addLast(V value) {
        Element<V> lastPrevious = last;
        Element<V> newElement = new Element<>(lastPrevious, value, null);
        last = newElement;
        if (lastPrevious == null) {
            first = newElement;
        } else {
            lastPrevious.next = newElement;
        }
        size++;
        modifications++;
    }

    private void addNext(Element<V> current, V element) {
        Element<V> previousElement = current.prev;
        Element<V> newElement = new Element<>(previousElement, element, current);
        current.prev = newElement;
        if (previousElement == null) {
            first = newElement;
        } else {
            previousElement.next = newElement;
        }
        size++;
        modifications++;
    }

    @Override
    public boolean add(V value) {
        addLast(value);
        return value.equals(last.item);
    }

    @Override
    public void add(int index, V element) {
        checkIndexForAdd(index);
        if (index == size) {
            addLast(element);
        } else {
            addNext(getElement(index), element);
        }
    }

    private V unlink(Element<V> e) {
        final V element = e.item;
        final Element<V> next = e.next;
        final Element<V> prev = e.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            e.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            e.next = null;
        }
        e.item = null;
        size--;
        modifications++;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        for (Element<V> element = first; element != null; element = element.next) {
            if (o.equals(element.item)) {
                unlink(element);
                return true;
            }
        }
        return false;
    }

    @Override
    public V remove(int index) {
        checkIndex(index);
        return unlink(getElement(index));
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int a = 0;
        for (Element<V>  i = first; i != null; i = i.next) {
            array[a++] = i.item;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] array) {
        if (array.length < size) {
            array = (E[]) newInstance(array.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = array;
        for (Element<V> x = first; x != null; x = x.next) {
            result[i++] = x.item;
        }
        if (array.length > size) {
            array[size] = null;
        }
        return array;
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Illegal Index: " + index);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Illegal Index: " + index);
        }
    }

    private void checkIndexForIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Illegal Index: " + index);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Element<V> i;
        for (i = first; i.next != null; i = i.next) {
            stringBuilder.append(i.item).append(", ");
        }
        stringBuilder.append(i.item).append("]");
        return stringBuilder.toString();
    }

    private static class Element<V> {
        V item;
        Element<V> next;
        Element<V> prev;

        Element(Element<V> prev, V element, Element<V> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public ListIteratorImpl listIterator() {
        return new ListIteratorImpl(0);
    }

    @Override
    public ListIteratorImpl listIterator(int index) {
        checkIndexForIterator(index);
        return new ListIteratorImpl(index);
    }

    public class ListIteratorImpl implements ListIterator<V> {
        private Element<V> cursor;
        private Element<V> lastReturned;
        private int nextIndex;
        private int expectedMod = modifications;

        ListIteratorImpl() {
            expectedMod = modifications;
        }

        ListIteratorImpl(int index) {
            this();
            cursor = (index == size) ? null : getElement(index);
            this.nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public V next() {
            checkForComodification();
            checkIfEnd();
            lastReturned = cursor;
            cursor = cursor.next;
            nextIndex++;
            return lastReturned.item;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public V previous() {
            if (cursor == first) {
                nextIndex--;
                return null;
            } else {
                cursor = cursor.prev;
                lastReturned = cursor;
                nextIndex--;
                return cursor.item;
            }
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            checkCursor();
            checkForComodification();

            Element<V> oldNext = lastReturned.next;
            unlink(lastReturned);
            if (cursor == lastReturned) {
                cursor = oldNext;
            } else {
                nextIndex--;
            }
            lastReturned = null;
            modifications++;
        }

        @Override
        public void set(V o) {
            checkCursor();
            checkForComodification();
            lastReturned.item = o;
        }

        @Override
        public void add(V o) {
            checkForComodification();
            lastReturned = null;
            if (cursor == null) {
                addLast(o);
            } else {
                addNext(cursor, o);
            }
            nextIndex++;
            expectedMod++;
        }

        private void checkIfEnd() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no next Element");
            }
        }

        private void checkCursor() {
            if (lastReturned == null) {
                throw new IllegalStateException("You should use next method before removing objects");
            }
        }

        private void checkForComodification() {
            if (modifications != expectedMod) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
