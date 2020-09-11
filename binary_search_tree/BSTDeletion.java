package binary_search_tree;

import tree.TreeNode;

/**
 * Strategy:
 * 
 * 1. If the target node has no child, we can simply remove the node.
 * 2. If the target node has one child, we can use its child to replace itself.
 * 3. If the target node has two children, replace the node with its in-order successor or predecessor node and delete that node.
 * 
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
 * Return the root node reference (possibly updated) of the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * 1. Search for a node to remove.
 * 2. If the node is found, delete the node.
 */
public class BSTDeletion {
    public TreeNode deleteNode(TreeNode root, int key) {
        // Special cases
        if (root == null)
            return null;

        // Search for the node
        TreeNode prev = root, cursor = root;
        while (cursor != null && cursor.val != key) {
            prev = cursor;
            cursor = key < cursor.val ? cursor.left : cursor.right;
        }

        if (cursor == null)
            return root;

        // remove the found node
        boolean isLeft = prev.left == cursor;

        if (cursor.left != null && cursor.right != null) {
            // 1. has 2 children => replace with successor or predecessor, then remove it
            TreeNode removedNode = cursor, prevC = cursor;

            // travel to left most of to the right
            cursor = cursor.right;
            isLeft = false;
            while (cursor.left != null) {
                prevC = cursor;
                cursor = cursor.left;
                isLeft = true;
            }

            removedNode.val = cursor.val;
            if (prevC == root) {
                if (isLeft) {
                    removedNode.left = cursor.right;
                } else {
                    removedNode.right = cursor.right;
                }
            } else {
                if (isLeft) {
                    prevC.left = cursor.right;
                } else {
                    prevC.right = cursor.right;
                }
            }
        } else {
            // 2. has no child => remove it
            // 3. has one child => use that child to replace it
            TreeNode replacement = cursor.left != null ? cursor.left : cursor.right;
            if (cursor == root) {
                return replacement;
            }

            if (isLeft) {
                prev.left = replacement;
            } else {
                prev.right = replacement;
            }
        }

        return root;
    }
}
