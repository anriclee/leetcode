package binarytree;

import java.util.*;

/**
 * Developed by Lee Happily.
 */
public class DuplicateTree {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<String> memos = new HashSet<>();
        Map<String, TreeNode> nodes = new HashMap<>();
        List<TreeNode> ret = new ArrayList<>();
        transverse(root, memos, nodes);
        for (Map.Entry<String, TreeNode> entry : nodes.entrySet()) {
            ret.add(entry.getValue());
        }
        return ret;
    }

    // 后序遍历是精髓
    private String transverse(TreeNode root, Set<String> memos, Map<String, TreeNode> nodes) {
        if (root == null) {
            return "#";
        }
        String left = transverse(root.left, memos, nodes);
        String right = transverse(root.right, memos, nodes);
        String subTree = left + "," + right + "," + root.val;
        if (memos.contains(subTree)) {
            // some tree duplicate with me
            nodes.putIfAbsent(subTree, root);
            return subTree;
        }
        // has no duplicate
        memos.add(subTree);
        return subTree;
    }
}

// 后记： 后序遍历很难想到。备忘录模式是一种很实用的解题思路，后面可以着重做一些这方面的题。
