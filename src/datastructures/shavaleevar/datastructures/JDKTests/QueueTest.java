package datastructures.shavaleevar.datastructures.JDKTests;

import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        testSize();
        testIsEmpty();
        testContains();
        testIterator();
        testToArray();
        testToArrayObject();
        testAdd();
        testOffer();
        testRemoveObject();
        testAddAll();
        testClear();
        testRetainAll();
        testRemoveAll();
        testContainsAll();
        testRemove();
        testPoll();
        testElement();
        testPeek();
    }

    private static void testSize() {
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(1);
        actual.add(1);
        actual.add(1);
        Assert.assertEquals("QueueTest.testSize", 3, actual.size());
    }

    private static void testIsEmpty() {
        Queue<Integer> actual = new ArrayDeque<>();
        Assert.assertEquals("QueueTest.testIsEmpty", true, actual.isEmpty());
    }

    private static void testContains() {
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        Assert.assertEquals("QueueTest.testContains", true, actual.contains(3));
    }

    private static void testIterator() {
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Iterator iterator = actual.iterator();
        Assert.assertEquals("QueueTest.testIterator", 3, (int) iterator.next());
    }

    private static void testToArray() {
        Queue<String> actual = new ArrayDeque<>();
        actual.add("3");
        actual.add("5");
        actual.add("2");
        String[] array = new String[3];
        array[0] = "3";
        array[1] = "5";
        array[2] = "2";
        Assert.assertEquals("QueueTest.testToArray", array, actual.toArray());
    }

    private static void testToArrayObject() {
        Queue<String> actual = new ArrayDeque<>();
        actual.add("3");
        actual.add("2");
        String[] expected = new String[2];
        expected[0] = "3";
        expected[1] = "2";
        Assert.assertEquals("QueueTest.testToArrayObject", expected, actual.toArray(new String[actual.size()]));
    }

    private static void testAdd() {
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(5);
        Assert.assertEquals("QueueTest.testAdd", true, actual.contains(5));
    }

    private static void testOffer() {
        Queue<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        Assert.assertEquals("QueueTest.testOfferValue", true, actual.offer(5));
        Assert.assertEquals("QueueTest.testOffer", expected, actual);
    }

    private static void testRemoveObject() {
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.remove(5);
        Queue<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(2);
        Assert.assertEquals("QueueTest.testRemove", expected, actual);
    }

    private static void testAddAll() {
        Collection<Integer> collection = new ArrayDeque<>();
        collection.add(3);
        collection.add(8);
        collection.add(2);
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(5);
        actual.addAll(collection);
        Queue<Integer> expected = new ArrayDeque<>();
        expected.add(5);
        expected.add(3);
        expected.add(8);
        expected.add(2);
        Assert.assertEquals("QueueTest.testAddAll", expected, actual);
    }

    private static void testClear() {
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.clear();
        Queue<Integer> expected = new ArrayDeque<>();
        Assert.assertEquals("QueueTest.testClear", expected, actual);
    }

    private static void testRetainAll() {
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Collection<Integer> collection = new ArrayDeque<>();
        collection.add(5);
        collection.add(2);
        actual.retainAll(collection);
        Queue<Integer> expected = new ArrayDeque<>();
        expected.add(5);
        expected.add(2);
        expected.add(5);
        Assert.assertEquals("QueueTest.testRetainAll", expected, actual);
    }

    private static void testRemoveAll() {
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Collection<Integer> collection = new ArrayDeque<>();
        collection.add(5);
        collection.add(2);
        actual.removeAll(collection);
        Queue<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(7);
        Assert.assertEquals("QueueTest.testRemoveAll", expected, actual);
    }


    private static void testContainsAll() {
        Collection<Integer> collection = new ArrayDeque<>();
        collection.add(3);
        collection.add(5);
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(3);
        actual.add(9);
        Assert.assertEquals("QueueTest.testContainsAll", true, actual.containsAll(collection));
    }

    private static void testRemove() {
        Queue<Integer> expected = new ArrayDeque<>();
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("QueueTest.testRemoveValue", 3, actual.remove());
        Assert.assertEquals("QueueTest.testRemove", expected, actual);
    }

    private static void testPoll() {
        Queue<Integer> expected = new ArrayDeque<>();
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("QueueTest.testPollValue", 3, actual.poll());
        Assert.assertEquals("QueueTest.testPoll", expected, actual);
    }

    private static void testElement() {
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("QueueTest.testElement", 3, actual.element());
    }

    private static void testPeek() {
        Queue<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("QueueTest.testPeek", 3, actual.peek());
    }
}
