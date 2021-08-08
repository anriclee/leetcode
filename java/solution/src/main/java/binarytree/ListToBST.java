package binarytree;

import java.util.List;

/**
 * Developed by Lee Happily.
 * From leetcode p109
 */
public class ListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = head; // 记录中点的前驱节点
        ListNode p = pre.next; // 慢指针
        ListNode q = p; // 快指针
        // 使用以上两个指针寻找中间节点
        while (q.next != null && q.next.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);// 此处传入的参数还是 head，所以前面的 pre.next 必须为 null，才能切断 root 到前面节点的联系
        root.right = sortedListToBST(p.next);
        return root;
    }

//    public TreeNode sortedListToBST2(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode ptr = head;
//        while (ptr.next != null) {
//            ptr = ptr.next;
//        }
//        return build(head, ptr, true);
//    }
//
//    private TreeNode build(ListNode startNode, ListNode endNode, boolean asc) {
//        if (startNode == null) {
//            return null;
//        }
//        if (startNode == endNode) {
//            return new TreeNode(startNode.val);
//        }
//        if (endNode == null) {
//            return new TreeNode(startNode.val);
//        }
//        if (startNode.next == endNode) {
//            if (asc) {
//                return new TreeNode(endNode.val, new TreeNode(startNode.val), null);
//            }
//            return new TreeNode(startNode.val, null, new TreeNode(endNode.val));
//        }
//
//        ListNode pre = null;
//        ListNode slowPtr = startNode;
//        ListNode fastPtr = slowPtr.next;
//        while (fastPtr != endNode && fastPtr.next != endNode) {
//            pre = slowPtr;
//            slowPtr = slowPtr.next;
//            fastPtr = fastPtr.next.next;
//        }
//        TreeNode root = new TreeNode(slowPtr.val);
//        root.left = build(startNode, pre, true);
//        root.right = build(slowPtr.next, endNode, false);
//        return root;
//    }

}

// 后记：给定升序排列的一个单链表，构建一颗平衡二叉树
// 链表的下一个节点：1.parentnode 2.rightnode 3.successor 找到 root 节点
// 1.想到了快慢指针寻找中点的思路，终止条件没有想清楚。
// 2.借鉴了 leetcode 网友提供的解题思路，左子树其实并不需要计算 start，直接传入 head 即可；右子树传入  root.next 即可。
// 寻找终止条件时，实际上只要将前驱节点的 pre.next = null,直接就可以用 null 来终止循环。
