package bfs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class SlidingPuzzleTest {

    @Test
    public void slidingPuzzle() {
//        int[][] arr = new int[][]{{1, 2, 3}, {4, 0, 5}};
//        int i = new SlidingPuzzle().slidingPuzzle(arr);
        int[][] arr = new int[][]{{1, 2, 3}, {5, 4, 0}};
        int i = new SlidingPuzzle().slidingPuzzle(arr);
        System.out.println(i);
    }
}