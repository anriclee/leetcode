package binarytree;

/**
 * Developed by Lee Happily.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int v, TreeNode left, TreeNode right) {
        this.val = v;
        this.left = left;
        this.right = right;
    }
}
