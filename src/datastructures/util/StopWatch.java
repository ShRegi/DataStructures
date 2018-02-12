package datastructures.util;

import static java.lang.System.currentTimeMillis;

public class StopWatch {
    private long startTime;

    public void start() {
        startTime = currentTimeMillis();
    }

    public long getElapsedTime() {
        return currentTimeMillis() - startTime;
    }
}
