package datastructures.shavaleevar.datastructures.linkedlist;

import com.getjavajob.training.algo1710.util.StopWatch;
import java.util.LinkedList;
import java.util.List;

public class DoublyLinkedListPerformanceTest {
    private static final int TEST_COUNT = 42000000;
    private static final int ARRAY_LENGTH = 300000;
    private static final int HALF_ARRAY = ARRAY_LENGTH / 2;
    private static final int TEST_COUNT_MIDDLE = 4000;
    private static final int STOP_COUNT = TEST_COUNT_MIDDLE + HALF_ARRAY;
    private static final int HUGE_TEST_COUNT = 86000000;


    public static void main(String[] args) {
        testAddBeginningTime();
        testAddBeginningLinkedListTime();
        testAddMiddleTime();
        testAddMiddleLinkedListTime();
        testAddEndTime();
        testAddEndLinkedListTime();
        testRemoveBeginningTime();
        testRemoveBeginningLinkedListTime();
        testRemoveMiddleTime();
        testRemoveLinkedListMiddleTime();
        testRemoveEndTime();
        testRemoveEndLinkedListTime();
    }

    private static void testAddBeginningTime() {
        List<Object> dll = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();

        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            dll.add(0, 0);
        }
        System.out.println("DoublyLinkedListPerformanceTest.testAddBeginningTime" + System.lineSeparator() + dll.getClass() + " add: " + timer.getElapsedTime());
    }

    private static void testAddBeginningLinkedListTime() {
        List<Object> linkedList = new LinkedList<>();
        StopWatch timer = new StopWatch();

        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            linkedList.add(0, 0);
        }
        System.out.println(linkedList.getClass() + " add: " + timer.getElapsedTime());
    }

    private static void testAddMiddleTime() {
        List<Object> dll = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            dll.add(i, 0);
        }

        timer.start();
        for (int i = HALF_ARRAY; i < STOP_COUNT; i++) {
            dll.add(i, 0);
        }
        System.out.println("DoublyLinkedListPerformanceTest.testAddMiddleTime" + System.lineSeparator() + dll.getClass() + " add: " + timer.getElapsedTime());
    }

    private static void testAddMiddleLinkedListTime() {
        List<Object> linkedList = new LinkedList<>();
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

    private static void testAddEndTime() {
        List<Object> dll = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < 1; i++) {
            dll.add(i, 0);
        }

        timer.start();
        for (int i = 1; i < TEST_COUNT; i++) {
            dll.add(i, 0);
        }
        System.out.println("DoublyLinkedListPerformanceTest.testAddEndTime" + System.lineSeparator() + dll.getClass() + " add: " + timer.getElapsedTime());

    }

    private static void testAddEndLinkedListTime() {
        List<Object> linkedList = new LinkedList<>();
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

    private static void testRemoveBeginningTime() {
        List<Object> dll = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < HUGE_TEST_COUNT; i++) {
            dll.add(i, 0);
        }

        timer.start();
        for (int i = 0; i < HUGE_TEST_COUNT; i++) {
            dll.remove(0);
        }
        System.out.println("DoublyLinkedListPerformanceTest.testRemoveBeginningTime" + System.lineSeparator() + dll.getClass() + " remove: " + timer.getElapsedTime());
    }

    private static void testRemoveBeginningLinkedListTime() {
        List<Object> linkedList = new LinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < HUGE_TEST_COUNT; i++) {
            linkedList.add(i, 0);
        }

        timer.start();
        for (int i = 0; i < HUGE_TEST_COUNT; i++) {
            linkedList.remove(0);
        }
        System.out.println(linkedList.getClass() + "remove: " + timer.getElapsedTime());
    }

    private static void testRemoveMiddleTime() {
        List<Object> dll = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            dll.add(i, 0);
        }

        timer.start();
        for (int i = 0; i < TEST_COUNT_MIDDLE; i++) {
            dll.remove(HALF_ARRAY);
        }
        System.out.println("DoublyLinkedListPerformanceTest.testRemoveMiddleTime" + System.lineSeparator() + dll.getClass() + " remove: " + timer.getElapsedTime());
    }

    private static void testRemoveLinkedListMiddleTime() {
        List<Object> linkedList = new LinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            linkedList.add(i, 0);
        }

        timer.start();
        for (int i = 0; i < TEST_COUNT_MIDDLE; i++) {
            linkedList.remove(HALF_ARRAY);
        }
        System.out.println(linkedList.getClass() + "remove: " + timer.getElapsedTime());
    }

    private static void testRemoveEndTime() {
        List<Object> dll = new DoublyLinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            dll.add(i, 0);
        }

        timer.start();
        for (int i = HALF_ARRAY; i < STOP_COUNT; i++) {
            dll.remove(HALF_ARRAY);
        }
        System.out.println("DoublyLinkedListPerformanceTest.testRemoveEndTime" + System.lineSeparator() + dll.getClass() + " remove: " + timer.getElapsedTime());
    }

    private static void testRemoveEndLinkedListTime() {
        List<Object> linkedList = new LinkedList<>();
        StopWatch timer = new StopWatch();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            linkedList.add(i, 0);
        }

        timer.start();
        for (int i = HALF_ARRAY; i < STOP_COUNT; i++) {
            linkedList.remove(HALF_ARRAY);
        }
        System.out.println(linkedList.getClass() + "remove: " + timer.getElapsedTime());
    }
}
