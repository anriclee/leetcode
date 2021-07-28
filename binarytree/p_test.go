package binarytree

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestNumTrees(t *testing.T) {
	assert.Equal(t, numTrees(3), 5)
}

func TestD(t *testing.T) {
	// [5,3,6,2,4,null,null,1], k = 3
	n1 := TreeNode{
		Val: 1,
	}
	n2 := TreeNode{
		Val:  2,
		Left: &n1,
	}
	n4 := TreeNode{
		Val: 4,
	}
	n3 := TreeNode{
		Val:   3,
		Left:  &n2,
		Right: &n4,
	}
	n6 := TreeNode{
		Val: 6,
	}

	n5 := TreeNode{
		Val:   5,
		Left:  &n3,
		Right: &n6,
	}
	assert.Equal(t, kthSmallest(&n5, 3), 3)
}

func TestSplitParts(t *testing.T) {
	pre := []int{3, 9, 20, 15, 7}
	inorder := []int{9, 3, 15, 20, 7}
	p1, p2, p3, p4 := splitParts(pre, inorder)
	t.Error(p1)
	t.Error(p2)
	t.Error(p3)
	t.Error(p4)
}
