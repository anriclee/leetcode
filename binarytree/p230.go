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


// 后记：
// 递归方法中如如果遇到返回值问题，比如 找到返回 N，没有找到返回 M，这种增加返回值判断负担的，直接使用全局变量值可解决，
// 但是在提交 leetcode 判断时，可能与其执行机制有关系，前一个用例的结果保存在 res 变量中，会影响后一个，所以总会出现执行单测试用例
// 成功，但是一起执行失败，这个时候，可以用一个指针变量来实现。
