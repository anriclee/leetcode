package dp;

import java.util.Arrays;

/**
 * Developed by Lee Happily.
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * The answer is guaranteed to fit into a signed 32-bit integer.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChangeV2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                for (int k = 1; k <= i; k++) {
                    if (i == k * coin) {
                        dp[i] += 1;
                        System.out.printf("d[%d]:%d\n", i, dp[i]);
                        break;
                    }
                    if (i - k * coin > 0) {
                        int i1 = i - k * coin;
                        if (dp[i1] > 0) {
                            System.out.printf("d[%d]=>d[%d]\n", i, i1);
                            dp[i] = dp[i1];
                            break;
                        }
                        System.out.println(Arrays.toString(Arrays.stream(dp).toArray()));
                    }
                }
            }
        }
        return dp[amount];
    }
}


// 思路：动态规划，先暴力破解，再找状态转移方程，比如：
// 凑5，选择1，凑4；选择2 凑 3；选择5 凑0，也就是成功.
// 难点在于可以重复选择硬币币种，不知道该如何去重
// 动态思路1：定义 dp[i] 为凑钱为 i 时的选择数,发现 dp[i] 和  dp[i-1] 的关系不是很明确,费了很长时间也没有做出来~
// 动态思路2：完全背包问题。dp[i][j]：在仅使用前i个硬币时（可重复使用），凑够 j 的方法数


