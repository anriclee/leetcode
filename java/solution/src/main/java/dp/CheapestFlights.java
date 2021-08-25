package dp;

import java.util.*;

/**
 * Developed by Lee Happily.
 * <p>
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 toi 抵达 pricei。
 * <p>
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 */
public class CheapestFlights {

    // dst ==> src,price
    private Map<Integer, List<int[]>> priceMap = new HashMap<>();

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++;
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            priceMap.putIfAbsent(to, new LinkedList<>());
            priceMap.get(to).add(new int[]{from, price});
        }
        int[][] memos = new int[n][k + 1];
        for (int[] row : memos) {
            Arrays.fill(row, -888);
        }
        return dp(memos, src, dst, k);
    }

    public int findCheapestPriceV2(int n, int[][] flights, int src, int dst, int k) {
        // 这里需要注意：因为是要在 k 次中转内，从 src 到达 dst，所以在图上遍历的边数就是 k+1 条，所以下面都是k+1
        int K = k + 1;
        // dp 定义还同之前一样，dp[dst][k] 代表从原点出发在k步内到dst的代价
        int[][] dp = new int[n][K + 1];
        // 初始化 dp
        for (int[] ddp : dp) {
            Arrays.fill(ddp, Integer.MAX_VALUE);
        }

        for (int i = 0; i <= K; i++) {
            // src -> src 在 k 步内的代价都是 0
            dp[src][i] = 0;
        }

        for (int i = 1; i <= K; i++) {
            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int price = flight[2];
                if (dp[s][i - 1] != Integer.MAX_VALUE) {
                    dp[d][i] = Math.min(dp[d][i], dp[s][i - 1] + price);
                }
            }
        }

        return dp[dst][K] == Integer.MAX_VALUE ? -1 : dp[dst][K];
    }

    // 这一版本由于递归深度会超时
    private int dp(int[][] memos, int src, int dst, int k) {
        if (src == dst) {
            return 0;
        }

        if (k == 0) {
            // 没有转机次数
            return -1;
        }

        if (memos[dst][k] > 0) {
            return memos[dst][k];
        }

        int min = Integer.MAX_VALUE;
        List<int[]> pathList = priceMap.get(dst);
        if (pathList == null) {
            return -1;
        }
        for (int[] fromPrice : pathList) {
            int from = fromPrice[0];
            int price = fromPrice[1];
            int subProblem = dp(memos, src, from, k - 1);
            if (subProblem == -1) {
                // 没有路线
                continue;
            }
            min = Math.min(subProblem + price, min);
        }
        memos[dst][k] = min == Integer.MAX_VALUE ? -1 : min;
        return memos[dst][k];
    }
}

// 动态规划关键在于定好状态转移方程。
// 刚开始由于定义不准确，导致路线错误。如何定义 dp 还是需要多加练习。
// 经历了一晚上加一早上的努力，终于 accepted 了，这种刚开始进入一个陌生的体系的时候，死磕还是有必要的，因为死磕过程中，
// 你会有很多疑问。伴随着这些疑问的解答，慢慢就找到感觉了。