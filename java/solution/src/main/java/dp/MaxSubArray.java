package dp;

import java.util.Arrays;

/**
 * Developed by Lee Happily.
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return Math.max(max, dp[0]);
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[nums.length][nums.length];
        // init
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -100001);
        }
        // base case
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
//                if (nums[j] > 0) {
////                    dp[i][j] = Math.max(dp[i][j], nums[j] + dp[i][j - 1]);
//                }
                dp[i][j] = Math.max(nums[j], nums[j] + dp[i][j - 1]);
                max = Math.max(max, dp[i][j]);
                System.out.printf("dp[%d][%d]:%d,max:%d\n", i, j, dp[i][j], max);
            }
        }
        return max;
    }
}


// 思路：注释的代码为错误代码。
// 动态规划做这道题，不太会做。看了题解，想明白了。
// 想了下错误思路的原因：
// 1.dp 数组定义为两个维度，为 [i,j] 区间内的最大值。j 为区间内最后一个元素，如果 nums[j+1] > 0,则最大值更新，更新 j 的下标。
// 解法问题在于判断条件，如果第 j 个元素小于 0，怎么更新 dp 值的问题。开始想着，只有这个元素大于 0，才更新，忽略了小于 0，也得更新，而且更新
// 方法和更新大于0 的 case 一样，所以 if 条件加的多余。去掉 if 判断就好了，但是空间复杂度超了。
// dp 数组完全可以优化到1维。
// dp 真是一门玄学！！

