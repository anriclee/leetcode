package binarytree;

import java.util.*;

/**
 * Developed by Lee Happily.
 */
public class ZigzagLevel {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<TreeNode>> queue = new ArrayDeque<>();
        List<TreeNode> layerNodes = new ArrayList<>();
        layerNodes.add(root);
        queue.add(layerNodes);

        int i = 0;
        while (!queue.isEmpty()) {
            List<Integer> nodes = new ArrayList<>();
            layerNodes = queue.poll();
            for (int index = 0; index < layerNodes.size(); index++) {
                if (i % 2 == 0) {
                    nodes.add(layerNodes.get(index).val);
                } else {
                    nodes.add(layerNodes.get(layerNodes.size() - 1 - index).val);
                }
            }
            res.add(nodes);
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : layerNodes) {
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            if (!next.isEmpty()) {
                queue.add(next);
            }
            i++;
        }
        return res;
    }

//    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        ArrayDeque<TreeNode> backQueue = new ArrayDeque<>();
//        ArrayDeque<TreeNode> frontQueue = new ArrayDeque<>();
//        frontQueue.add(root);
//        List<Integer> layerNodes = new ArrayList<>();
//
//        while (!frontQueue.isEmpty() || !backQueue.isEmpty()) {
//
//            while (!frontQueue.isEmpty()) {
//                TreeNode node = frontQueue.pollFirst();
//                layerNodes.add(node.val);
//                if (node.left != null) {
//                    backQueue.add(node.left);
//                }
//                if (node.right != null) {
//                    backQueue.add(node.right);
//                }
//            }
//            if (!layerNodes.isEmpty()) {
//                res.add(layerNodes);
//                layerNodes = new ArrayList<>();
//            }
//
//            while (!backQueue.isEmpty()) {
//                TreeNode node = backQueue.pollLast();
//                layerNodes.add(node.val);
//                if (node.left != null) {
//                    frontQueue.add(node.left);
//                }
//                if (node.right != null) {
//                    frontQueue.add(node.right);
//                }
//            }
//
//            if (!layerNodes.isEmpty()) {
//                res.add(layerNodes);
//                layerNodes = new ArrayList<>();
//            }
//        }
//
//        return res;
//    }
//
//    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        int counter = 0;
//        int nextLayerCounter = 0;
//        List<List<Integer>> res = new ArrayList<>();
//        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        counter += 1;
//        List<Integer> layerNodes = new ArrayList<>();
//        boolean pollFirst = true;
//        while (!queue.isEmpty()) {
//            TreeNode node;
//            if (pollFirst) {
//                node = queue.pollFirst();
//            } else {
//                node = queue.pollLast();
//            }
//            layerNodes.add(node.val);
//            counter -= 1;
//            if (counter == 0) {
//                counter = nextLayerCounter;
//                nextLayerCounter = 0;
//                pollFirst = false;
//                res.add(layerNodes);
//                layerNodes = new ArrayList<>();
//            }
//            if (node.left != null) {
//                nextLayerCounter += 1;
//                queue.addFirst(node.left);
//            }
//            if (node.right != null) {
//                nextLayerCounter += 1;
//                queue.addFirst(node.right);
//            }
//        }
//        return res;
//    }
//
//    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        queue.add(root);
//        boolean needPushStack = true;
//        List<Integer> layerNodes = new ArrayList<>();
//        while (!queue.isEmpty() || !stack.isEmpty()) {
//            if (needPushStack) {
//                if (queue.peek() != null) {
//                    TreeNode node = queue.poll();
//                    layerNodes.add(node.val);
//                    if (node.left != null) {
//                        stack.push(node.left);
//                    }
//                    if (node.right != null) {
//                        stack.push(node.right);
//                    }
//                }
//                if (queue.isEmpty()) {
//                    // 队列里面的元素全部入栈完毕
//                    needPushStack = false;
//                    res.add(layerNodes);
//                    // 重新初始化下一层的集合
//                    layerNodes = new ArrayList<>();
//                }
//            } else {
//                if (!stack.empty()) {
//                    TreeNode node = stack.pop();
//                    layerNodes.add(node.val);
//                    if (node.left != null) {
//                        queue.add(node.left);
//                    }
//                    if (node.right != null) {
//                        queue.add(node.right);
//                    }
//                }
//
//                if (stack.isEmpty()) {
//                    // 栈中的元素排空
//                    needPushStack = true;
//                    res.add(layerNodes);
//                    // 重新初始化下一层的集合
//                    layerNodes = new ArrayList<>();
//                }
//            }
//        }
//        return res;
//    }
}


// 后记：
// 对二叉树进行锯齿状的层序遍历。
// 交替进行，根据锯齿状的特点，可以选择一个 Stack 和一个 Queue 来进行。
// 栈和队列交替只能保证局部锯齿，有点bug，可以更换为双端队列
// 双端队列，取头还是取尾，交换的临界条件不太好取。计数器？
// 试了三种方法，越想越复杂，被绕进去了。实际上，只是一个层序遍历而已，难点在于如何将每层分开成为一个集合，
// 前面做过层序遍历的题，使用一个 List 来作为一层的元素，最简单的层序遍历以元素为单位，这里的层序以层为单位，
// 所以需要以层为单元存储到 List 中。
// 通过这道题，对于层序遍历的理解又加深了一层。
