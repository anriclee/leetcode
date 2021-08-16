package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Developed by Lee Happily.
 * <p>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class RightSideView {
    private List<Integer> res = new ArrayList<>();
    private LinkedList<TreeNode> queue = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            res.add(queue.peekLast().val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return res;
    }

//    public List<Integer> rightSideView1(TreeNode root) {
//        if (root == null) {
//            return res;
//        }
//        TreeNode ptr = root;
//        while (ptr != null) {
//            res.add(ptr.val);
//            if (ptr.right == null) {
//                ptr = ptr.left;
//            } else {
//                ptr = ptr.right;
//            }
//        }
//        return res;
//    }
}


// 后记：rightSideView1 方法漏洞，测试用例 [1,2,3,4] 不能通过
// 尝试用层序遍历的方式实现