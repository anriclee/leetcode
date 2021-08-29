package dp;

import binarytree.TreeNode;

/**
 * Developed by Lee Happily.
 * <p>
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 * <p>
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HouseRobberV3 {
    public int rob(TreeNode root) {
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }

    // 返回0：rob，返回1：notRob
    private int[] robHelper(TreeNode root) {
        int leftNotRob = 0;
        int leftRob = 0;
        int rightNotRob = 0;
        int rightRob = 0;
        if (root.left != null) {
            int[] res = robHelper(root.left);
            leftRob = res[0];
            leftNotRob = res[1];
        }
        if (root.right != null) {
            int[] res = robHelper(root.right);
            rightRob = res[0];
            rightNotRob = res[1];
        }
        int robbed = root.val + leftNotRob + rightNotRob;
        int notRobbed = Math.max(leftRob, leftNotRob) + Math.max(rightRob, rightNotRob);
        return new int[]{robbed, notRobbed};
    }

    // 超出时间限制
//    private int robHelper(TreeNode root, boolean rob) {
//        int leftNotRob = 0;
//        int leftRob = 0;
//        int rightNotRob = 0;
//        int rightRob = 0;
//        if (root.left != null) {
//            leftNotRob = robHelper(root.left, false);
//            leftRob = robHelper(root.left, true);
//        }
//        if (root.right != null) {
//            rightNotRob = robHelper(root.right, false);
//            rightRob = robHelper(root.right, true);
//        }
//        if (rob) {
//            return root.val + leftNotRob + rightNotRob;
//        } else {
//            int left = Math.max(leftRob, leftNotRob);
//            int right = Math.max(rightRob, rightNotRob);
//            return left + right;
//        }
//    }
}

// 思路：这道题刚开始写的时候，漏了一个 case：如果根节点没有被抢，子节点也可以不被抢。加上这个case 后，重复子问题就变多了，时间超出限制，
// 后面改为函数一次返回两个元素，一个是抢劫根节点的，一个是不抢劫根节点的。完美解决！！！
// [79,99,77,null,null,null,69,null,60,53,null,73,11,null,null,null,62,27,62,null,null,98,50,null,null,90,48,82,null,null,null,55,64,null,null,73,56,6,47,null,93,null,null,75,44,30,82,null,null,null,null,null,null,57,36,89,42,null,null,76,10,null,null,null,null,null,32,4,18,null,null,1,7,null,null,42,64,null,null,39,76,null,null,6,null,66,8,96,91,38,38,null,null,null,null,74,42,null,null,null,10,40,5,null,null,null,null,28,8,24,47,null,null,null,17,36,50,19,63,33,89,null,null,null,null,null,null,null,null,94,72,null,null,79,25,null,null,51,null,70,84,43,null,64,35,null,null,null,null,40,78,null,null,35,42,98,96,null,null,82,26,null,null,null,null,48,91,null,null,35,93,86,42,null,null,null,null,0,61,null,null,67,null,53,48,null,null,82,30,null,97,null,null,null,1,null,null]
// 上面的就是这个万恶的 case
