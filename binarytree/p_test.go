package binarytree

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test(t *testing.T) {
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