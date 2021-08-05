package binarytree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class ValidBSTTest {

    @Test
    public void isValidBST() {
        TreeNode node = new TreeNode(2147483647);
        assertTrue(new ValidBST().isValidBST(node));
    }
}