package binarytree;

/**
 * Developed by Lee Happily.
 */
public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = build(nums, start, mid - 1);
        TreeNode right = build(nums, mid + 1, end);
        return new TreeNode(nums[mid], left, right);
    }

}

// 后记：重在审题，题目要求构建的是一颗 ** 高度平衡 ** 二叉搜索树。
// 分治思想