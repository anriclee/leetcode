package binarytree

func numTrees(n int) int {
	memo := initTwoDimensionArray(n + 2)
	return treeCount(1, n, memo)
}

func initTwoDimensionArray(n int) [][]int {
	memo := make([][]int, n)
	for i := range memo {
		memo[i] = make([]int, n)
	}
	return memo
}

func treeCount(low, high int, memo [][]int) int {
	if low > high {
		// 说明此时已经没有子树了，该节点为叶子节点
		memo[low][high] = 1
		return 1
	}
	sum := 0
	for i := low; i <= high; i++ {
		leftCnt := memo[low][i-1]
		rightCnt := memo[i+1][high]
		if leftCnt == 0 {
			leftCnt = treeCount(low, i-1, memo)
			memo[low][i-1] = leftCnt
		}
		if rightCnt == 0 {
			rightCnt = treeCount(i+1, high, memo)
			memo[i+1][high] = rightCnt
		}
		sum += leftCnt * rightCnt
	}
	return sum
}
