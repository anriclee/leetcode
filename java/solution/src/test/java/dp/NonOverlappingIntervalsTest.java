package dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class NonOverlappingIntervalsTest {

    @Test
    public void eraseOverlapIntervals() {
        //[[1,2],[2,3],[3,4],[-100,-2],[5,7]]
        int[][] nums = new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {-100,-2},
                {5,7}
        };
        int i = new NonOverlappingIntervals().eraseOverlapIntervals(nums);
        System.out.println(i);
    }
}