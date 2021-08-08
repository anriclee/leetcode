package binarytree;

import java.util.*;

/**
 * Developed by Lee Happily.
 * From leetcode p107
 */
public class LevelOrderBottomTranverse {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> layerValues;
        List<TreeNode> layerNodes = new ArrayList<>();
        layerNodes.add(root);
        Queue<List<TreeNode>> queue = new ArrayDeque<>();
        queue.add(layerNodes);
        while (!queue.isEmpty()) {
            List<TreeNode> nodes = queue.poll();
            layerNodes = new ArrayList<>();
            layerValues = new ArrayList<>();
            for (TreeNode node : nodes) {
                layerValues.add(node.val);
                if (node.left != null) {
                    layerNodes.add(node.left);
                }
                if (node.right != null) {
                    layerNodes.add(node.right);
                }
            }
            if (!layerValues.isEmpty()) {
                stack.push(layerValues);
            }
            if (!layerNodes.isEmpty()) {
                queue.add(layerNodes);
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> levelNodes;
        while (!queue.isEmpty()) {
            levelNodes = new ArrayList<>();
            int count = queue.size();
            int i = 0;
            while (i < count) {
                TreeNode node = queue.poll();
                if (node == null) {
                    break;
                }
                levelNodes.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                i++;
            }
            if (!levelNodes.isEmpty()) {
                res.addFirst(levelNodes);
            }
        }

        return res;
    }
}

// 后记：看了自己写出来的提交通过后，又看了leetcode 上其他人的解法，有一种比较简洁：因为 queue 中的
// 每个元素都是一层的所有节点，所以只要将所有节点取出来，就是该层所有的节点。返回时，也不用入栈、出栈，直接
// 对 LinkedList 头插即可。


