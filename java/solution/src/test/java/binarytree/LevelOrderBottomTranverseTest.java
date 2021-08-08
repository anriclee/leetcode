package binarytree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class LevelOrderBottomTranverseTest {

    @Test
    public void levelOrderBottom() {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(
                        9, null, null),
                new TreeNode(
                        20, new TreeNode(15), new TreeNode(7))
        );
        List<List<Integer>> res = new LevelOrderBottomTranverse().levelOrderBottom2(root);
        for (List<Integer> re : res) {
            for (Integer i : re) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}