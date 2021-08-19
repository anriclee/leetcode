package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Developed by Lee Happily.
 * <p>
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class AllPath {
    private List<String> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<Integer> res = new LinkedList<>();
        helper(root, res);
        return path;
    }

    private void helper(TreeNode root, LinkedList<Integer> res) {
        res.add(root.val);
        if (root.left == null && root.right == null) {
            path.add(format(res));
            return;
        }
        if (root.left != null) {
            helper(root.left, res);
            res.removeLast();
        }
        if (root.right != null) {
            helper(root.right, res);
            res.removeLast();
        }
    }

    private String format(LinkedList<Integer> res) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i));
            if (i == res.size() - 1) {
                continue;
            }
            sb.append("->");
        }
        return sb.toString();
    }
}
