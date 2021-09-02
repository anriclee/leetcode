package dp;

import java.util.Arrays;

/**
 * Developed by Lee Happily.
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanSplit {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) {
            // 和为奇数，不能分割
            return false;
        }
        sum = sum >> 1;
        int[] dp = new int[sum + 1];
        for (int j = 0; j <= sum; j++) {
            dp[j] = j >= nums[0] ? nums[0] : 0;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                // 不选择 i
                int no = dp[j];
                // 选择 i
                int yes = dp[j - nums[i]] + nums[i];
                dp[j] = Math.max(no, yes);
            }
        }
        return dp[sum] == sum;
    }
}

//
