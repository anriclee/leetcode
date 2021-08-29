package dp;

import binarytree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class HouseRobberV3Test {

    @Test
    public void rob() {
        // [4,1,null,2,null,3]
        TreeNode root = new TreeNode(4,
                new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null), null);
        int rob = new HouseRobberV3().rob(root);
        System.out.println(rob);
    }
}