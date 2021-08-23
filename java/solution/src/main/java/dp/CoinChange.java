package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Developed by Lee Happily.
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] memos = new int[amount + 1];
        Arrays.fill(memos, amount + 1);
        return dp(amount, memos, coins);
    }

    private int dp(int amount, int[] memos, int[] coins) {
        memos[0] = 0;
        // 自底向上
        for (int i = 0; i < memos.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                memos[i] = Math.min(memos[i - coin] + 1, memos[i]);
            }
        }

        return memos[amount] == amount + 1 ? -1 : memos[amount];
    }

//    private Map<Integer, Integer> memo = new HashMap<>();
//
//    // dp 为金额总数为 amount 时的硬币个数
//    private int dp1(int amount, int[] coins) {
//        if (amount == 0) {
//            return 0;
//        }
//
//        if (amount < 0) {
//            return -1;
//        }
//
//        if (memo.get(amount) != null) {
//            return memo.get(amount);
//        }
//        // 因为每一次递归，都需要计算出当前最小值，所以不能设置为全局变量
//        int min = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int dp = dp1(amount - coin, coins);
//            if (dp == -1) {
//                continue;
//            }
//            min = Math.min(dp + 1, min);
//        }
//
//        if (min != Integer.MAX_VALUE) {
//            memo.put(amount, min);
//            return min;
//        }
//
//        return -1;
//    }
}


// 用这道题学习动态规划的解法，动态规划关键点在于：1.寻找最优子结构 2.状态转移方程
// 在这道题中：
// 1.由于硬币个数无限，所以子问题之间是相互独立的，且每个子问题最优，则全局最优，符合最优子结构。
// 试想：如果一个题目中给出只有 100 个硬币，则子问题之间就不相互独立了，则不符合最优子结构。
// 2.状态，即变化量，这个比较难判断，看了 labuladong 的解释，自己初步有了自己的理解：
// 状态方程 f(x) = y,为了达到最优的 y，此时的 x 就是状态，在这道题中，
// 为了达到最小的硬币个数，即 min f(x), 则 x 当然就是当时的金额了。

// 被注释掉的是一种低效的递归，leetcode 上会超时。
// 动态规划的备忘录的定义很关键。

