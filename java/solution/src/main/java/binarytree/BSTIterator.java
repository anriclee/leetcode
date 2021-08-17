package binarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Developed by Lee Happily.
 * <p>
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 * <p>
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
 * <p>
 * You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
 */
public class BSTIterator {
    private List<TreeNode> list = new ArrayList<>();
    private Iterator<TreeNode> iterable;

    public BSTIterator(TreeNode root) {
        inorder(root);
        iterable = list.iterator();
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }

    public int next() {
        return this.iterable.next().val;
    }

    public boolean hasNext() {
        return this.iterable.hasNext();
    }
}

// 中序的非递归遍历

