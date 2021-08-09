package binarytree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class MinimumDepthTest {

    @Test
    public void minDepth() {
        TreeNode root = new TreeNode(
                2,
                null,
                new TreeNode(
                        3,
                        null,
                        new TreeNode(4,
                                null,
                                new TreeNode(5,
                                        null,
                                        new TreeNode(6))))
        );
        int depth = new MinimumDepth().minDepth(root);
        System.out.println(depth);
    }
}