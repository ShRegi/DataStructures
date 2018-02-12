package datastructures.shavaleevar.datastructures.linkedlist;

import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
        testSet();
        testSetException();
        testGet();
        testGetException();
        testSize();
        testIndexOf();
        testAddObject();
        testAddBeginning();
        testAddMiddle();
        testAddEnd();
        testAddException();
        testRemoveObject();
        testRemoveBeginning();
        testRemoveMiddle();
        testRemoveEnd();
        testRemoveException();
        testContains();
        testToArray();
    }

    private static void testSet() {
        List<Integer> expected = new DoublyLinkedList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(33);
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
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        Assert.assertEquals("DoublyLinkedListTest.testSetReturnValue", 3,actual.set(3, 33));
        Assert.assertEquals("DoublyLinkedListTest.testSet", expected, actual);
    }

    private static void testSetException() {
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
        try {
            actual.set(18, 2);
            Assert.fail("DoublyLinkedListTest.testSetException");
        } catch (Exception e) {
            Assert.assertEquals("DoublyLinkedListTest.testSetException", "Illegal Index: 18", e.getMessage());
        }
    }

    private static void testGet() {
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
        Assert.assertEquals("DoublyLinkedListTest.testGet", 8, actual.get(8));
    }

    private static void testGetException() {
        try {
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
            int value = actual.get(15);
            Assert.fail("DoublyLinkedListTest.testGetException");
        } catch (Exception e) {
            Assert.assertEquals("DoublyLinkedListTest.testGetException", "Illegal Index: 15", e.getMessage());
        }
    }

    private static void testSize() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(0);
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        collection.add(6);
        collection.add(7);
        collection.add(8);
        collection.add(9);
        List<Integer> actual = new DoublyLinkedList<>(collection);
        Assert.assertEquals("DoublyLinkedListTest.testSize", 10, actual.size());
    }

    private static void testIndexOf() {
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
        Assert.assertEquals("DoublyLinkedListTest.testIndexOf", 5, actual.indexOf(5));
    }

    private static void testAddObject() {
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
        Assert.assertEquals("DoublyLinkedListTest.testAddObjectReturnValue", true, actual.add(10));
        Assert.assertEquals("DoublyLinkedListTest.testAddObject", actual, expected);
    }

    private static void testAddBeginning() {
        List<Integer> expected = new DoublyLinkedList<>();
        expected.add(55);
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
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        actual.add(0, 55);
        Assert.assertEquals("DoublyLinkedListTest.testAddBeginning", actual, expected);
    }

    private static void testAddMiddle() {
        List<Integer> expected = new DoublyLinkedList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(55);
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
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        actual.add(4, 55);
        Assert.assertEquals("DoublyLinkedListTest.testAddMiddle", actual, expected);
    }

    private static void testAddEnd() {
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
        expected.add(55);
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
        actual.add(10, 55);
        Assert.assertEquals("DoublyLinkedListTest.testAddEnd", actual, expected);
    }

    private static void testAddException() {
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
        try {
            actual.add(25, 5);
            Assert.fail("DoublyLinkedListTest.testAddException");
        } catch (Exception e) {
            Assert.assertEquals("DoublyLinkedListTest.testAddException", "Illegal Index: 25", e.getMessage());
        }
    }

    private static void testRemoveObject() {
        List<Integer> expected = new DoublyLinkedList<>();
        expected.add(0);
        expected.add(1);
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
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        Assert.assertEquals("DoublyLinkedListTest.testRemoveObjectReturnValue", true, actual.remove((Integer) 2));
        Assert.assertEquals("DoublyLinkedListTest.testRemoveObject", actual, expected);
    }

    private static void testRemoveBeginning() {
        List<Integer> expected = new DoublyLinkedList<>();
        expected.add(0);
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(2);
        expected.add(3);
        expected.add(3);
        expected.add(4);
        expected.add(4);
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(0);
        actual.add(1);
        actual.add(1);
        actual.add(2);
        actual.add(2);
        actual.add(3);
        actual.add(3);
        actual.add(4);
        actual.add(4);
        Assert.assertEquals("DoublyLinkedListTest.testRemoveBeginningReturnValue", 0, actual.remove(0));
        Assert.assertEquals("DoublyLinkedListTest.testRemoveBeginning", actual, expected);
    }

    private static void testRemoveMiddle() {
        List<Integer> expected = new DoublyLinkedList<>();
        expected.add(0);
        expected.add(0);
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(3);
        expected.add(4);
        expected.add(4);
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(0);
        actual.add(1);
        actual.add(1);
        actual.add(5);
        actual.add(2);
        actual.add(3);
        actual.add(3);
        actual.add(4);
        actual.add(4);
        Assert.assertEquals("DoublyLinkedListTest.testRemoveMiddleReturnValue", 5, actual.remove(4));
        Assert.assertEquals("DoublyLinkedListTest.testRemoveMiddle", actual, expected);
    }

    private static void testRemoveEnd() {
        List<Integer> expected = new DoublyLinkedList<>();
        expected.add(0);
        expected.add(0);
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(2);
        expected.add(3);
        expected.add(3);
        expected.add(4);
        List<Integer> actual = new DoublyLinkedList<>();
        actual.add(0);
        actual.add(0);
        actual.add(1);
        actual.add(1);
        actual.add(2);
        actual.add(2);
        actual.add(3);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        Assert.assertEquals("DoublyLinkedListTest.testRemoveEndReturnValue", 5, actual.remove(9));
        Assert.assertEquals("DoublyLinkedListTest.testRemoveEnd", expected, actual);
    }

    private static void testRemoveException() {
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
        try {
            actual.remove(24);
            Assert.fail("DoublyLinkedListTest.testRemoveException");
        } catch (Exception e) {
            Assert.assertEquals("DoublyLinkedListTest.testRemoveException", "Illegal Index: 24", e.getMessage());
        }
    }

    private static void testContains() {
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
        Assert.assertEquals("DoublyLinkedListTest.testContains", true, actual.contains(9));
    }

    private static void testToArray() {
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
        Integer[] expectedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assert.assertEquals("DoublyLinkedListTest.testToArray", expectedArray, actual.toArray());
    }
}
