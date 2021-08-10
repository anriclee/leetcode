package binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Developed by Lee Happily.
 */
public class NextRightPtr {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 对于每一层中的元素取出来，从左往右指
            int size = queue.size();
            Node head = queue.peek();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != head) {
                    head.next = node;
                    head = node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

//    public Node connect1(Node root) {
//        if (root == null) {
//            return null;
//        }
//        connectTwoNodes(root.left, root.right);
//        return root;
//    }
//
//    private void connectTwoNodes(Node node1, Node node2) {
//        if (node1 == null || node2 == null) {
//            return;
//        }
//        node1.next = node2;
//        connectTwoNodes(node1.left, node1.right);
//        connectTwoNodes(node2.left, node2.right);
//        Node rightMost = findRightMost(node1);
//        Node leftMost = findLeftMost(node2);
//        connectTwoNodes(rightMost, leftMost);
//    }
//
//    private Node findRightMost(Node root) {
//
//    }
//
//    private Node findLeftMost(Node root) {
//    }

}

// 后记：
// 最开始打算使用之前递归链接两个子节点的思路，
// 但是由于这个没有限定是完美二叉树，所以情况较为复杂：少考虑了一种情况：相隔超过一颗子树的距离的两个左子节点和右边的子节点
// 看题解后，发现有人使用层序遍历，非常容易理解。利用到了 Java 中 queue 的 peek 属性。

