package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * In-order traversal is to traverse the left subtree first. Then visit the
 * root. Finally, traverse the right subtree.
 * 
 * Typically, for binary search tree, we can retrieve all the data in sorted
 * order using in-order traversal
 * 
 * Leetcode: Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Input: [1,null,2,3]
 *  1
 *   \
 *    2
 *   /
 *  3
 *
 * Output: [1,3,2]
 */
public class InOrderTravel {
    /**
     * Iterative and modify source
     */
    public List<Integer> inorderTraversalIteratively(TreeNode root) {
        // left => root => right
        List<Integer> items = new ArrayList<Integer>();
        if (root == null)
            return items;

        TreeNode temp = null, cursor = null;
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        treeStack.push(root);

        while (treeStack.size() > 0) {
            cursor = treeStack.pop();
            // only get value if node has no left OR right child
            if (cursor.left == null && cursor.right == null) {
                items.add(cursor.val);
            } else {
                // push right node
                if (cursor.right != null)
                    treeStack.push(cursor.right);

                temp = cursor.left;

                // push root node
                cursor.right = null;
                cursor.left = null;
                treeStack.push(cursor);

                // push left node
                if (temp != null)
                    treeStack.push(temp);
            }
        }
        return items;
    }

    /**
     * Iterative without modify source
     */
    public List<Integer> inorderTraversalIteratively2(TreeNode root) {
        // left => root => right
        List<Integer> items = new ArrayList<Integer>();
        if (root == null)
            return items;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cursor = root;

        while (cursor != null || !stack.isEmpty()) {
            // handle left nodes
            while (cursor != null) {
                // push root
                stack.push(cursor);
                // push left node
                cursor = cursor.left;
            }

            cursor = stack.pop();
            items.add(cursor.val);

            // handle right nodes
            cursor = cursor.right;
        }

        return items;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        // left => root => right
        List<Integer> items = new ArrayList<Integer>();
        if (root == null)
            return items;
        helper(root, items);
        return items;
    }

    private void helper(TreeNode root, List<Integer> items) {
        if (root.left != null)
            helper(root.left, items);
        items.add(root.val);
        if (root.right != null)
            helper(root.right, items);
    }
}