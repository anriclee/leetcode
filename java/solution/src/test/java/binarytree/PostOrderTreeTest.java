package binarytree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class PostOrderTreeTest {

    @Test
    public void postorderNonRecursive() {
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
        List<Integer> res = new PostOrderTree().postorderNonRecursive(root);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }
}