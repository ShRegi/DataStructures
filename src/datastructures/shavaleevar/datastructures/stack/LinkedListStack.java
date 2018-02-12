package datastructures.shavaleevar.datastructures.stack;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedListStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    LinkedListStack() {
    }

    LinkedListStack(Collection<? extends E> collection) {
        for (E element : collection) {
            add(element);
        }
    }

    public int size() {
        return size;
    }

    @Override
    public void push(E e) {
        add(e);
    }

    @Override
    public E pop() {
        sizeCheck();
        Node<E> value = top;
        if (top.next == null) {
            top = null;
        } else {
            Node<E> previous = getNode(size - 2);
            value = getNode(size - 1);
            previous.next = null;
        }
        size--;
        return value.val;
    }

    public E peek() {
        sizeCheck();
        return getNode(size - 1).val;
    }

    private Node<E> getNode(int index) {
        Node<E> current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public List<E> asList() {
        List<E> list = new LinkedList<>();
        for (Node<E> i = top; i != null; i = i.next) {
            list.add(i.val);
        }
        return list;
    }

    public void reverse() {
        sizeCheck();
        Node<E> current = top;
        for (Node<E> i = top; i != null; i = i.next) {
            current = i;
        }
        current.next = new Node<>(top.val, null);
        Node<E> tail = current;
        current = top;
        for (int i = 1; i < size; i++) {
            current = current.next;
            relink(tail, current);

        }
        top = tail.next;
    }

    private void relink(Node<E> tail, Node<E> current) {
        Node<E> tempNext = tail.next;
        tail.next = new Node<>(current.val, tempNext);
    }


    private void sizeCheck() {
        if (top == null) {
            throw new NoSuchElementException("Stack is empty");
        }
    }

    private void add(E e) {
        Node<E> current = top;
        Node<E> newNode = new Node<>(e, null);
        if (top == null) {
            top = newNode;
        } else {
            for (Node<E> i = top; i != null; i = i.next) {
                current = i;
            }
            current.next = newNode;
        }
        size++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<E> i;
        for (i = top; i.next != null; i = i.next) {
            stringBuilder.append(i.val).append(", ");
        }
        stringBuilder.append(i.val).append("]");
        return stringBuilder.toString();
    }

    static class Node<E> {
        private Node<E> next;
        private final E val;

        Node(E v, Node<E> n) {
            next = n;
            val = v;
        }
    }
}
