package binarytree;

/**
 * Developed by Lee Happily.
 * <p>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class BSTLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = null, right = null;
        if (root.val >= p.val && root.val >= q.val) {
            left = lowestCommonAncestor(root.left, p, q);
        } else if (root.val <= p.val && root.val <= q.val) {
            right = lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        if (root.val <= p.val && root.val <= q.val) {
            // 同在右子树
            if (p.right == q || p.left == q) {
                return p;
            }
            if (q.right == p || q.left == p) {
                return q;
            }
            return helper(root.right, p, q);
        }
        if (root.val >= p.val && root.val >= q.val) {
            // 同在左子树
            if (p.right == q || p.left == q) {
                return p;
            }
            if (q.right == p || q.left == p) {
                // p 和 q 连接
                return q;
            }
            return helper(root.left, p, q);
        }
        // 分散在左右子树
        return root;
    }
}

// 思路：
// 可以用递归的思路求解
// 情况1：两个节点在 root 的一颗子树上（左子树/右子树），传入左（右）子节点，递归执行
// 情况2：两个节点分别在 root 的左右子树，公共祖先就是 root 节点
// 边界 case
// 因为是二叉搜索树，所以可以比较 p、q 和 root 的值判断是情况1或者情况2
// 看了 labuladong 的递归解法后，受到启发，改进一版
// PS: 从 labuladong 学到递归真的是一把利器!!!!

