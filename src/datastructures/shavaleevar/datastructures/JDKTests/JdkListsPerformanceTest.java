package datastructures.shavaleevar.datastructures.JDKTests;

import datastructures.util.StopWatch;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JdkListsPerformanceTest {
    private static final int TEST_COUNT = 200000;
    private static final int ARRAY_LENGTH = 3000000;
    private static final int HALF_ARRAY = ARRAY_LENGTH / 2;
    private static final int STOP_COUNT = TEST_COUNT + HALF_ARRAY;

    public static void main(String[] args) {
        testAddBeginningArrayListTime();
        testAddBeginningLinkedListTime();
        testAddMiddleArrayListTime();
        testAddMiddleLinkedListTime();
        testAddEndArrayListTime();
        testAddEndLinkedListTime();
        testRemoveBeginningArrayListTime();
        testRemoveBeginningLinkedListTime();
        testRemoveMiddleArrayListTime();
        testRemoveMiddleLinkedListTime();
        testRemoveEndArrayListTime();
        testRemoveEndLinkedListTime();
    }

    private static void testAddBeginningArrayListTime() {
        List<Integer> arrayList = new ArrayList<>();
        StopWatch timer = new StopWatch();

        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            arrayList.add(0, 0);
        }
        System.out.println("JdkListsPerformanceTest.testAddBeginningTime" + System.lineSeparator() + arrayList.getClass() + " add: " + timer.getElapsedTime());
    }

    private static void testAddBeginningLinkedListTime() {
        List<Integer> linkedList = new LinkedList<>();
        StopWatch timer = new StopWatch();

        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            linkedList.add(0, 0);
        }
        System.out.println(linkedList.getClass() + " add: " + timer.getElapsedTime());
    }

    private static void testAddMiddleArrayListTime() {
        List<Integer> arrayList = new ArrayList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            arrayList.add(i, 0);
        }

        timer.start();
        for (int i = HALF_ARRAY; i < STOP_COUNT; i++) {
                arrayList.add(i, 0);
        }
        System.out.println("JdkListsPerformanceTest.testAddMiddleTime" + System.lineSeparator() + arrayList.getClass() + " add: " + timer.getElapsedTime());
    }

    private static void testAddMiddleLinkedListTime() {
        List<Integer> linkedList = new LinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            linkedList.add(i, 0);
        }
        timer.start();
        for (int i = HALF_ARRAY; i < STOP_COUNT; i++) {
            linkedList.add(i, 0);
        }
        System.out.println(linkedList.getClass() + " add: " + timer.getElapsedTime());
    }

    private static void testAddEndArrayListTime() {
        List<Integer> arrayList = new ArrayList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < 1; i++) {
            arrayList.add(i, 0);
        }

        timer.start();
        for (int i = 1; i < TEST_COUNT; i++) {
            arrayList.add(i, 0);
        }
        System.out.println("JdkListsPerformanceTest.testAddEndTime" + System.lineSeparator() + arrayList.getClass() + " add: " + timer.getElapsedTime());

    }

    private static void testAddEndLinkedListTime() {
        List<Integer> linkedList = new LinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < 1; i++) {
            linkedList.add(i, 0);
        }

        timer.start();
        for (int i = 1; i < TEST_COUNT; i++) {
            linkedList.add(i, 0);
        }
        System.out.println(linkedList.getClass() + " add: " + timer.getElapsedTime());
    }

    private static void testRemoveBeginningArrayListTime() {
        List<Integer> arrayList = new ArrayList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < TEST_COUNT; i++) {
            arrayList.add(i, 0);
        }

        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            arrayList.remove(0);
        }
        System.out.println("JdkListsPerformanceTest.testRemoveBeginningTime" + System.lineSeparator() + arrayList.getClass() + " remove: " + timer.getElapsedTime());
    }

    private static void testRemoveBeginningLinkedListTime() {
        List<Integer> linkedList = new LinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < TEST_COUNT; i++) {
            linkedList.add(i, 0);
        }

        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            linkedList.remove(0);
        }
        System.out.println(linkedList.getClass() + " remove: " + timer.getElapsedTime());
    }

    private static void testRemoveMiddleArrayListTime() {
        List<Integer> arrayList = new ArrayList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            arrayList.add(i, 0);
        }

        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            arrayList.remove(HALF_ARRAY);
        }
        System.out.println("JdkListsPerformanceTest.testRemoveMiddleTime" + System.lineSeparator() + arrayList.getClass() + " remove: " + timer.getElapsedTime());
    }

    private static void testRemoveMiddleLinkedListTime() {
        List<Integer> linkedList = new LinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            linkedList.add(i, 0);
        }

        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            linkedList.remove(HALF_ARRAY);
        }
        System.out.println(linkedList.getClass() + " remove: " + timer.getElapsedTime());
    }

    private static void testRemoveEndArrayListTime() {
        List<Integer> arrayList = new ArrayList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            arrayList.add(i, 0);
        }

        timer.start();
        for (int i = HALF_ARRAY; i < STOP_COUNT; i++) {
            arrayList.remove(HALF_ARRAY);
        }
        System.out.println("JdkListsPerformanceTest.testRemoveEndTime" + System.lineSeparator() + arrayList.getClass() + " remove: " + timer.getElapsedTime());
    }

    private static void testRemoveEndLinkedListTime() {
        List<Integer> linkedList = new LinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            linkedList.add(i, 0);
        }

        timer.start();
        for (int i = HALF_ARRAY; i < STOP_COUNT; i++) {
            linkedList.remove(HALF_ARRAY);
        }
        System.out.println(linkedList.getClass() + " remove: " + timer.getElapsedTime());
    }
}
