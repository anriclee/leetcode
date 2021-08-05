package binarytree;

/**
 * Developed by Lee Happily.
 */
public class RecoverBinaryTree {
    private TreeNode firstInverseNode;
    private TreeNode successorNodeOfLastInversed;
    private TreeNode preNode;

    public void recoverTree(TreeNode root) {
        inorder(root);
        if (firstInverseNode == null || successorNodeOfLastInversed == null) {
            return;
        }
        int tmp = firstInverseNode.val;
        firstInverseNode.val = successorNodeOfLastInversed.val;
        successorNodeOfLastInversed.val = tmp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (preNode != null && preNode.val >= root.val) {
            if (firstInverseNode == null) {
                // 记录第一次出现降序的节点
                firstInverseNode = preNode;
            }
            successorNodeOfLastInversed = root;
        }
        preNode = root;
        inorder(root.right);
    }

//    private TreeNode tranverse(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode leftRoot = tranverse(root.left);
//        int rootVal = root.val;
//        TreeNode leftNode = root.left;
//        TreeNode rightNode = root.right;
//        if (leftNode != null && rootVal < leftNode.val) {
//            int tmp = leftRoot.val;
//            leftRoot.val = root.val;
//            root.val = tmp;
//            return root;
//        }
//        if (rightNode != null && rootVal > rightNode.val) {
//            int tmp = rightNode.val;
//            rightNode.val = root.val;
//            root.val = tmp;
//            return root;
//        }
//        tranverse(root.right);
//        return root;
//    }
}


// 后记：
// 先想到中序升序特征，因为只有两个节点错误，所以交换不符合顺序的两个节点即可。
// 是否可以用递归？
// 如果错误节点是相邻的，那么规则只违反一次；如果非相邻，则违反两次 =>
// 中序遍历:

// 1. 出现两次降序，交换第一次出现降序的节点和最后一次出现降序的节点的后继节点
// 2. 出现一次降序，交换第一次出现降序的节点和最后一次出现降序的节点的后继节点

// 记录每对：降序节点和后继节点


