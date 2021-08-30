package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Developed by Lee Happily.
 * <p>
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int maxDistance = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxDistance >= i) {
                // 如果当前节点在上一个节点的射程范围内，则更新射程
                maxDistance = Math.max(maxDistance, nums[i] + i);
            }
        }

        return maxDistance >= nums.length - 1;

    }


//    public boolean canJump(int[] nums) {
//        Map<Integer, Boolean> memo = new HashMap<>();
//        return backtrace(nums, 0, memo);
//    }
//
//    private boolean backtrace(int[] nums, int index, Map<Integer, Boolean> memo) {
//        if (index >= nums.length - 1) {
//            return true;
//        }
//        if (memo.containsKey(index)) {
//            return memo.get(index);
//        }
//        int paces = nums[index];
//        for (int p = 1; p <= paces; p++) {
//            index += p;
//            boolean res = backtrace(nums, index, memo);
//            memo.put(index, res);
//            if (res) {
//                return true;
//            }
//            index -= p;
//        }
//
//        return false;
//    }
}

// 这道题首先可以用回溯思路解决,不过有个测试用例超时。

// 看了评论才知道这道题应该用贪心算法
//
