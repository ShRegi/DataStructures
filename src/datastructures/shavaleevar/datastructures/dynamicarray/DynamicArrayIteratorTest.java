package datastructures.shavaleevar.datastructures.dynamicarray;

import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

import java.util.ListIterator;

public class DynamicArrayIteratorTest {
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
        DynamicArray<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayIteratorTest.testIteratorHasNext", true, iterator.hasNext());
    }

    private static void testIteratorHasNotNext() {
        DynamicArray<Integer> actual = new DynamicArray<>();
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
        ListIterator iterator = actual.listIterator(10);
        Assert.assertEquals("DynamicArrayIteratorTest.testIteratorHasNotNext", false, iterator.hasNext());
    }

    private static void testIteratorNext() {
        DynamicArray<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayIteratorTest.testIteratorNext", 2, iterator.next());
    }

    private static void testIteratorNextException() {
        DynamicArray<Integer> actual = new DynamicArray<>();
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
            Assert.fail("DynamicArrayIteratorTest.testIteratorNextException");
        } catch (Exception e) {
            Assert.assertEquals("DynamicArrayIteratorTest.testIteratorNextException", "Illegal Index: 10", e.getMessage());
        }
    }

    private static void testIteratorHasPrevious() {
        DynamicArray<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayIteratorTest.testIteratorHasPrevious", true, iterator.hasPrevious());
    }

    private static void testIteratorHasNotPrevious() {
        DynamicArray<Integer> actual = new DynamicArray<>();
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
        ListIterator<Integer> iterator = actual.listIterator(0);
        Assert.assertEquals("DynamicArrayIteratorTest.testIteratorHasNotPrevious", false, iterator.hasPrevious());
    }

    private static void testIteratorPrevious() {
        DynamicArray<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayIteratorTest.testIteratorPrevious", 1, iterator.previous());
    }

    private static void testIteratorNextIndex() {
        DynamicArray<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayIteratorTest.testIteratorNextIndex", 2, iterator.nextIndex());
    }

    private static void testIteratorPreviousIndex() {
        DynamicArray<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayIteratorTest.testIteratorPreviousIndex", 1, iterator.previousIndex());
    }

    private static void testIteratorRemove() {
        DynamicArray<Integer> expected = new DynamicArray<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        DynamicArray<Integer> actual = new DynamicArray<>();
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
        assertEquals("DynamicArrayIteratorTest.testIteratorRemove", actual, expected);
    }

    private static void testIteratorRemoveException() {
        DynamicArray<Integer> actual = new DynamicArray<>();
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
            Assert.fail("DynamicArrayIteratorTest.testIteratorRemoveException");
        } catch (Exception e) {
            Assert.assertEquals("DynamicArrayIteratorTest.testIteratorRemoveException", "You should use next method before removing objects", e.getMessage());
        }
    }

    private static void testIteratorSet() {
        DynamicArray<Integer> expected = new DynamicArray<>();
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
        DynamicArray<Integer> actual = new DynamicArray<>();
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
        assertEquals("DynamicArrayIteratorTest.testIteratorSet", expected, actual);
    }

    private static void testIteratorSetException() {
        DynamicArray<Integer> actual = new DynamicArray<>();
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
            iterator.set(5);
            Assert.fail("DynamicArrayIteratorTest.testIteratorSetException");
        } catch (Exception e) {
            Assert.assertEquals("DynamicArrayIteratorTest.testIteratorSetException", "You should use next method before removing objects", e.getMessage());
        }
    }

    private static void testIteratorAdd() {
        DynamicArray<Integer> expected = new DynamicArray<>();
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
        DynamicArray<Integer> actual = new DynamicArray<>();
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
        assertEquals("DynamicArrayIteratorTest.testIteratorAdd", expected, actual);
    }
}
