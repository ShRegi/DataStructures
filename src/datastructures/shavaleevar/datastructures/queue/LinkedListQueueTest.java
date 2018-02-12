package datastructures.shavaleevar.datastructures.queue;

import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

class LinkedListQueueTest {
    public static void main(String[] args) {
        testAsList();
        testAdd();
        testRemove();
        testRemoveException();
        testRemoveObjectBeginning();
        testRemoveObjectMiddle();
        testRemoveObjectEnd();
        testRemoveObjectException();
    }

    private static void testAsList() {
        List<Integer> expected = new LinkedList<>();
        expected.add(7);
        expected.add(5);
        LinkedListQueue<Integer> actual = new LinkedListQueue<>();
        actual.add(5);
        actual.add(7);
        assertEquals("LinkedListQueueTest.testAsList", expected, actual.asList());
    }

    private static void testAdd() {
        Collection<Integer> collection = new LinkedList<>();
        collection.add(0);
        collection.add(1);
        LinkedListQueue<Integer> expected = new LinkedListQueue<>(collection);
        LinkedListQueue<Integer> actual = new LinkedListQueue<>();
        actual.add(0);
        actual.add(1);
        assertEquals("LinkedListQueueTest.testAdd", expected, actual);
    }

    private static void testRemove() {
        LinkedListQueue<Integer> expected = new LinkedListQueue<>();
        expected.add(0);
        expected.add(1);
        LinkedListQueue<Integer> actual = new LinkedListQueue<>();
        actual.add(2);
        actual.add(0);
        actual.add(1);
        assertEquals("LinkedListQueueTest.testAddValues", 2, actual.remove());
        assertEquals("LinkedListQueueTest.testRemove", expected, actual);
    }

    private static void testRemoveException() {
        try {
            LinkedListQueue<Integer> actual = new LinkedListQueue<>();
            actual.remove();
            Assert.fail("LinkedListQueueTest.testRemoveException: failed");
        } catch (NoSuchElementException e) {
            Assert.assertEquals("LinkedListQueueTest.testRemoveException", "Queue is empty", e.getMessage());
        }
    }

    private static void testRemoveObjectBeginning() {
        LinkedListQueue<Integer> expected = new LinkedListQueue<>();
        expected.add(3);
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        LinkedListQueue<Integer> actual = new LinkedListQueue<>();
        actual.add(3);
        actual.add(1);
        actual.add(2);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(2);
        actual.remove(2);
        assertEquals("LinkedListQueueTest.testRemoveObjectBeginning", expected, actual);
    }

    private static void testRemoveObjectMiddle() {
        LinkedListQueue<Integer> expected = new LinkedListQueue<>();
        expected.add(3);
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        LinkedListQueue<Integer> actual = new LinkedListQueue<>();
        actual.add(3);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.remove(3);
        assertEquals("LinkedListQueueTest.testRemoveObjectMiddle", expected, actual);
    }

    private static void testRemoveObjectEnd() {
        LinkedListQueue<Integer> expected = new LinkedListQueue<>();
        expected.add(3);
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        LinkedListQueue<Integer> actual = new LinkedListQueue<>();
        actual.add(22);
        actual.add(3);
        actual.add(1);
        actual.add(2);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.remove(22);
        assertEquals("LinkedListQueueTest.testRemoveObjectEnd", expected, actual);
    }

    private static void testRemoveObjectException() {
        try {
            LinkedListQueue<Integer> actual = new LinkedListQueue<>();
            actual.remove(7);
            Assert.fail("LinkedListQueueTest.testRemoveObjectException: failed");
        } catch (NoSuchElementException e) {
            Assert.assertEquals("LinkedListQueueTest.testRemoveObjectException", "Queue is empty", e.getMessage());
        }
    }
}