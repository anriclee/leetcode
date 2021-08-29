package binarytree;

/**
 * Developed by Lee Happily.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int v, TreeNode left, TreeNode right) {
        this.val = v;
        this.left = left;
        this.right = right;
    }
}
