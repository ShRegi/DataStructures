package datastructures.shavaleevar.datastructures.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

public class CollectionUtils {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(1);
        collection.add(2);
        collection.add(1);
        collection.add(2);
        collection.add(1);
        collection.add(2);
        collection.add(2);
        collection.add(1);
        filter(collection, integer -> integer > 1);
        System.out.println(collection);
    }

    static <E> boolean filter(Collection<E> collection, Predicate<E> predicate) {
        boolean result = false;
        if (collection != null && predicate != null) {
            Iterator<E> it = collection.iterator();

            while(it.hasNext()) {
                if (!predicate.test(it.next())) {
                    it.remove();
                    result = true;
                }
            }
        }
        return result;
    }

    interface Transformer<E, O> {
        O transform(E value);
    }

    static <E, T> void transform(Collection<E> collection, Transformer<E, T> transformer) {
        if (collection != null && transformer != null) {
            if (collection instanceof List) {
                List list = (List)collection;
                ListIterator it = list.listIterator();

                while(it.hasNext()) {
                    it.set(transformer.transform((E)it.next()));
                }
            } else {
                //TODO
                Collection temporaryCollection = collection;
                collection.clear();
                Iterator iterator = temporaryCollection.iterator();
                while (iterator.hasNext()) {
                    collection.add((E) transformer.transform((E) iterator.next()));
                }
            }
        }
    }

    static <E, T> void transform(Collection<E> collection, Collection<T> resultCollection, Transformer<E, T> transformer) {
        if (collection != null && transformer != null) {
            if (collection instanceof List) {
                List list = (List)collection;
                ListIterator it = list.listIterator();
                List<T> resultList = (List<T>) resultCollection;

                while(it.hasNext()) {
                    resultList.add(transformer.transform((E)it.next()));
                }
            } else {
                //TODO
                Iterator iterator = collection.iterator();
                while (iterator.hasNext()) {
                    resultCollection.add((T) transformer.transform((E) iterator.next()));
                }
            }
        }
    }

    interface Closure<E> {
        void execute(E value);
    }

    static <E> void forAllDo(Collection<E> collection, Closure<E> closure) {
        if (closure == null) {
            throw new NullPointerException("Closure must not be null");
        } else {
            Iterator<E> iterator = collection.iterator();
            while(iterator.hasNext()) {
                E element = iterator.next();
                closure.execute(element);
            }
        }
    }
}



