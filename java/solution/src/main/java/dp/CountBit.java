package dp;

/**
 * Developed by Lee Happily.
 * <p>
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountBit {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            int bitsNum = res[i >> 1];
            if ((i & 1) == 0) {
                // 偶数
                res[i] = bitsNum;
            } else {
                // 奇数
                res[i] = bitsNum + 1;
            }
        }
        return res;
    }
}

// 思路：做这道题时，比较有意思，拿到这道题，直接写出了状态转移方程，然后在思考自己哪儿写错了。
// 主要是卡在一个 case 上，dp[i] 的bit序列为：111，dp[i+1] 的序列中的 1 的个数怎么推导？
// 其实就是 dp[i] 的 1 的个数跟这个数为奇偶特性相关，如果是当前是偶数，最后一位是0，不会贡献 1 的个数，
// 如果当前数是奇数，则会贡献 1 个 1.

