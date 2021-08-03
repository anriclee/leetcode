package binarytree

import (
	"strconv"
	"strings"
)

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type Codec struct {
}

func Constructor() Codec {
	return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
	if root == nil {
		return "#"
	}
	left := this.serialize(root.Left)
	right := this.serialize(root.Right)
	return strings.Join([]string{strconv.Itoa(root.Val), left, right}, ",")
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	if len(data) == 0 {
		return nil
	}
	parts := strings.Split(data, ",")
	start := 0
	end := len(parts) - 1
	return buildSubTree(parts, &start, &end)
}

func buildSubTree(tokens []string, start, end *int) *TreeNode {
	if *start > *end {
		return nil
	}
	if tokens[*start] == `#` {
		return nil
	}
	val, err := strconv.Atoi(tokens[*start])
	if err != nil {
		panic(err)
	}
	node := &TreeNode{Val: val}
	*start++
	node.Left = buildSubTree(tokens, start, end)
	node.Right = buildSubTree(tokens, start, end)
	return node
}

/**
 * Your Codec object will be instantiated and called as such:
 * ser := Constructor();
 * deser := Constructor();
 * data := ser.serialize(root);
 * ans := deser.deserialize(data);
 */
