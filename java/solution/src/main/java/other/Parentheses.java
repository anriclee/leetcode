package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Developed by Lee Happily.
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Parentheses {
    private final char leftP = '(';
    private final char rightP = ')';

    private int leftPCount = 0; // 左括号个数
    private int rightPCount = 0; // 右括号个数

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int len = n * 2;
        helper(new LinkedList<>(), len);
        return res;
    }

    private void helper(LinkedList<Character> s, int len) {
        if (s.size() == len) {
            StringBuilder sb = new StringBuilder();
            for (Character c : s) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }
        if (leftPCount < len / 2) {
            s.add(leftP);
            leftPCount++;
            helper(s, len);
            s.removeLast();
            leftPCount--;
        }
        if (leftPCount > rightPCount) {
            s.add(rightP);
            rightPCount++;
            helper(s, len);
            s.removeLast();
            rightPCount--;
        }
    }

}


// 思路：这个题之前做过。这次尝试使用回溯的思路解决。
// 记得之前看过 labuladong 的一个总结：每次放一个 ")" 时，必须保证 ")" 的数量小于 "(" 的数量。
// 这样就可以放上合法的括号了。
// 任何时候，放入括号都需要满足：
// 1.左括号个数 <= 3
// 2.左括号个数 >= 右括号
