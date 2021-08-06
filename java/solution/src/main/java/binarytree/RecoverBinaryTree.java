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
// 中序遍历升序的思路想到了，交换通过交换值而不是交换节点想到了，但是怎么检测错误节点的思路没有想到。
// 看了其他人的思路，大部分看的不是很明白，但是有一个人的思路启发了我：
// 正常情况下 BST 的中序遍历一定符合 a1 < a2 < a3 的特点，如果两个节点有误，则该规则要么被违反一次，要么两次。
// 自己觉得这个规则还可以再说透一点：
// 如果错误交换的是两个相邻节点（这里指的是中序遍历后相邻），则规则只被违反一次；
// 如果错误交换的是两个非相邻节点（中序遍历非相邻），则规则被违反两次。
// 再想到这两种case下的纠正方法：
// 1. 出现两次降序，交换第一次出现降序的节点和最后一次出现降序的节点的后继节点
// 2. 出现一次降序，交换第一次出现降序的节点和该节点的后继节点
// 其实case2是case1的特例，总的来说我们要记的有2个：
// 第一次违反规则的节点、最后一次后继节点。
// 另外还需要一个指针，指向遍历节点的前驱节点，用来判断是否违反规则。
// 中序遍历完，执行交换即可。



