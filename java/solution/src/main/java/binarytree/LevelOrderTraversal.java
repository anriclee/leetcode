package binarytree;

import java.util.*;

/**
 * Developed by Lee Happily.
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        Queue<List<TreeNode>> queue = new ArrayDeque<>();
        List<Integer> levelNodes = new ArrayList<>();
        levelNodes.add(root.val);
        res.add(levelNodes);
        List<TreeNode> layerNodes = new ArrayList<>();
        layerNodes.add(root);
        queue.add(layerNodes);
        while (queue.peek() != null) {
            List<TreeNode> currentLayer = queue.poll();
            levelNodes = new ArrayList<>();
            List<TreeNode> nextLayer = new ArrayList<>();
            for (TreeNode layerNode : currentLayer) {
                if (layerNode.left != null) {
                    nextLayer.add(layerNode.left);
                    levelNodes.add(layerNode.left.val);
                }
                if (layerNode.right != null) {
                    nextLayer.add(layerNode.right);
                    levelNodes.add(layerNode.right.val);
                }
            }
            if (!nextLayer.isEmpty()) {
                queue.add(nextLayer);
            }
            if (!levelNodes.isEmpty()) {
                res.add(levelNodes);
            }
        }
        return res;
    }
}

// 后记：二叉树的层序遍历,但是这里有一个坑：要一层一层遍历之后，放入集合。跟普通的层序遍历稍有不同。
