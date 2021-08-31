package dp;

/**
 * Developed by Lee Happily.
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        int[][] dp = new int[row + 1][col + 1];
        //base case
        int colSum = 0;
        int rowSum = 0;
        for (int i = 0; i < grid.length; i++) {
            colSum += grid[i][0];
            dp[i][0] = colSum;
        }
        for (int j = 0; j < grid[0].length; j++) {
            rowSum += grid[0][j];
            dp[0][j] = rowSum;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                int upDown = dp[i - 1][j];
                int leftRight = dp[i][j - 1];
                dp[i][j] = Math.min(upDown, leftRight) + grid[i][j];
                System.out.printf("upDown[%d]:leftRight:[%d]\n", upDown, leftRight);
                System.out.printf("dp[%d][%d]:%d\n", i, j, dp[i][j]);
            }
        }

        return dp[row][col];
    }
}

// 典型动态规划题，状态为 dp[i][j]