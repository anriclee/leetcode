package binarytree

/**
 * Definition for a Node.
 */
type Node struct {
	Val   int
	Left  *Node
	Right *Node
	Next  *Node
}

func connect(root *Node) *Node {
	if root == nil {
		return nil
	}
	connectNodes(root.Left, root.Right)
	return root
}

func connectNodes(node1, node2 *Node) {
	if node1 == nil || node2 == nil {
		return
	}
	node1.Next = node2
	connectNodes(node1.Left, node1.Right)
	connectNodes(node2.Left, node2.Right)
	connectNodes(node1.Right, node2.Left)
}

// 后记：开始的思路是传入两个参数：root 节点和节点的兄弟节点 siblingNode，将 root 节点的左右子节点相连，之后再将
// root 右子节点的 next 指向 siblingNode
// 这种思路行不通：会在下下一层将信息丢失
// 采用第二种思路：每个递归函数只干一件事情：连接两个 node（采用这种思路的时候，最开始也想在一个递归函数中
// 中干多件事，最终导致逻辑混乱。
// 感悟：在递归函数中，只做最少的事情，只做简单的事情，剩下的用递归去描述。
// 这道题反复品味。
