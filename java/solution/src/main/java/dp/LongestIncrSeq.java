package dp;

import java.util.Arrays;

/**
 * Developed by Lee Happily.
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class LongestIncrSeq {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 只有递增时才能更新序列
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}

// 首先本题满足最优子结构，可以用动态规划来解决。
// 四部曲：
// 状态：右游标的位置（只有移动右游标，才能更新递增子序列，从而得出子序列的长度
// 转移方程： dp[i]，在最右下标为 i 时序列中最后一个元素为 nums[i] 时，最长严格递增子序列的长度
// -- 判断转移方程是否写对，可以看 dp[i] 是否可以由 dp[i-1] 得出，
// ---如果不能，则证明列错了，或者 dp 信息不够，考虑升维度.
// ---此题中：
// ------- dp[i] = dp[j]  + 1 (nums[j] < nums[i],因为是严格递增，所以此处 = 不能取)，
// ------- 注意：在子序列中，最右边的元素为 i,最左边的元素不一定是 0，有可能起点的范围在 [0,i)
// 选择：向右边移动 i
// base case：每一个元素初始化为 1，递增序列只有自己，则为 1.