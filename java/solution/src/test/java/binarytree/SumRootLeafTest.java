package binarytree;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Developed by Lee Happily.
 */
public class SumRootLeafTest {

    @Test
    public void sumNumbers() {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        );
        int i = new SumRootLeaf().sumNumbers(root);
        System.out.println(i);
    }

    @Test
    public void getSum() {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(new TreeNode(1));
        list.add(new TreeNode(2));
        int sum = new SumRootLeaf().getSum(list);
        System.out.println(sum);
    }

}