package datastructures.shavaleevar.datastructures.stack;

import datastructures.util.Assert;

import static datastructures.util.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

class LinkedListStackTest {
    public static void main(String[] args) {
        testPush();
        testPeek();
        testPop();
        testPopException();
        testAsList();
        testToString();
        testSize();
        testReverse();
        testReverseException();
    }

    private static void testPush() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(5);
        collection.add(7);
        Stack<Integer> actual = new LinkedListStack<>();
        actual.push(5);
        actual.push(7);
        actual.push(8);
        Stack<Integer> expected = new LinkedListStack<>(collection);
        assertEquals("LinkedListStackTest.testPushValues", 8, actual.pop());
        assertEquals("LinkedListStackTest.testPush",expected, actual);
    }

    private static void testPop() {
        Stack<Integer> expected = new LinkedListStack<>();
        expected.push(5);
        Stack<Integer> actual = new LinkedListStack<>();
        actual.push(5);
        actual.push(7);
        actual.push(8);
        actual.pop();
        assertEquals("LinkedListStackTest.testPopValues",7, actual.pop());
        assertEquals("LinkedListStackTest.testPop",expected, actual);
    }

    private static void testPopException() {
        try {
            Stack<Integer> stack = new LinkedListStack<>();
            stack.pop();
            Assert.fail("LinkedListStackTest.testPopException: failed");
        } catch (NoSuchElementException e) {
            Assert.assertEquals("LinkedListStackTest.testPopException", "Stack is empty", e.getMessage());
        }
    }

    private static void testAsList() {
        List<Integer> expected = new LinkedList<>();
        expected.add(7);
        expected.add(5);
        Stack<Integer> actual = new LinkedListStack<>();
        actual.push(7);
        actual.push(5);
        assertEquals("LinkedListStackTest.testAsList", expected, actual.asList());
    }

    private static void testSize() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(0);
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        Stack<Integer> actual = new LinkedListStack<>(collection);
        assertEquals("LinkedListStackTest.testSize", 6, actual.size());
    }

    private static void testToString() {
        Stack<Integer> actual = new LinkedListStack<>();
        actual.push(0);
        actual.push(1);
        actual.push(2);
        actual.push(3);
        actual.push(4);
        assertEquals("LinkedListStackTest.testToString", "[0, 1, 2, 3, 4]", actual.toString());
    }

    private static void testPeek() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(0);
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        Stack<Integer> actual = new LinkedListStack<>(collection);
        assertEquals("LinkedListStackTest.testPeek", 5, actual.peek());
    }


    private static void testReverse() {
        Stack<Integer> expected = new LinkedListStack<>();
        expected.push(0);
        expected.push(1);
        expected.push(2);
        expected.push(3);
        expected.push(4);
        expected.push(5);
        expected.push(6);
        expected.push(7);
        expected.push(8);
        expected.push(9);
        Stack<Integer> actual = new LinkedListStack<>();
        actual.push(9);
        actual.push(8);
        actual.push(7);
        actual.push(6);
        actual.push(5);
        actual.push(4);
        actual.push(3);
        actual.push(2);
        actual.push(1);
        actual.push(0);
        actual.reverse();
        assertEquals("LinkedListStackTest.testReverse", expected,actual);
    }

    private static void testReverseException() {
        try {
            LinkedListStack<String> actual = new LinkedListStack<>();
            actual.reverse();
            Assert.fail("LinkedListStackTest.testReverseException is failed: the exception hasn't been thrown");
        } catch (NoSuchElementException e) {
            Assert.assertEquals("LinkedListStackTest.testReverseException", "Stack is empty", e.getMessage());
        }
    }

}