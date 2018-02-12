package datastructures.shavaleevar.datastructures.maps;

import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class SetTest {
    public static void main(String[] args) {
        testAdd();
        testAddAll();
        testAddLinkedSet();
        testAddAllLinkedSet();
    }

    private static void testAdd() {
        Collection<String> expected = new HashSet<>();
        expected.add("a");
        expected.add("b");
        expected.add("c");
        expected.add("d");
        Collection<String> actual = new HashSet<>();
        actual.add("a");
        actual.add("b");
        actual.add("c");
        actual.add("d");
        Assert.assertEquals("SetTest.testAdd", expected, actual);
    }

    private static void testAddAll() {
        Collection<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        Collection<String> expected = new HashSet<>();
        expected.add("a");
        expected.add("b");
        expected.add("c");
        expected.add("d");
        Collection<String> actual = new HashSet<>();
        expected.add("a");
        actual.addAll(set);
        Assert.assertEquals("SetTest.testAddAll", expected, actual);
    }

    private static void testAddLinkedSet() {
        Collection<String> expected = new LinkedHashSet<>();
        expected.add("a");
        expected.add("b");
        expected.add("c");
        expected.add("d");
        Collection<String> actual = new LinkedHashSet<>();
        actual.add("a");
        actual.add("b");
        actual.add("c");
        actual.add("d");
        Assert.assertEquals("SetTest.testAddLinkedSet", expected, actual);
    }

    private static void testAddAllLinkedSet() {
        Collection<String> set = new LinkedHashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        Collection<String> expected = new LinkedHashSet<>();
        expected.add("a");
        expected.add("b");
        expected.add("c");
        expected.add("d");
        Collection<String> actual = new LinkedHashSet<>();
        expected.add("a");
        actual.addAll(set);
        Assert.assertEquals("SetTest.testAddAllLinkedSet", expected, actual);
    }
}
