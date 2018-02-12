package datastructures.shavaleevar.datastructures.linkedlist;

import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

import java.util.List;
import java.util.ListIterator;

public class DoublyLinkedListIteratorTest {
    public static void main(String[] args) {
        testIteratorHasNext();
        testIteratorHasNotNext();
        testIteratorNext();
        testIteratorNextException();
        testIteratorHasPrevious();
        testIteratorHasNotPrevious();
        testIteratorPrevious();
        testIteratorNextIndex();
        testIteratorPreviousIndex();
        testIteratorRemove();
        testIteratorRemoveException();
        testIteratorSet();
        testIteratorSetException();
        testIteratorAdd();
    }

    private static void testIteratorHasNext() {
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator iterator = actual.listIterator();
        Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorHasNext", true, iterator.hasNext());
    }

    private static void testIteratorHasNotNext() {
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator(10);
        Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorHasNotNext", false, iterator.hasNext());
    }

    private static void testIteratorNext() {
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator(2);
        Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorNext", 2, iterator.next());
    }

    private static void testIteratorNextException() {
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator(10);
        try {
            iterator.next();
            Assert.fail("DoublyLinkedListIteratorTest.testIteratorNextException");
        } catch (Exception e) {
            Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorNextException", "There is no next Element", e.getMessage());
        }
    }

    private static void testIteratorHasPrevious() {
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator(3);
        Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorHasPrevious", true, iterator.hasPrevious());
    }

    private static void testIteratorHasNotPrevious() {
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator();
        Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorHasNotPrevious", false, iterator.hasPrevious());
    }

    private static void testIteratorPrevious() {
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator(2);
        Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorPrevious", 1, iterator.previous());
    }

    private static void testIteratorNextIndex() {
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator(2);
        Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorNextIndex", 2, iterator.nextIndex());
    }

    private static void testIteratorPreviousIndex() {
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator(2);
        Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorPreviousIndex", 1, iterator.previousIndex());
    }

    private static void testIteratorRemove() {
        List<Integer> expected = new DoublyLinkedList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator(5);
        iterator.next();
        iterator.remove();
        Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorRemove", actual, expected);
    }

    private static void testIteratorRemoveException() {
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator(5);
        try {
            iterator.remove();
            Assert.fail("DoublyLinkedListIteratorTest.testIteratorRemoveException");
        } catch (Exception e) {
            Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorRemoveException", "You should use next method before removing objects", e.getMessage());
        }
    }

    private static void testIteratorSet() {
        List<Integer> expected = new DoublyLinkedList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(0);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator(5);
        iterator.next();
        iterator.set(5);
        Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorSet", expected, actual);
    }

    private static void testIteratorSetException() {
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(0);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator(5);
        try {
            iterator.set(5);
            Assert.fail("DoublyLinkedListIteratorTest.testIteratorSetException");
        } catch (Exception e) {
            Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorSetException", "You should use next method before removing objects", e.getMessage());
        }
    }

    private static void testIteratorAdd() {
        List<Integer> expected = new DoublyLinkedList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        expected.add(10);
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        ListIterator<Integer> iterator = actual.listIterator(10);
        iterator.add(10);
        Assert.assertEquals("DoublyLinkedListIteratorTest.testIteratorAdd", expected, actual);
    }
}
