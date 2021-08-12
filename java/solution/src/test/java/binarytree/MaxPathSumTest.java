package binarytree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class MaxPathSumTest {

    @Test
    public void maxPathSum() {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2,
                        null,
                        null),
                new TreeNode(
                        3,
                        null,
                        null)
        );
        int res = new MaxPathSum().maxPathSum(root);
        System.out.println(res);
    }
}