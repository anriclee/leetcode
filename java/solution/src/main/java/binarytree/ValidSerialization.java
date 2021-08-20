package binarytree;

import com.sun.deploy.util.StringUtils;

import java.util.Objects;

/**
 * Developed by Lee Happily.
 * <p>
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * <p>
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * <p>
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * <p>
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidSerialization {
    public boolean isValidSerialization(String preorder) {
        if (Objects.equals(preorder, "")) {
            return true;
        }
        int num = 0;
        int len = preorder.length();
        char pre = '@';
        for (int i = len - 1; i >= 0; i--) {
            char c = preorder.charAt(i);
            if (c == '#') {
                num++;
            } else if (isDigital(c) && !isDigital(pre)) {
                // 只在第一次碰到数字时处理
                if (num < 2) {
                    return false;
                }
                num--;
            }
            pre = c;
        }
        System.out.println(num);
        return num == 1;
    }


    private boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }

}


// 思路：
// 重点就是找到左右子树的边界
// 打算根据前序遍历，入栈出栈。
// 遇到两个连续的 # 就连带下面的节点一起出栈，再入一个 #，但是无法解决左右子树衔接的问题。
// 比如从root节点的右子树跳到root节点的左子树，即会出现连续3个 # 的情况
// ^^^^ 这道题需要考虑的细节较多，难度应该不止中等
// 题目要求不重建二叉树判断，如果重建呢？