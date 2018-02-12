package datastructures.shavaleevar.datastructures.dynamicarray;

import datastructures.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

public class DynamicArrayPerformanceTest {
    private static final int ARRAY_LENGTH = 10000000;
    private static final int HALF_ARRAY_LENGTH = ARRAY_LENGTH / 2;
    private static final int TEST_COUNT = 150000;
    private static final int END_ARRAY_LENGTH = ARRAY_LENGTH - TEST_COUNT;
    private static final int REMOVE_LENGTH = 1000000;
    private static final int REMOVE_TEST_COUNT = TEST_COUNT / 10;
    private static final int REMOVE_HALF_ARRAY_LENGTH = REMOVE_LENGTH / 2;
    private static final int HUGE_ARRAY_LENGTH = 320000000;

    public static void main(String[] args) {
        testAddBeginningTime();
        testAddMiddleTime();
        testAddEndTime();
        testRemoveBeginningTime();
        testRemoveMiddleTime();
        testRemoveEndTime();
    }

    private static void testAddBeginningTime() {
        DynamicArray dynamicArray = new DynamicArray(ARRAY_LENGTH);
        List<Object> arrayList = new ArrayList<>(ARRAY_LENGTH);
        StopWatch timer = new StopWatch();

        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            arrayList.add(0, 0);
        }
        System.out.println("DynamicArrayPerformanceTest.testAddBeginningTime" + System.lineSeparator() + arrayList.getClass() + " add: " + timer.getElapsedTime());

        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            dynamicArray.add(0, 0);
        }
        System.out.println(dynamicArray.getClass() + " add: " + timer.getElapsedTime());
    }

    private static void testAddMiddleTime() {
        DynamicArray dynamicArray = new DynamicArray(ARRAY_LENGTH);
        for (int i = 0; i < HALF_ARRAY_LENGTH; i++) {
            dynamicArray.add(i, 0);
        }
        List<Object> arrayList = new ArrayList<>(ARRAY_LENGTH);
        for (int i = 0; i < HALF_ARRAY_LENGTH; i++) {
            arrayList.add(i, 0);
        }
        StopWatch timer = new StopWatch();
        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            arrayList.add(HALF_ARRAY_LENGTH, 0);
        }
        System.out.println("DynamicArrayPerformanceTest.testAddMiddleTime" + System.lineSeparator() + arrayList.getClass() + " add: " + timer.getElapsedTime());

        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            dynamicArray.add(HALF_ARRAY_LENGTH, 0);
        }
        System.out.println(dynamicArray.getClass() + " add: " + timer.getElapsedTime());
    }

    private static void testAddEndTime() {
        DynamicArray dynamicArray = new DynamicArray(ARRAY_LENGTH);
        for (int i = 0; i < END_ARRAY_LENGTH; i++) {
            dynamicArray.add(i, 0);
        }
        List<Object> arrayList = new ArrayList<>(ARRAY_LENGTH);
        for (int i = 0; i < END_ARRAY_LENGTH; i++) {
            arrayList.add(i, 0);
        }
        StopWatch timer = new StopWatch();
        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            arrayList.add(END_ARRAY_LENGTH, 0);
        }
        System.out.println("DynamicArrayPerformanceTest.testAddEndTime" + System.lineSeparator() + arrayList.getClass() + " add: " + timer.getElapsedTime());

        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            dynamicArray.add(END_ARRAY_LENGTH, 0);
        }
        System.out.println(dynamicArray.getClass() + " add: " + timer.getElapsedTime());
    }

    private static void testRemoveBeginningTime() {
        DynamicArray dynamicArray = new DynamicArray(REMOVE_LENGTH);
        for (int i = 0; i < REMOVE_LENGTH; i++) {
            dynamicArray.add(i, 0);
        }
        List<Object> arrayList = new ArrayList<>(REMOVE_LENGTH);
        for (int i = 0; i < REMOVE_LENGTH; i++) {
            arrayList.add(i, 0);
        }
        StopWatch timer = new StopWatch();

        timer.start();
        for (int i = 0; i < REMOVE_TEST_COUNT; i++) {
            arrayList.remove(0);
        }
        System.out.println("DynamicArrayPerformanceTest.testRemoveBeginningTime" + System.lineSeparator() + arrayList.getClass() + " remove: " + timer.getElapsedTime());

        timer.start();
        for (int i = 0; i < REMOVE_TEST_COUNT; i++) {
            dynamicArray.remove(0);
        }
        System.out.println(dynamicArray.getClass() + " remove: " + timer.getElapsedTime());
    }

    private static void testRemoveMiddleTime() {
        DynamicArray dynamicArray = new DynamicArray(REMOVE_LENGTH);
        for (int i = 0; i < REMOVE_LENGTH; i++) {
            dynamicArray.add(i, 0);
        }
        List<Object> arrayList = new ArrayList<>(REMOVE_LENGTH);
        for (int i = 0; i < REMOVE_LENGTH; i++) {
            arrayList.add(i, 0);
        }
        StopWatch timer = new StopWatch();
        timer.start();
        for (int i = 0; i < REMOVE_TEST_COUNT; i++) {
            arrayList.remove(REMOVE_HALF_ARRAY_LENGTH);
        }
        System.out.println("DynamicArrayPerformanceTest.testRemoveMiddleTime" + System.lineSeparator() + arrayList.getClass() + " remove: " + timer.getElapsedTime());

        timer.start();
        for (int i = 0; i < REMOVE_TEST_COUNT; i++) {
            dynamicArray.remove(REMOVE_HALF_ARRAY_LENGTH);
        }
        System.out.println(dynamicArray.getClass() + " remove: " + timer.getElapsedTime());
    }

    private static void testRemoveEndTime() {
        DynamicArray dynamicArray = new DynamicArray(HUGE_ARRAY_LENGTH);
        for (int i = 0; i < HUGE_ARRAY_LENGTH; i++) {
            dynamicArray.add(i, 0);
        }
        List<Object> arrayList = new ArrayList<>(HUGE_ARRAY_LENGTH);
        for (int i = 0; i < HUGE_ARRAY_LENGTH; i++) {
            arrayList.add(i, 0);
        }
        StopWatch timer = new StopWatch();

        timer.start();
        for (int i = HUGE_ARRAY_LENGTH - 1; i > 0; i--) {
            arrayList.remove(i);
        }
        System.out.println("DynamicArrayPerformanceTest.testRemoveEndTime" + System.lineSeparator() + arrayList.getClass() + " remove: " + timer.getElapsedTime());

        timer.start();
        for (int i = HUGE_ARRAY_LENGTH - 1; i > 0; i--) {
            dynamicArray.remove(i);
        }
        System.out.println(dynamicArray.getClass() + " remove: " + timer.getElapsedTime());
    }
}
