package datastructures.shavaleevar.datastructures.maps;

import com.getjavajob.training.algo1710.util.StopWatch;
import java.util.HashMap;
import java.util.Map;

public class AssociativeArrayPerformanceTest {
    private static final int ADD_TEST_COUNT = 20000000;
    private static final int TEST_COUNT = 21000000;

    public static void main(String[] args) {
        testAddMap();
        testAddAssociativeArray();
        testRemoveAssociativeArray();
        testRemoveMap();
        testGetAssociativeArray();
        testGetMap();
    }

    private static void testAddAssociativeArray() {
        StopWatch timer = new StopWatch();
        AssociativeArray<Integer, String> associativeArray = new AssociativeArray<>();
        timer.start();
        for (int i = 0; i < ADD_TEST_COUNT; i++) {
            associativeArray.add(i, "a");
        }
        System.out.println("AssociativeArray Add: " + timer.getElapsedTime());
    }

    private static void testAddMap() {
        StopWatch timer = new StopWatch();
        Map<Integer, String> map = new HashMap<>();
        timer.start();
        for (int i = 0; i < ADD_TEST_COUNT; i++) {
            map.put(i, "a");
        }
        System.out.println("Map Add: " + timer.getElapsedTime());
    }

    private static void testRemoveAssociativeArray() {
        StopWatch timer = new StopWatch();
        AssociativeArray<Integer, String> associativeArray = new AssociativeArray<>();
        for (int i = 0; i < TEST_COUNT; i++) {
            associativeArray.add(i, "a");
        }
        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            associativeArray.remove(i);
        }
        System.out.println("AssociativeArray Remove: " + timer.getElapsedTime());
    }

    private static void testRemoveMap() {
        StopWatch timer = new StopWatch();
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < TEST_COUNT; i++) {
            map.put(i, "a");
        }
        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            map.remove(i);
        }
        System.out.println("Map Remove: " + timer.getElapsedTime());
    }

    private static void testGetAssociativeArray() {
        StopWatch timer = new StopWatch();
        AssociativeArray<Integer, String> associativeArray = new AssociativeArray<>();
        for (int i = 0; i < TEST_COUNT; i++) {
            associativeArray.add(i, "a");
        }
        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            associativeArray.get(i);
        }
        System.out.println("AssociativeArray Get: " + timer.getElapsedTime());
    }

    private static void testGetMap() {
        StopWatch timer = new StopWatch();
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < TEST_COUNT; i++) {
            map.put(i, "a");
        }
        timer.start();
        for (int i = 0; i < TEST_COUNT; i++) {
            map.get(i);
        }
        System.out.println("Map Get: " + timer.getElapsedTime());
    }
}
