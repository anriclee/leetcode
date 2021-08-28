package dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class MaxSubArrayTest {

    @Test
    public void maxSubArray() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = new MaxSubArray().maxSubArray1(nums);
        System.out.println(i);
    }
}