package binarytree;

import java.util.Arrays;

/**
 * Developed by Lee Happily.
 */
public class MaxSum {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        tranverse(root);
        return maxSum;
    }

    // 1: 是否BST(0--否 1--是) 2：子树之和 3：所有节点最大值 4：所有节点最小值
    private int[] tranverse(TreeNode node) {
        if (node == null) {
            return new int[]{1, 0, Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
        int[] leftRes = tranverse(node.left);
        int[] rightRes = tranverse(node.right);
        int[] ret = new int[4];
        if (leftRes[0] == 1 && rightRes[0] == 1 && (node.val > leftRes[2] && node.val < rightRes[3])) {
            ret[0] = 1;
            ret[1] = leftRes[1] + node.val + rightRes[1];
//            System.out.println("sum:" + ret[1]);
//            System.out.println("root:" + node.val);
            // 更新最大值
            maxSum = Math.max(ret[1], maxSum);
            // 更新以 node 为根的树的最大值
            ret[2] = Math.max(node.val, rightRes[2]);
            // 更新以 node 为根的树的最小值
            ret[3] = Math.min(node.val, leftRes[3]);
        } else {
            // 左右非 BST，直接返回
//            System.out.println("NON BST ---> root:" + node.val);
//            System.out.println("leftRes:" + leftRes[0]);
//            System.out.println("rightRes:" + rightRes[0]);
            ret[0] = 0;
        }
        return ret;
    }


//    private boolean isBST(TreeNode node) {
//        if (node == null) {
//            return true;
//        }
//        boolean b = isBST(node.left) && isBST(node.right);
//        if (node.left != null) {
//            int max = findMax(node.left);
//            if (node.val <= max) {
//                return false;
//            }
//        }
//        if (node.right != null) {
//            int min = findMin(node.right);
//            if (node.val >= min) {
//                return false;
//            }
//        }
//        return b;
//    }
//
//    private int findMin(TreeNode node) {
//        TreeNode ptr = node;
//        while (ptr.left != null) {
//            ptr = ptr.left;
//        }
//        return ptr.val;
//    }
//
//    private int findMax(TreeNode node) {
//        TreeNode ptr = node;
//        while (ptr.right != null) {
//            ptr = ptr.right;
//        }
//        return ptr.val;
//    }

}

// 后记：当前节点要做的事情：
// 1. 是不是BST根节点；
// 2. 当前节点的 sum
// 3. 递归重在描述问题，描述问题的前提是要定义子问题也就是递归函数，定义清楚这个函数输入什么，返回什么，
// 在递归退栈时，不要怀疑自己的函数定义就行, 切忌在调用递归函数返回后，还在做一些本该在递归函数里面做的事情，
// 就如同被注释掉的代码一样。
// 另外，不要想着 hard 题有多难，逢山开路遇水搭桥而已，labuladong
// 在解决算法问题时，总是会采取接地气的方式来，缺什么，就要什么。
