package dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class HouseRobberTest {

    @Test
    public void rob() {
        int[] nums = {2,7,9,3,1};
        int rob = new HouseRobber().rob(nums);
        System.out.println(rob);
    }
}