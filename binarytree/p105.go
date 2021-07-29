package binarytree

func buildTree1(preorder []int, inorder []int) *TreeNode {
	return buildHelper(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1)
}

func buildHelper(preorder []int, preStart, preEnd int, inorder []int, inStart, inEnd int) *TreeNode {
	if preStart > preEnd {
		return nil
	}
	rootVal := preorder[preStart]
	root := &TreeNode{Val: rootVal}
	index := findIndex(rootVal, inorder, inStart, inEnd)
	leftSize := index - inStart
	root.Left = buildHelper(preorder, preStart+1, preStart+leftSize, inorder, inStart, index-1)
	root.Right = buildHelper(preorder, preStart+leftSize+1, preEnd, inorder, index+1, inEnd)
	return root
}

func findIndex(target int, inorder []int, start, end int) int {
	for i := start; i <= end; i++ {
		if inorder[i] == target {
			return i
		}
	}
	return -1
}

// func splitParts(preorder []int, inorder []int) (
// 	leftPre, leftInorder, rightPreorder, rightInorder []int) {
// 	if len(preorder) == 0 {
// 		return
// 	}
// 	node := preorder[0]
// 	idx := findIndex(node, inorder)

// 	leftInorder = inorder[:idx]
// 	if len(preorder) >= 2 {
// 		leftPre = preorder[1:len(leftInorder)]
// 	}
// 	rightInorder = inorder[idx:]
// 	rightPreorder = preorder[len(leftInorder):]
// 	return
// }

// 后记：这道题给我的感触有两点：
// 1. 这道题思路并不难想，但是边界问题很需要细节；
// 2.递归最好不要传递切片进去，否则下标越界问题判断起来很繁琐，像 labuladong 他就习惯使用完整切片+起止下标来判断，这样只要判断 start 和 end 的关系，即可
// 判定是否应该是 base case 了。赞！！ 这道题需要再练一次
