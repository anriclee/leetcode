package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Developed by Lee Happily.
 */
public class PostOrderTree {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        List<Integer> res = new ArrayList<>();
        res.addAll(left);
        res.addAll(right);
        res.add(root.val);
        return res;
    }

//    public List<Integer> postorderNonRecursive(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        while (root.left != null) {
//            stack.push(root.left);
//        }
//        while (!stack.isEmpty()) {
//            TreeNode pop = stack.pop();
//            res.add(pop.val);
//
//        }
//    }
}

// 后记：后序遍历非递归的实现方式？
// 非递归方式没有想好简单明了的实现方式。