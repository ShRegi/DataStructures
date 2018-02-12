package datastructures.shavaleevar.datastructures.JDKTests;

import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

public class JdkListTest {
    public static void main(String[] args) {
        testAdd();
        testAddAll();
        testAddAllException();
        testGet();
        testGetException();
        testSet();
        testSetException();
        testRemove();
        testRemoveException();
        testIndexOf();
        testLastIndexOf();
        testListIterator();
        testListIteratorIndex();
        testReplaceAll();
        testSort();
        testSubList();
    }

    private static void testListIterator() {
        List<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        ListIterator iterator = actual.listIterator();
        Assert.assertEquals("JdkListTest.testListIterator", 3, (int) iterator.next());
    }

    private static void testListIteratorIndex() {
        List<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        ListIterator iterator = actual.listIterator(3);
        Assert.assertEquals("JdkListTest.testListIterator", 5, (int) iterator.next());
    }

    private static void testGet() {
        List<String> list = new ArrayList<>();
        list.add("3");
        list.add("5");
        list.add("2");
        Assert.assertEquals("JdkListTest.testGet", "3", list.get(0));
    }

    private static void testGetException() {
        try {
            List<Integer> actual = new ArrayList<>();
            actual.add(3);
            int value = actual.get(5);
            Assert.fail("JdkListTest.testGetException");
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals("JdkListTest.testGetException", "Index: 5, Size: 0", e.getMessage());
        }
    }

    private static void testSet() {
        List<String> actual = new ArrayList<>();
        actual.add("3");
        actual.add("5");
        actual.add("2");
        actual.set(1, "8");
        List<String> expected = new ArrayList<>();
        expected.add("3");
        expected.add("8");
        expected.add("2");
        Assert.assertEquals("JdkListTest.testSet", expected, actual);
    }

    private static void testSetException() {
        try {
            List<Integer> actual = new ArrayList<>();
            actual.set(5, 6);
            Assert.fail("JdkListTest.testSetException");
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals("JdkListTest.testSetException", "Index: 5, Size: 0", e.getMessage());
        }
    }

    private static void testRemove() {
        List<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.remove(0);
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(2);
        Assert.assertEquals("JdkListTest.testRemove", expected, actual);
    }

    private static void testRemoveException() {
        try {
            List<Integer> actual = new ArrayList<>();
            actual.add(4);
            actual.add(5);
            actual.remove(5);
            Assert.fail("JdkListTest.testRemoveException");
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals("JdkListTest.testRemoveException", "Index: 5, Size: 1", e.getMessage());
        }
    }

    private static void testAdd() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(5);
        expected.add(7);
        expected.add(2);
        expected.add(5);
        List<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(2, 7);
        Assert.assertEquals("JdkListTest.testAdd", actual, expected);
    }

    private static void testAddAll() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(3);
        collection.add(8);
        collection.add(2);
        List<Integer> actual = new ArrayList<>();
        actual.add(5);
        actual.addAll(1, collection);
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(3);
        expected.add(8);
        expected.add(2);
        Assert.assertEquals("JdkListTest.testAddAll", expected, actual);
    }

    private static void testAddAllException() {
        try {
            Collection<Integer> collection = new ArrayList<>();
            collection.add(1);
            List<Integer> actual = new ArrayList<>();
            actual.add(5);
            actual.addAll(-1, collection);
            Assert.fail("JdkListTest.testAddAllException");
        } catch (IndexOutOfBoundsException e) {
            Assert.assertEquals("JdkListTest.testAddAllException", "Index: -1, Size: 0", e.getMessage());
        }
    }

    private static void testIndexOf() {
        List<String> list = new ArrayList<>();
        list.add("3");
        list.add("5");
        list.add("2");
        Assert.assertEquals("JdkListTest.testGet", 1, list.indexOf("5"));
    }

    private static void testLastIndexOf() {
        List<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Assert.assertEquals("JdkListTest.testLastIndexOf", 3, actual.lastIndexOf(5));
    }

    private static void testReplaceAll() {
        List<Integer> expected = new ArrayList<>();
        expected.add(30);
        expected.add(50);
        expected.add(20);
        expected.add(50);
        expected.add(70);
        List<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        UnaryOperator<Integer> operator = integer -> integer * 10;
        actual.replaceAll(operator);
        Assert.assertEquals("JdkListTest.testReplaceAll", actual, expected);
    }

    private static void testSort() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        expected.add(5);
        expected.add(5);
        expected.add(7);
        List<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(5);
        actual.add(2);
        actual.add(5);
        actual.add(7);
        Comparator<Integer> comparator = Integer::compareTo ;
        actual.sort(comparator);
        Assert.assertEquals("JdkListTest.testSort", actual, expected);
    }

    private static void testSubList() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(5);
        expected.add(7);
        List<Integer> originalList = new ArrayList<>();
        originalList.add(3);
        originalList.add(5);
        originalList.add(2);
        originalList.add(5);
        originalList.add(7);
        List<Integer> actual = originalList.subList(2, originalList.size());
        Assert.assertEquals("JdkListTest.testSubList", actual, expected);
    }
}
