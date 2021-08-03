package binarytree

// ext 系列不在 leetcode 题库中，但是仍然有借鉴意义的题
// 判断是否是二叉搜索树
func isValidBST(root *TreeNode) bool {
	return validBSTWithRange(root, nil, nil)
}

// 仅靠每个节点的左子节点小于其值，右子节点的值大于其值这个约束是不够的。
// 这样不能保证左子树的每个节点都小于该节点的值,所以需要传入一个辅助值，这也是算法的一个技巧，当条件不够时，需要自己添加参数
func validBSTWithRange(node, min, max *TreeNode) bool {
	if node == nil {
		return true
	}

	if min != nil && node.Val <= min.Val {
		return false
	}

	if max != nil && node.Val >= max.Val {
		return false
	}

	return validBSTWithRange(node.Left, min, node) &&
		validBSTWithRange(node.Right, node, max)
}

// InsertNodeToBST 插入节点到二叉搜索树
func InsertNodeToBST(root *TreeNode, val int) *TreeNode {
	if root == nil {
		return &TreeNode{Val: val}
	}
	if root.Val > val {
		root.Left = InsertNodeToBST(root.Left, val)
	}
	if root.Val < val {
		root.Right = InsertNodeToBST(root.Right, val)
	}
	return root
}

// DeleteNodeInBST 从二叉搜索树中删除节点
func DeleteNodeInBST(root *TreeNode, key int) *TreeNode {
	if root.Val == key {
		// delete root node
		if root.Left == nil && root.Right == nil {
			// have no children nodes,delete directly
			return nil
		}
		if root.Left != nil && root.Right == nil {
			// have only left child node, replace it with its left child
			return root.Left
		}
		if root.Left == nil && root.Right != nil {
			// have only right child node, replace it with its right child
			return root.Right
		}
		// have both left and right nodes, replace it with the min node in right subtree
		n := getMinNode(root.Right)
		// replace it by copying value here and then delete it from right subtree(an solved problem)
		root.Val = n.Val
		root.Right = DeleteNodeInBST(root.Right, n.Val)
	} else if root.Val < key {
		// try to delete a node in right tree
		root.Right = DeleteNodeInBST(root.Right, key)
	} else if root.Val > key {
		// try to delete a node in left tree
		root.Left = DeleteNodeInBST(root.Left, key)
	}
	return root
}

func getMinNode(node *TreeNode) *TreeNode {
	if node.Left == nil {
		// this is the left most node
		return node
	}
	return getMinNode(node.Left)
}
