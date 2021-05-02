package binarytree

// 翻转二叉树

// TreeNode ... Definition for a binary tree node.*/
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

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
