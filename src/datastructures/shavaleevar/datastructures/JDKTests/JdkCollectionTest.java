package datastructures.shavaleevar.datastructures.JDKTests;

import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;

public class JdkCollectionTest {
    public static void main(String[] args) {
        testSize();
        testClear();
        testIsEmpty();
        testContains();
        testContainsAll();
        testToArray();
        testToArrayObject();
        testAdd();
        testAddAll();
        testRemove();
        testRemoveAll();
        testRemoveIf();
        testRetainAll();
        testIterator();
        testSpliterator();
    }

    private static void testSize() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(3);
        collection.add(5);
        Assert.assertEquals("CollectionTest.testSize", 2, collection.size());
    }

    private static void testClear() {
        Collection<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.clear();
        Collection<Integer> expected = new ArrayList<>();
        Assert.assertEquals("CollectionTest.testClear", expected, actual);
    }

    private static void testIsEmpty() {
        Collection<Integer> actual = new ArrayList<>();
        Assert.assertEquals("CollectionTest.testIsEmpty", true, actual.isEmpty());
    }

    private static void testContains() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(3);
        collection.add(5);
        Assert.assertEquals("CollectionTest.testContains", true, collection.contains(3));
    }

    private static void testContainsAll() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(3);
        collection.add(5);
        Collection<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(3);
        actual.add(9);
        Assert.assertEquals("CollectionTest.testContainsAll", true, actual.containsAll(collection));
    }

    private static void testToArray() {
        Collection<String> collection = new ArrayList<>();
        collection.add("3");
        collection.add("5");
        collection.add("2");
        String[] array = new String[3];
        array[0] = "3";
        array[1] = "5";
        array[2] = "2";
        Assert.assertEquals("CollectionTest.testToArray", array, collection.toArray());
    }

    private static void testToArrayObject() {
        Collection<String> collection = new ArrayList<>();
        collection.add("3");
        collection.add("2");
        String[] expected = new String[2];
        expected[0] = "3";
        expected[1] = "2";
        Assert.assertEquals("CollectionTest.testToArrayObject", expected, collection.toArray(new String[collection.size()]));
    }

    private static void testAdd() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(5);
        Assert.assertEquals("CollectionTest.testAdd", true, collection.contains(5));
    }

    private static void testAddAll() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(3);
        collection.add(8);
        collection.add(2);
        Collection<Integer> actual = new ArrayList<>();
        actual.add(5);
        actual.addAll(collection);
        Collection<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(3);
        expected.add(8);
        expected.add(2);
        Assert.assertEquals("CollectionTest.testAddAll", expected, actual);
    }

    private static void testRemove() {
        Collection<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.remove(5);
        Collection<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(2);
        Assert.assertEquals("CollectionTest.testRemove", expected, actual);
    }

    private static void testRemoveAll() {
        Collection<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Collection<Integer> collection = new ArrayList<>();
        collection.add(5);
        collection.add(2);
        actual.removeAll(collection);
        Collection<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(7);
        Assert.assertEquals("CollectionTest.testRemoveAll", expected, actual);
    }

    private static void testRemoveIf() {
        Collection<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(50);
        actual.add(20);
        actual.add(5);
        actual.removeIf(number -> number > 10);
        Collection<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(5);
        Assert.assertEquals("CollectionTest.testRemoveIf", expected, actual);
    }

    private static void testRetainAll() {
        Collection<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Collection<Integer> collection = new ArrayList<>();
        collection.add(5);
        collection.add(2);
        actual.retainAll(collection);
        Collection<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(2);
        expected.add(5);
        Assert.assertEquals("CollectionTest.testRetainAll", expected, actual);
    }

    private static void testIterator() {
        Collection<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Iterator iterator = actual.iterator();
        Assert.assertEquals("CollectionTest.testIterator", 3, (int) iterator.next());
    }

    private static void testSpliterator() {
        Collection<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Spliterator spliterator = actual.spliterator();
        Assert.assertEquals("CollectionTest.testSpliterator", (long) 5, spliterator.estimateSize());
    }
}
