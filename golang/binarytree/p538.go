package binarytree

func convertBST(root *TreeNode) *TreeNode {
	var sum int
	greaterTree(root, &sum)
	return root
}

func greaterTree(node *TreeNode, sum *int) {
	if node == nil {
		return
	}
	greaterTree(node.Right, sum)
	*sum += node.Val
	node.Val = *sum
	greaterTree(node.Left, sum)
}

// 最开始想根据每一个节点要做的动作重复进行，不好抽象每个节点的行为，因为左节点还需要知道父节点以及父节点右节点的和
// 所以参考 labuladong 的方法，采用二叉树降序遍历求和的思路。