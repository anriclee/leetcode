package binarytree

// 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
// 可以按 任意顺序 返回答案。
func generateTrees(n int) []*TreeNode {
	if n == 0 {
		return nil
	}
	return build(1, n)
}

func build(low, high int) []*TreeNode {
	var res []*TreeNode
	if low > high {
		res = append(res, nil)
		return res
	}
	for i := low; i <= high; i++ {
		// 找出左子树所有合法BST
		leftNodes := build(low, i-1)
		// 找出右子树所有的合法BST
		rightNodes := build(i+1, high)
		for _, lNode := range leftNodes {
			for _, rNode := range rightNodes {
				root := TreeNode{Val: i}
				root.Left = lNode
				root.Right = rNode
				// one kind of tree composed
				res = append(res, &root)
			}
		}
	}
	return res
}

// 后记：递归是解决树的问题的一大杀器，但是有时候难免会绕进递归的细节，不知道最终返回的是什么。遇到这种情况，其实可以
// 从递归函数本质来理解，递归是一种描述。我们可以通过描述每一节点的行为来判定我们写出来的递归是否是有效的。
// 另外一个就是边界条件一定要写对
