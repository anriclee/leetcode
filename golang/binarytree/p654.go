package binarytree

func constructMaximumBinaryTree(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	}
	idx := maxIndex(nums)
	root := TreeNode{Val: nums[idx]}
	root.Left = constructMaximumBinaryTree(nums[:idx])
	if idx+1 <= len(nums)-1 {
		root.Right = constructMaximumBinaryTree(nums[idx+1:])
	}
	return &root
}

func maxIndex(nums []int) int {
	idx := 0
	maxVal := nums[0]
	for i := 0; i < len(nums); i++ {
		if nums[i] > maxVal {
			maxVal = nums[i]
			idx = i
		}
	}
	return idx
}
