package dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class MinCostClimbingStairsTest {

    @Test
    public void minCostClimbingStairs() {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int i = new MinCostClimbingStairs().minCostClimbingStairs(cost);
        System.out.println(i);
    }
}