package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Lee Happily.
 */
public class InorderTree {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left);
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
        return res;
    }
}
