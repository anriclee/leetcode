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

// 后记：递归有时候好理解，有时候也不好理解，尤其是对这种递归里面又包含连续两次递归的场景，很容易把
// 自己绕进去，对此自己有点心得：先把递归去掉，剩下的就是需要在递归中重复的逻辑，之后，确定 base case，
// 加进去递归调用。去掉递归之后，如果剩下的逻辑也不好写，说明这种场景可能不适用递归，因为没法把算法抽象
// 成每个节点或者每次调用都要做的逻辑
