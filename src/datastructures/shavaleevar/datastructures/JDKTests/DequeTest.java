package datastructures.shavaleevar.datastructures.JDKTests;

import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class DequeTest {
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testOfferFirst();
        testOfferLast();
        testRemoveFirst();
        testRemoveLast();
        testPollFirst();
        testPollLast();
        testGetFirst();
        testGetLast();
        testPeekFirst();
        testPeekLast();
        testRemoveFirstOccurrence();
        testRemoveLastOccurrence();
        testAdd();
        testOffer();
        testRemove();
        testPoll();
        testElement();
        testPeek();
        testPush();
        testPop();
        testRemoveObject();
        testAddAll();
        testClear();
        testRetainAll();
        testRemoveAll();
        testContainsAll();
        testContains();
        testSize();
        testIsEmpty();
        testIterator();
        testToArray();
        testToArrayObject();
        testDescendingIterator();
    }


    private static void testAddFirst() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        actual.addFirst(3);
        Assert.assertEquals("DequeTest.testAddFirst", expected, actual);
    }

    private static void testAddLast() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.addLast(7);
        Assert.assertEquals("DequeTest.testAddLast", expected, actual);
    }

    private static void testOfferFirst() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testOfferFirstValue", true, actual.offerFirst(3));
        Assert.assertEquals("DequeTest.testOfferFirst", expected, actual);
    }

    private static void testOfferLast() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        Assert.assertEquals("DequeTest.testOfferLastValue", true, actual.offerLast(7));
        Assert.assertEquals("DequeTest.testOfferLast", expected, actual);
    }

    private static void testRemoveFirst() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testRemoveFirstValue", 3, actual.removeFirst());
        Assert.assertEquals("DequeTest.testRemoveFirst", expected, actual);
    }

    private static void testRemoveLast() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        expected.add(2);
        expected.add(5);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testRemoveLastValue", 7, actual.removeLast());
        Assert.assertEquals("DequeTest.testRemoveLast", expected, actual);
    }

    private static void testPollFirst() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testPollFirstValue", 3, actual.pollFirst());
        Assert.assertEquals("DequeTest.testPollFirst", expected, actual);
    }

    private static void testPollLast() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        expected.add(2);
        expected.add(5);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testPollLastValue", 7, actual.pollLast());
        Assert.assertEquals("DequeTest.testPollLast", expected, actual);
    }

    private static void testGetFirst() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testGetFirstValue", 3, actual.getFirst());
        Assert.assertEquals("DequeTest.testGetFirst", expected, actual);
    }

    private static void testGetLast() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testGetLastValue", 7, actual.getLast());
        Assert.assertEquals("DequeTest.testGetLast", expected, actual);
    }

    private static void testPeekFirst() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testPeekFirstValue", 3, actual.peekFirst());
        Assert.assertEquals("DequeTest.testPeekFirst", expected, actual);
    }

    private static void testPeekLast() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testPeekLastValue", 7, actual.peekLast());
        Assert.assertEquals("DequeTest.testPeekLast", expected, actual);
    }

    private static void testRemoveFirstOccurrence() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testRemoveFirstOccurrenceValue", true, actual.removeFirstOccurrence(5));
        Assert.assertEquals("DequeTest.testRemoveFirstOccurrence", expected, actual);
    }

    private static void testRemoveLastOccurrence() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        expected.add(2);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testRemoveLastOccurrenceValue", true, actual.removeLastOccurrence(5));
        Assert.assertEquals("DequeTest.testRemoveLastOccurrence", expected, actual);
    }

    private static void testAdd() {
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(5);
        Assert.assertEquals("DequeTest.testAdd", true, actual.contains(5));
    }

    private static void testOffer() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(5);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        Assert.assertEquals("DequeTest.testOfferValue", true, actual.offer(5));
        Assert.assertEquals("DequeTest.testOffer", expected, actual);
    }

    private static void testRemove() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testRemoveValue", 3, actual.remove());
        Assert.assertEquals("DequeTest.testRemove", expected, actual);
    }

    private static void testPoll() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(5);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testPollValue", 3, actual.poll());
        Assert.assertEquals("DequeTest.testPoll", expected, actual);
    }

    private static void testElement() {
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testElement", 3, actual.element());
    }

    private static void testPeek() {
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("DequeTest.testPeek", 3, actual.peek());
    }

    private static void testPush() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(0);
        expected.add(7);
        expected.add(5);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.push(5);
        actual.push(7);
        actual.push(0);
        Assert.assertEquals("DequeTest.testPush", expected, actual);
    }

    private static void testPop() {
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(5);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.push(5);
        actual.push(7);
        Assert.assertEquals("DequeTest.testPopValues", 7, actual.pop());
        Assert.assertEquals("DequeTest.testPop", expected, actual);
    }

    private static void testRemoveObject() {
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.remove(5);
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(2);
        Assert.assertEquals("DequeTest.testRemove", expected, actual);
    }

    private static void testAddAll() {
        Collection<Integer> collection = new ArrayDeque<>();
        collection.add(3);
        collection.add(8);
        collection.add(2);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(5);
        actual.addAll(collection);
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(5);
        expected.add(3);
        expected.add(8);
        expected.add(2);
        Assert.assertEquals("DequeTest.testAddAll", expected, actual);
    }

    private static void testClear() {
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.clear();
        Deque<Integer> expected = new ArrayDeque<>();
        Assert.assertEquals("DequeTest.testClear", expected, actual);
    }

    private static void testRetainAll() {
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Collection<Integer> collection = new ArrayDeque<>();
        collection.add(5);
        collection.add(2);
        actual.retainAll(collection);
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(5);
        expected.add(2);
        expected.add(5);
        Assert.assertEquals("DequeTest.testRetainAll", expected, actual);
    }

    private static void testRemoveAll() {
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Collection<Integer> collection = new ArrayDeque<>();
        collection.add(5);
        collection.add(2);
        actual.removeAll(collection);
        Deque<Integer> expected = new ArrayDeque<>();
        expected.add(3);
        expected.add(7);
        Assert.assertEquals("DequeTest.testRemoveAll", expected, actual);
    }

    private static void testContainsAll() {
        Collection<Integer> collection = new ArrayDeque<>();
        collection.add(3);
        collection.add(5);
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(3);
        actual.add(9);
        Assert.assertEquals("DequeTest.testContainsAll", true, actual.containsAll(collection));
    }

    private static void testContains() {
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        Assert.assertEquals("DequeTest.testContains", true, actual.contains(3));
    }


    private static void testSize() {
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(1);
        actual.add(1);
        actual.add(1);
        Assert.assertEquals("DequeTest.testSize", 3, actual.size());
    }

    private static void testIsEmpty() {
        Deque<Integer> actual = new ArrayDeque<>();
        Assert.assertEquals("DequeTest.testIsEmpty", true, actual.isEmpty());
    }

    private static void testIterator() {
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Iterator iterator = actual.iterator();
        Assert.assertEquals("DequeTest.testIterator", 3, (int) iterator.next());
    }

    private static void testToArray() {
        Deque<String> actual = new ArrayDeque<>();
        actual.add("3");
        actual.add("5");
        actual.add("2");
        String[] array = new String[3];
        array[0] = "3";
        array[1] = "5";
        array[2] = "2";
        Assert.assertEquals("DequeTest.testToArray", array, actual.toArray());
    }

    private static void testToArrayObject() {
        Deque<String> actual = new ArrayDeque<>();
        actual.add("3");
        actual.add("2");
        String[] expected = new String[2];
        expected[0] = "3";
        expected[1] = "2";
        Assert.assertEquals("DequeTest.testToArrayObject", expected, actual.toArray(new String[actual.size()]));
    }

    private static void testDescendingIterator() {
        Deque<Integer> actual = new ArrayDeque<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Iterator iterator = actual.descendingIterator();
        Assert.assertEquals("DequeTest.testDescendingIterator", 7, (int) iterator.next());
    }
}
