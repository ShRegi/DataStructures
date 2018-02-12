package datastructures.shavaleevar.datastructures.CollectionUtils;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollection<E> implements Collection<E> {
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Collection is unmodifiable");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Collection is unmodifiable");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Collection is unmodifiable");
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("Collection is unmodifiable");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Collection is unmodifiable");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Collection is unmodifiable");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Collection is unmodifiable");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Collection is unmodifiable");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Collection is unmodifiable");
    }
}
