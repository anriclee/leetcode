package binarytree

func flatten(root *TreeNode) {
	if root == nil {
		return
	}
	flatten(root.Left)
	flatten(root.Right)
	left := root.Left
	right := root.Right // backup two nodes
	root.Left = nil
	root.Right = left
	ptr := root
	for ptr.Right != nil {
		ptr = ptr.Right
	}
	ptr.Right = right
}
