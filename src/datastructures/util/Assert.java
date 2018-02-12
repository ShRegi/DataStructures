package datastructures.util;

import datastructures.shavaleevar.datastructures.linkedlist.DoublyLinkedList;
import datastructures.shavaleevar.datastructures.dynamicarray.DynamicArray;
import datastructures.shavaleevar.datastructures.queue.LinkedListQueue;
import datastructures.shavaleevar.datastructures.stack.Stack;
import datastructures.shavaleevar.datastructures.maps.AssociativeArray;

import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Assert {
    public static void assertEquals(String testName, int expected, int actual) {
        if (expected == actual) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void assertEquals(String testName, String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void assertEquals(String testName, boolean expected, boolean actual) {
        if (expected == actual) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void fail(String testName) {
        System.out.println(testName + " is failed. Exception hasn't been thrown");
    }

    public static void assertEquals(String testName, Object[] expected, Object[] actual) {
        if (Arrays.equals(expected, actual)) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + Arrays.toString(actual) + " expected is " + Arrays.toString(expected));
        }
    }

    public static void assertEquals(String testName, DynamicArray expected, DynamicArray actual) {
        if (expected.equals(actual)) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void assertEquals(String testName, List expected, List actual) {
        if (expected.equals(actual)) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void assertEquals(String testName, Collection expected, Collection actual) {
        if (expected.equals(actual)) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void assertEquals(String testName, DoublyLinkedList expected, DoublyLinkedList actual) {
        if (expected.equals(actual)) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void assertEquals(String testName, long expected, long actual) {
        if (actual == expected) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void assertEquals(String testName, Stack expected, Stack actual) {
        if (expected.asList().equals(actual.asList())) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void assertEquals(String testName, LinkedListQueue expected, LinkedListQueue actual) {
        if (expected.asList().equals(actual.asList())) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void assertEquals(String testName, Queue expected, Queue actual) {
        if (Arrays.equals(expected.toArray(), actual.toArray())) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void assertEquals(String testName, Deque expected, Deque actual) {
        if (Arrays.equals(expected.toArray(), actual.toArray())) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void assertEquals(String testName, AssociativeArray expected, AssociativeArray actual) {
        if (expected.equals(actual)) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }

    public static void assertEquals(String testName, Map expected, Map actual) {
        if (expected.equals(actual)) {
            System.out.println(testName + " is passed");
        } else {
            System.out.println(testName + " is failed: actual is " + actual + " expected is " + expected);
        }
    }
}
