package dp;

import java.util.Arrays;

/**
 * Developed by Lee Happily.
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HouseRobberV2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int v1 = helper(nums, 0, nums.length - 2);
        int v2 = helper(nums, 1, nums.length - 1);
        int v3 = helper(nums, 1, nums.length - 2);
        return Math.max(Math.max(v1, v2), v3);
    }

    private int helper(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return nums[start];
        }
        int dp_i = 0;
        int dp_i_1 = 0; // 抢劫下一个屋子的代价
        int dp_i_2 = 0; // 抢劫下下个屋子的代价
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, dp_i_2 + nums[i]);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}


// 思路：这次跟 v1 的条件大致相同，只是首尾可以相邻，变成了一个环形。
// 如果抢了最后一个屋子，则第一个屋子一定不能成为选择，可以强制赋值一个异常值(这种思路行不通，无法判断根据最后两个决定判断
// 是否可以最终取到最后一个值）
// 这种语境下，选择最后一个和第一个成为两个互相影响的选择，看起来不符合动态规划的条件了。
// 看了 labuladong 给的提示，对首尾两家屋子是否可以被抢梳理几种case：
// 1. 首尾不被抢
// 2. 首抢尾不抢
// 3. 首不抢尾抢
// 心得：
// 1.遇到复杂的有影响的问题，梳理 case 很重要，case 梳理清楚各个击破
// 2.遇到迭代递归，一般都可以简化空间复杂度为O(1)，只需要保存几个临时变量即可。同时，省去很多初始化数组及拷贝边界等相关问题



