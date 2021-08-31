package dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class MinPathSumTest {

    @Test
    public void minPathSum() {
        int[][] nums = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        };
        int i = new MinPathSum().minPathSum(nums);
        System.out.println(i);
    }
}