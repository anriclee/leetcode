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
    private LinkedList<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        TreeNode ptr = root;
        while (ptr != null) {
            stack.push(ptr);
            ptr = ptr.left;
        }
    }

    public int next() {
        TreeNode peek = stack.pop();
        if (peek.right != null) {
            TreeNode ptr = peek.right;
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
        }
        return peek.val;
    }

    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
}

// 后记：
// 中序遍历递归遍历解决。
// 题目最后要求以 O(h）的空间复杂度解决，尝试解决 done it!!!!

// 非递归遍历有点不太熟悉。
// 中序的非递归遍历

