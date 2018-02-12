package datastructures.shavaleevar.datastructures.dynamicarray;

import datastructures.shavaleevar.datastructures.dynamicarray.DynamicArray;
import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

public class IteratorTest {
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
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator();
        assertEquals("IteratorTest.testIteratorHasNext", true, iterator.hasNext());
    }

    private static void testIteratorHasNotNext() {
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(10);
        assertEquals("IteratorTest.testIteratorHasNotNext", false, iterator.hasNext());
    }

    private static void testIteratorNext() {
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(2);
        Assert.assertEquals("IteratorTest.testIteratorNext", 2, (int) iterator.next());
    }

    private static void testIteratorNextException() {
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(10);
        try {
            iterator.next();
            Assert.fail("IteratorTest.testIteratorNextException");
        } catch (Exception e) {
            Assert.assertEquals("IteratorTest.testIteratorNextException", "Illegal Index: 10", e.getMessage());
        }
    }

    private static void testIteratorHasPrevious() {
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(3);
        assertEquals("IteratorTest.testIteratorHasPrevious", true, iterator.hasPrevious());
    }

    private static void testIteratorHasNotPrevious() {
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(0);
        assertEquals("IteratorTest.testIteratorHasNotPrevious", false, iterator.hasPrevious());
    }

    private static void testIteratorPrevious() {
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(2);
        Assert.assertEquals("IteratorTest.testIteratorPrevious", 1, (int) iterator.previous());
    }

    private static void testIteratorNextIndex() {
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(2);
        assertEquals("IteratorTest.testIteratorNextIndex", 2, iterator.nextIndex());
    }

    private static void testIteratorPreviousIndex() {
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(2);
        assertEquals("IteratorTest.testIteratorPreviousIndex", 1, iterator.previousIndex());
    }

    private static void testIteratorRemove() {
        DynamicArray expected = new DynamicArray();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(5);
        iterator.next();
        iterator.remove();
        Assert.assertEquals("IteratorTest.testIteratorRemove", actual, expected);
    }

    private static void testIteratorRemoveException() {
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(5);
        try {
            iterator.remove();
            Assert.fail("IteratorTest.testIteratorRemoveException");
        } catch (Exception e) {
            Assert.assertEquals("IteratorTest.testIteratorRemoveException", "You should use next method before removing objects", e.getMessage());
        }
    }

    private static void testIteratorSet() {
        DynamicArray expected = new DynamicArray();
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
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(5);
        iterator.next();
        iterator.set(5);
        Assert.assertEquals("IteratorTest.testIteratorSet", expected, actual);
    }

    private static void testIteratorSetException() {
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(5);
        try {
            iterator.set(5);
            Assert.fail("IteratorTest.testIteratorSetException");
        } catch (Exception e) {
            Assert.assertEquals("IteratorTest.testIteratorSetException", "You should use next method before removing objects", e.getMessage());
        }
    }

    private static void testIteratorAdd() {
        DynamicArray expected = new DynamicArray();
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
        DynamicArray actual = new DynamicArray();
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
        DynamicArray.ListIteratorImpl iterator = actual.listIterator(10);
        iterator.add(10);
        Assert.assertEquals("IteratorTest.testIteratorAdd", expected, actual);
    }
}
