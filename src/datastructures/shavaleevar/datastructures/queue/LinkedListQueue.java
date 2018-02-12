package datastructures.shavaleevar.datastructures.queue;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class LinkedListQueue<E> extends AbstractQueue<E> implements Queue<E> {
    private Node<E> head;
    private int size;

    LinkedListQueue() {
    }

    LinkedListQueue(Collection<? extends E> collection) {
        if (collection.size() != 0) {
            for (E element : collection) {
                add(element);
            }
        }
    }

    @Override
    public boolean add(E e) {
        Node<E> current = head;
        head = new Node<>(e, current);
        size++;
        return e.equals(head.value);
    }

    @Override
    public boolean remove(Object o) {
        checkSize();
        if (size == 1) {
            if (o.equals(head.value)) {
                head = null;
                size--;
                return true;
            }
        } else if (o.equals(head.value)) {
            head = head.next;
            size--;
            return true;
        } else {
            Node<E> current = head.next;
            Node<E> previous = head;
            for (int i = 1; i < size; i++) {
                if (o.equals(current.value)) {
                    previous.next = current.next;
                    size--;
                    return true;
                }
                previous = current;
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public E remove() {
        checkSize();
        Node<E> removed = head;
        if (size == 1) {
            head = null;
        } else {
            Node<E> current = head;
            for (int i = 1; i < size - 1; i++) {
                current = current.next;
            }
            removed = current.next;
            current.next = null;
        }
        size--;
        return removed.value;
    }

    private void checkSize() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    public List<E> asList() {
        List<E> list = new LinkedList<>();
        for (Node<E> i = head; i != null; i = i.next) {
            list.add(i.value);
        }
        return list;
    }

    private static class Node<E> {
        final E value;
        Node<E> next;

        Node(E v, Node<E> n) {
            value = v;
            next = n;
        }
    }
}
