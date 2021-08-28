package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Developed by Lee Happily.
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * <p>
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> pre = null;
        for (int i = 0; i < numRows; i++) {
            if (pre == null) {
                list.add(1);
            } else {
                int head = 0;
                int tail = 0;
                list.add(head + pre.get(0));
                for (int k = 1; k <= pre.size() - 1; k++) {
                    list.add(pre.get(k) + pre.get(k - 1));
                }
                list.add(tail + pre.get(pre.size() - 1));
            }
            res.add(list);
            pre = list;
            list = new ArrayList<>();
        }

        return res;
    }

    // 1 0 0 0
    // 1 1 0 0
    // 1 2 1 0
    // 1 3 3 1
    // ...
    // 杨辉三角完全可以用一个二维数组表示，然后，对角线和第一列都是固定为 1（相当于 base case，下一列
    // 的值完全可以由上一列得出，相当于转移方程）
    public List<List<Integer>> generateV2(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];

        // init base case
        for (int i = 0; i < numRows; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        // 从第二行开始初始化
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        for (int[] ints : dp) {
            List<Integer> row = new ArrayList<>();
            for (int anInt : ints) {
                if (anInt != 0) {
                    row.add(anInt);
                }
            }
            res.add(row);
        }

        return res;
    }
}

// 思路：
// 本题第一种解法完全没有用到动态规划。贼心不死，于是在题解中看到了使用动态规划的解法，遂写出了v2方法

