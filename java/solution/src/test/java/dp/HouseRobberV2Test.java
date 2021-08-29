package dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class HouseRobberV2Test {

    @Test
    public void rob() {
        int[] nums = {1,2,3};
        int rob = new HouseRobberV2().rob(nums);
        System.out.println(rob);
    }
}