package datastructures.shavaleevar.datastructures.stack;

import java.util.List;

public interface Stack<E> {
    void push(E e);

    E pop();

    int size();

    E peek();

    void reverse();

    List asList();

    String toString();
}
