package binarytree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class ListToBSTTest {
    @Test
    public void sortListToBST() {
        ListNode node = new ListNode(
                -1,
                new ListNode(0,
                        new ListNode(1,
                                new ListNode(2))));
        TreeNode root = new ListToBST().sortedListToBST(node);
        List<List<Integer>> res = new LevelOrderTraversal().levelOrder(root);
        for (List<Integer> re : res) {
            for (Integer i : re) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    @Test
    public void sortListToBST2() {
        ListNode node = new ListNode(
                0);
        TreeNode root = new ListToBST().sortedListToBST(node);
        List<List<Integer>> res = new LevelOrderTraversal().levelOrder(root);
        for (List<Integer> re : res) {
            for (Integer i : re) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    @Test
    public void sortListToBST3() {
        ListNode node = new ListNode(
                0,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6)))))));
        TreeNode root = new ListToBST().sortedListToBST(node);
        List<List<Integer>> res = new LevelOrderTraversal().levelOrder(root);
        for (List<Integer> re : res) {
            for (Integer i : re) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}