package binarytree;

/**
 * Developed by Lee Happily.
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return valid(root, Long.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean valid(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }
        return (root.val > min && root.val < max) &&
                valid(root.left, root.val, min) &&
                valid(root.right, max, root.val);
    }
}


// 后记：这道题不难，坑在于边界条件的值。最开始设置为 Integer.MAX，后来有一个测试用例专门用这个值
// 作为测试用例，直接改用  LONG 类型就ok了。