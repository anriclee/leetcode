package binarytree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class PathSum2Test {

    @Test
    public void pathSum() {
        TreeNode root = new TreeNode(
                5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(
                        8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1)))
        );
        List<List<Integer>> res = new PathSum2().pathSum(root, 22);
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}