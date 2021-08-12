package binarytree;

/**
 * Developed by Lee Happily.
 */
public class MaxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            // 子树结构为空，对全局贡献为0
            return 0;
        }
        int val = sumHelper(root);
        return Math.max(val, maxSum);
    }

    // 为了最后的全局比较，所以需要一个辅助函数
    private int sumHelper(TreeNode root) {
        // 割裂的子结构的最大值,case:单独左子树、单独右子树、左右子树+root
        int val, leftSum = 0, rightSum = 0;
        if (root.left != null) {
            leftSum = sumHelper(root.left);
        }
        if (root.right != null) {
            rightSum = sumHelper(root.right);
        }
        val = leftSum + rightSum + root.val;
        if (Math.max(leftSum, rightSum) == 0) {
            maxSum = Math.max(val, maxSum);
        } else {
            maxSum = Math.max(Math.max(Math.max(leftSum, rightSum), val), maxSum);
        }
        // 非割裂的子结构可以贡献的值
        // 当然需要比较出哪个子树的和更大，case：root、左子树+root、右子树+root
        int v1 = leftSum + root.val;
        int v2 = rightSum + root.val;
        return Math.max(Math.max(v1, v2), root.val);
    }
}


// 后记：
// hard 模式不愧是 hard 模式，自己想了一天也没有思路。看了题解。
// 如果 node 在最大路径中，有两种类型：
// 1.node的左右子树都在最大路径中==>node的值加上左右子树构成了最大路径
// 2.node中较大子树在最大路径中===>node的父节点一定在最大路径中。
// 对于每一个递归，可以看做是对一个子树结构进行处理：
// case1，需要给出该子结构的最大值，跟全局记录的最大
// 值比较（注意，该值不返回，因为该值对于全局没有贡献，可以理解为一个割裂的单元）
// case2，需要给出该子结构在不产生割裂子结构的情况下，可以贡献的最大值。
// 最后全局比较
// 此题有了思路还需要注意采坑，后来加的 if 判断就是用来防止根节点为负值，导致0值成了最大的case。