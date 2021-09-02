package dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class CanSplitTest {

    @Test
    public void canPartition() {
        int[] nums = {1, 5, 11, 5};
        boolean b = new CanSplit().canPartition(nums);
        System.out.println(b);
    }
}