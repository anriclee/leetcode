package binarytree;

/**
 * Developed by Lee Happily.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null && root1.val == root2.val) {
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }
        return root1 == null && root2 == null;
    }
}

// 后记：
// 感觉这道题的难度并不是简单级别，很容易采坑被绕进去。重在理解递归的含义。
