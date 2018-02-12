package datastructures.shavaleevar.datastructures.CollectionUtils;

import java.util.Collection;

public class UnmodifiableCollection<E> extends AbstractCollection<E> {
    private Collection<? extends E> collection;

    private UnmodifiableCollection(Collection<? extends E> coll) {
        this.collection = coll;
    }

    static <E> Collection<E> unmodifiableCollection(Collection<? extends E> coll) {
        return new UnmodifiableCollection<>(coll);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public boolean isEmpty() {
        return collection.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return collection.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return collection.containsAll(c);
    }
}
