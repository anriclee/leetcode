package dp;

import java.util.Arrays;

/**
 * Developed by Lee Happily.
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length > 1) {
            dp[1] = Math.max(dp[0], nums[1]);
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len + 2];
        dp[0] = nums[0];
        for (int i = len - 1; i >= 0; i--) {
            // nums[i]--抢当前房屋
            dp[i] = Math.max(dp[i + 2] + nums[i], dp[i + 1]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}


// 思路一：定义 i 为最后一个被抢劫的屋子，则只有两种方式：抢前面的（i-2）家+抢第(i-1)家，即比较
// dp[i-2]+num[i] 和 dp[i-1] 的大小关系，做决策。Q:那前面的 （i - 3） 家也可以啊 A：前面的（i-3）
// 家在求 dp[i-2] 时候已经包含了这种case。
// 思路二：思路一的方法虽然可行，但是由于 base case 的处理（需要判断 dp[1])，不是很优雅，采用
// labuladong 的思路又重写了一遍：
// 与思路一正好相反，i 是当前决定是否抢劫的屋子，如果抢劫当前 i，则下一个不能抢劫，需要从 i+1 开始做决定，
// 否则，从 i+1 开始做决定。

