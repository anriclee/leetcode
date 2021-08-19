package binarytree;

/**
 * Developed by Lee Happily.
 */
public class BinaryTreeLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            // 左右子树都找到，说明 p 和 q 中必有一个是 root
            return root;
        }
        if (left == null && right == null) {
            // 左右子树都没有找到
            return null;
        }
        return left == null ? right : left;
    }
}


// 思路：不是BST了，无法轻易判断两个节点的子树分布了。
// 参考labuladong的解题思路完成：https://mp.weixin.qq.com/s/9RKzBcr3I592spAsuMH45g
// labuladong 巧妙的使用递归完成了看似很复杂的任务，代码简洁，思路清晰。
// 这里有一个小坑：
//        if (left == null && right == null) {
//              // 左右子树都没有找到
//              return null;
//        }
// 左右子树都没有找到的情况下，到底该返回什么？
// 按照我的思路是返回 root，因为左子树找不到 p 和 q的共同
// 祖先，右子树也找不到共同祖先，说明共同祖先是 root。
// 但是在递归函数开始的 base  case 中有一个条件：
//         if (root == p || root == q) {
//            return root;
//        }
// 这样就导致，如果 p 或者 q 节点存在子树中，就一定会返回。所以返回 null，只有一种可能：节点
// 不存在子树中,所以确实应该返回 null