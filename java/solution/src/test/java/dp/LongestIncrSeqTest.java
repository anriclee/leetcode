package dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class LongestIncrSeqTest {

    @Test
    public void lengthOfLIS() {
        int[] nums = {10,9,2,5,3,7,101,18};
        int i = new LongestIncrSeq().lengthOfLIS(nums);
        System.out.println(i);
        nums = new int[]{0,1,0,3,2,3};
        i = new LongestIncrSeq().lengthOfLIS(nums);
        System.out.println(i);
    }
}