package binarytree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class ZigzagLevelTest {

    @Test
    public void zigzagLevelOrder() {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2, new TreeNode(4), null),
                new TreeNode(
                        3, null, new TreeNode(5))
        );
        List<List<Integer>> res = new ZigzagLevel().zigzagLevelOrder(root);
        for (List<Integer> re : res) {
            for (Integer i : re) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}