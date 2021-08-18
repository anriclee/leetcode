package binarytree;

import java.util.LinkedList;

/**
 * Developed by Lee Happily.
 * <p>
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountNode {
    private LinkedList<TreeNode> queue = new LinkedList<>();
    private int depth = 0;
    private int lastNodeCount = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        layerTranverse(root);
        return (int) Math.pow(2, depth - 1) - 1 + lastNodeCount;
    }

    private void layerTranverse(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            // 每次出队，都是一层遍历
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (queue.isEmpty()) {
                // 最后一层
                lastNodeCount = size;
            }
        }
    }
}


// 思路：层序遍历，记录层高，最后一层节点个数,总数=2^(h-1)+最底层节点数