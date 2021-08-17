package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public List<Integer> postorderNonRecursive(TreeNode root) {
        TreeNode r = null;
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode ptr = root;
        while (ptr != null) {
            stack.push(ptr);
            ptr = ptr.left;
        }
        while (!stack.isEmpty()) {
            ptr = stack.peek();
            if (ptr.right != null && ptr.right != r) {
                ptr = ptr.right;
                while (ptr != null) {
                    stack.push(ptr);
                    ptr = ptr.left;
                }
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                // 记录此次弹出栈的元素，避免下次重复入栈，造成无限循环
                r = pop;
            }
        }
        return res;
    }
}

// 后记：后序遍历非递归的实现方式？
// 非递归的实现思路：
// 先入左子树栈，左子树栈出栈时，观察是否有右子树，如果有右子树，则重复左子树遍历入栈的动作；
// 如果没有左子树，则根节点可以出栈，并加入遍历列表
// 此处需要注意一个坑：出栈后的元素一定要记录下来，否则会在根节点出栈时，继续判断右子树存在而继续入栈
// 导致栈溢出。