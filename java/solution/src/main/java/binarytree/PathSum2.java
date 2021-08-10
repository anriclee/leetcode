package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Developed by Lee Happily.
 */
public class PathSum2 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        path.add(root.val);
        pathSumHelper(path, root, targetSum);
        return res;
    }

    private void pathSumHelper(LinkedList<Integer> path, TreeNode root, int targetSum) {
        // 叶子节点
        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new LinkedList<>(path));
            return;
        }

        if (root.left != null) {
            // 做出选择
            path.addLast(root.left.val);
            pathSumHelper(path, root.left, targetSum - root.val);
            // 撤销选择
            path.removeLast();
        }

        if (root.right != null) {
            path.addLast(root.right.val);
            pathSumHelper(path, root.right, targetSum - root.val);
            path.removeLast();
        }
    }
}


// 后记：这道题没有一下做出来，对「回溯」框架不熟悉所致，学习完回溯思想，再来一战！！