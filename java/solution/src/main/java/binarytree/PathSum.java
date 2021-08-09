package binarytree;

/**
 * Developed by Lee Happily.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return sum(root, targetSum);
    }

    private boolean sum(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return (root.left != null && sum(root.left, targetSum - root.val)) ||
                (root.right != null && sum(root.right, targetSum - root.val));
    }
}

// 后记：重在审题，题目要求的是从「根节点」到「叶子节点」，特殊 case：根节点的左右子树有一个非叶子节点