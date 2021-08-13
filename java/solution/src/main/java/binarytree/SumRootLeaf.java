package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Developed by Lee Happily.
 */
public class SumRootLeaf {
    private int sum = 0;
    private LinkedList<TreeNode> path = new LinkedList<>();

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        path.add(root);
        sumAssist(root);
        return sum;
    }

    private void sumAssist(TreeNode root) {
        if (root.left == null && root.right == null) {
            // 到叶子节点，对完整路径求和
            sum += getSum(path);
            return;
        }

        if (root.left != null) {
            path.addLast(root.left);
            sumAssist(root.left);
            path.removeLast();
        }

        if (root.right != null) {
            path.addLast(root.right);
            sumAssist(root.right);
            path.removeLast();
        }
    }

    public int getSum(LinkedList<TreeNode> path) {
        int order = path.size();
        int sum = 0;
        for (int i = 0; i < order; i++) {
            sum += path.get(i).val * Math.pow(10.0, (order - 1 - i) * 1.0);
        }
        return sum;
    }
}


// 后记：遍历从根节点到叶子节点的所有路径求和