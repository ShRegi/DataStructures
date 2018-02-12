package datastructures.shavaleevar.datastructures.dynamicarray;

import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DynamicArrayTest {
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
        testToString();
        testEquals();
    }

    private static void testSet() {
        List<Integer> expected = new DynamicArray<>();
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
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testSetReturnValue", 3, actual.set(3, 33));
        Assert.assertEquals("DynamicArrayTest.testSet", expected, actual);
    }

    private static void testSetException() {
        List<Integer> actual = new DynamicArray<>();
        actual.add(0);
        actual.add(1);
        actual.add(2);
        actual.add(3);
        try {
            actual.set(18, 2);
            Assert.fail("DynamicArrayTest.testSetException");
        } catch (Exception e) {
            Assert.assertEquals("DynamicArrayTest.testSetException", "Illegal Index: 18", e.getMessage());
        }
    }

    private static void testGet() {
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testGet", 8, actual.get(8));
    }

    private static void testGetException() {
        try {
            List<Integer> actual = new DynamicArray<>();
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
            Assert.fail("DynamicArrayTest.testGetException");
        } catch (Exception e) {
            Assert.assertEquals("DynamicArrayTest.testGetException", "Illegal Index: 15", e.getMessage());
        }
    }

    private static void testSize() {
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testSize", 10, actual.size());
    }

    private static void testIndexOf() {
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testIndexOf", 5, actual.indexOf(5));
    }

    private static void testAddObject() {
        List<Integer> expected = new DynamicArray<>();
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
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testAddObjectReturnValue", true, actual.add(10));
        Assert.assertEquals("DynamicArrayTest.testAddObject", expected, actual);
    }

    private static void testAddBeginning() {
        List<Integer> expected = new DynamicArray<>();
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
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testAddBeginning", expected, actual);
    }

    private static void testAddMiddle() {
        List<Integer> expected = new DynamicArray<>();
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
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testAddMiddle", expected, actual);
    }

    private static void testAddEnd() {
        List<Integer> expected = new DynamicArray<>();
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
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testAddEnd", expected, actual);
    }

    private static void testAddException() {
        List<Integer> actual = new DynamicArray<>();
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
            Assert.fail("DynamicArrayTest.testAddException");
        } catch (Exception e) {
            Assert.assertEquals("DynamicArrayTest.testAddException", "Illegal Index: 25", e.getMessage());
        }
    }

    private static void testRemoveObject() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(0);
        collection.add(1);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        collection.add(6);
        collection.add(7);
        collection.add(8);
        collection.add(9);
        List<Integer> actual = new DynamicArray<>();
        actual.add(0);
        actual.add(1);
        actual.add(5);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        actual.add(9);
        List<Integer> expected = new DynamicArray<>(collection);
        Assert.assertEquals("DynamicArrayTest.testRemoveObjectReturnValue", true, actual.remove((Integer) 5));
        Assert.assertEquals("DynamicArrayTest.testRemoveObject", expected, actual);
    }

    private static void testRemoveBeginning() {
        List<Integer> expected = new DynamicArray<>();
        expected.add(0);
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(2);
        expected.add(3);
        expected.add(3);
        expected.add(4);
        expected.add(4);
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testRemoveBeginningReturnValue", 0, actual.remove(0));
        Assert.assertEquals("DynamicArrayTest.testRemoveBeginning", expected, actual);
    }

    private static void testRemoveMiddle() {
        List<Integer> expected = new DynamicArray<>();
        expected.add(0);
        expected.add(0);
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(3);
        expected.add(4);
        expected.add(4);
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testRemoveMiddleReturnValue", 5, actual.remove(4));
        Assert.assertEquals("DynamicArrayTest.testRemoveMiddle", expected, actual);
    }

    private static void testRemoveEnd() {
        List<Integer> expected = new DynamicArray<>();
        expected.add(0);
        expected.add(0);
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(2);
        expected.add(3);
        expected.add(3);
        expected.add(4);
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testRemoveEndReturnValue", 5, actual.remove(9));
        Assert.assertEquals("DynamicArrayTest.testRemoveEnd", expected, actual);
    }

    private static void testRemoveException() {
        List<Integer> actual = new DynamicArray<>(10);
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
            Assert.fail("DynamicArrayTest.testRemoveException");
        } catch (Exception e) {
            Assert.assertEquals("DynamicArrayTest.testRemoveException", "Illegal Index: 24", e.getMessage());
        }
    }

    private static void testContains() {
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testContains", true, actual.contains(9));
    }

    private static void testToArray() {
        List<Integer> actual = new DynamicArray<>();
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
        Object[] expectedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assert.assertEquals("DynamicArrayTest.testToArray", expectedArray, actual.toArray());
    }

    private static void testToString() {
        List<Integer> actual = new DynamicArray<>();
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
        String expected = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]";
        Assert.assertEquals("DynamicArrayTest.testToString", expected, actual.toString());
    }

    private static void testEquals() {
        List<Integer> expected = new DynamicArray<>();
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
        List<Integer> actual = new DynamicArray<>();
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
        Assert.assertEquals("DynamicArrayTest.testEquals", true, actual.equals(expected));
    }
}
