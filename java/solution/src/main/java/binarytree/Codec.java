package binarytree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Developed by Lee Happily. 
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftChild = this.serialize(root.left);
        String rightChild = this.serialize(root.right);
        return root.val + "," + leftChild + "," + rightChild;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] splits = data.split(",");
        if (splits.length == 0) {
            return null;
        }
        Queue<String> queue = new ArrayDeque<>(splits.length);
        queue.addAll(Arrays.asList(splits));
        return this.deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String n = queue.poll();
        if (n == null) {
            return null;
        }
        if ("#".equals(n)) {
            return null;
        }
        int v = Integer.parseInt(n);
        TreeNode root = new TreeNode(v);
        root.left = this.deserializeHelper(queue);
        root.right = this.deserializeHelper(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

// 后记：
// 所有打算使用递归辅助函数的，在调用递归辅助函数处，都别加太多逻辑在里面，在递归里面处理逻辑即可