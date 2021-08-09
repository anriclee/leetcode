package binarytree;

/**
 * Developed by Lee Happily.
 */
public class MinimumDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}

// 后记：
// 使用递归。递归定义：对每一个节点，只有自己为叶子节点时，才能参与深度大小的比较。
// 这道题并不难，但是开始有个误区，认为 17 行可以包含11~16行中的迭代。
// 涉及递归的问题，最关键是定义好递归做了什么，然后一行一行写出来，再调用递归函数。
