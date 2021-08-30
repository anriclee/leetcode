package dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class JumpGameTest {

    @Test
    public void canJump() {
        int[] nums = new int[]{3,2,1,0,4};
        boolean b = new JumpGame().canJump(nums);
        System.out.println(b);
    }
}