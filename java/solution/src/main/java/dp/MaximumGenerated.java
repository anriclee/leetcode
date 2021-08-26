package dp;

import java.util.Arrays;

/**
 * Developed by Lee Happily.
 * <p>
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 * <p>
 * 链接：https://leetcode-cn.com/problems/get-maximum-in-generated-array
 */
public class MaximumGenerated {

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (2 * i <= n) {
                nums[2 * i] = nums[i];
            }
            if (2 * i + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
            }
        }

        for (int num : nums) {
            max = Math.max(max, num);
        }
        System.out.println(Arrays.toString(nums));
        return max;
    }
}


// 思路：
// 这两天在看动态规划的文章，labuladong 讲了关键是找状态和选择，想了半天状态转移方程，被蒙住了。
// 题目中给出的不就是转移方程么？base case 都给出来了。
