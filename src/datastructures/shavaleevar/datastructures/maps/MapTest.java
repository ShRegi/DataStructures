package datastructures.shavaleevar.datastructures.maps;

import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        testSize();
        testIsEmpty();
        testContainsKey();
        testContainsValue();
        testGet();
        testPut();
        testRemove();
        testPutAll();
        testClear();
        testKeySet();
        testValues();
    }

    private static void testSize() {
        Map<String, Integer> actual = new HashMap<>();
        actual.put("a", 1);
        actual.put("b", 2);
        actual.put("c", 3);
        actual.put("d", 4);
        actual.put("e", 5);
        Assert.assertEquals("MapTest.testSize", 5, actual.size());
    }

    private static void testIsEmpty() {
        Map<String, Integer> actual = new HashMap<>();
        Assert.assertEquals("MapTest.testIsEmpty", true, actual.isEmpty());
    }

    private static void testContainsKey() {
        Map<String, Integer> actual = new HashMap<>();
        actual.put("a", 1);
        actual.put("b", 2);
        actual.put("c", 3);
        actual.put("d", 4);
        actual.put("e", 5);
        Assert.assertEquals("MapTest.testContainsKey", true, actual.containsKey("d"));
    }

    private static void testContainsValue() {
        Map<String, Integer> actual = new HashMap<>();
        actual.put("a", 1);
        actual.put("b", 2);
        actual.put("c", 3);
        actual.put("d", 4);
        actual.put("e", 5);
        Assert.assertEquals("MapTest.testContainsValue", true, actual.containsValue(3));
    }

    private static void testGet() {
        Map<String, Integer> actual = new HashMap<>();
        actual.put("a", 1);
        actual.put("b", 2);
        actual.put("c", 3);
        actual.put("d", 4);
        actual.put("e", 5);
        Assert.assertEquals("MapTest.testGet", 4, actual.get("d"));
    }

    private static void testPut() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 1);
        expected.put("b", 2);
        expected.put("c", 3);
        expected.put("d", 4);
        Map<String, Integer> actual = new HashMap<>();
        actual.put("a", 1);
        actual.put("b", 2);
        actual.put("c", 3);
        actual.put("d", 4);
        Assert.assertEquals("MapTest.testPut", expected, actual);
    }

    private static void testRemove() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 1);
        expected.put("b", 2);
        expected.put("c", 3);
        Map<String, Integer> actual = new HashMap<>();
        actual.put("a", 1);
        actual.put("b", 2);
        actual.put("c", 3);
        actual.put("d", 4);
        actual.remove("d");
        Assert.assertEquals("MapTest.testRemove", expected, actual);
    }

    private static void testPutAll() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 1);
        expected.put("b", 2);
        expected.put("c", 3);
        expected.put("d", 4);
        Map<String, Integer> actual = new HashMap<>();
        actual.putAll(map);
        Assert.assertEquals("MapTest.testPutAll", expected, actual);
    }

    private static void testClear() {
        Map<String, Integer> actual = new HashMap<>();
        actual.put("a", 1);
        actual.put("b", 2);
        actual.put("c", 3);
        actual.clear();
        Assert.assertEquals("MapTest.testClear", true, actual.isEmpty());
    }

    private static void testKeySet() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        Collection<String> actual = map.keySet();
        Collection<String> expected = new HashSet<>();
        expected.add("a");
        expected.add("b");
        expected.add("c");
        expected.add("d");
        expected.add("e");
        Assert.assertEquals("MapTest.testKeySet", expected, actual);
    }

    private static void testValues() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        Collection<Integer> actual = map.values();
        Collection<Integer> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        Assert.assertEquals("MapTest.testValues", expected, actual);
    }
}
