package binarytree

func buildTree(inorder []int, postorder []int) *TreeNode {
	return buildAssist(inorder, 0, len(inorder)-1, postorder, 0, len(postorder)-1)
}

func buildAssist(inorder []int, inStart, inEnd int, postorder []int, postStart, postEnd int) *TreeNode {
	if inStart > inEnd {
		return nil
	}
	rootVal := postorder[postEnd]
	var index int
	for i := inStart; i <= inEnd; i++ {
		if inorder[i] == rootVal {
			index = i
			break
		}
	}
	leftSize := index - inStart
	rootNode := &TreeNode{Val: rootVal}
	rootNode.Left = buildAssist(inorder, inStart, index-1, postorder, postStart, postStart+leftSize-1)
	rootNode.Right = buildAssist(inorder, index+1, inEnd, postorder, postStart+leftSize, postEnd-1)
	return rootNode
}
