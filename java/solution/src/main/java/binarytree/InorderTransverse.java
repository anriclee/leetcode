package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by Lee Happily.
 */
public class InorderTransverse {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}
