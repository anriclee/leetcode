package bfs;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class OpenLockTest {

    @Test
    public void openLock() {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        deadends = new String[]{"8888"};
        target = "0009";
        deadends = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        target = "8888";
        deadends = new String[]{"0000"};
        target = "8888";
        int v = new OpenLock().openLock(deadends, target);
        System.out.println(v);
    }
}