package binarytree

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func kthSmallest(root *TreeNode, k int) int {
	rank := 0
	res := 0
	traverse(root, &rank, &res, k)
	return res
}

func traverse(node *TreeNode, rank *int, res *int, k int) {
	if node == nil {
		return
	}
	traverse(node.Left, rank, res, k)
	*rank++
	if *rank == k {
		*res = node.Val
		return
	}
	traverse(node.Right, rank, res, k)
}
