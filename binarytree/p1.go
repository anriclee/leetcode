package binarytree

// 翻转二叉树

func invertTree(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	leftChild := invertTree(root.Left)
	rightChild := invertTree(root.Right)
	root.Left = rightChild
	root.Right = leftChild
	return root
}
