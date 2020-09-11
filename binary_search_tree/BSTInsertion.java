package binary_search_tree;

import tree.TreeNode;

/**
 * Given the root node of a binary search tree (BST) and a value to be inserted
 * into the tree, insert the value into the BST. Return the root node of the BST
 * after the insertion. It is guaranteed that the new value does not exist in
 * the original BST.
 * 
 * Note that there may exist multiple valid ways for the insertion, as long as
 * the tree remains a BST after insertion. You can return any of them.
 */
public class BSTInsertion {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
            return root;
        }

        TreeNode n = root;
        // Travel to the leaf
        while (true) {
            if (val < n.val) { // left nodes
                if (n.left == null) {
                    n.left = newNode;
                    break;
                }
                n = n.left;
            } else { // right nodes
                if (n.right == null) {
                    n.right = newNode;
                    break;
                }
                n = n.right;
            }
        }

        return root;
    }
}
