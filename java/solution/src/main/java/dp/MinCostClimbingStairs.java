package dp;

/**
 * Developed by Lee Happily.
 * <p>
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }
        int[] arr = new int[cost.length + 2];
        for (int i = 0; i < cost.length; i++) {
            arr[i + 1] = cost[i];
        }
        int[] dp = new int[arr.length];
        dp[0] = 0;
        dp[1] = 0;
        int minCost = Integer.MAX_VALUE;
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.min(dp[i - 1] + arr[i - 1], dp[i - 2] + arr[i - 2]);
        }
        return dp[dp.length - 1];
    }
}


// 这道题的细节之处在于首尾的两个假的元素