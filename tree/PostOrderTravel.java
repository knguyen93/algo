package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Post-order traversal is to traverse the left subtree first. Then traverse the
 * right subtree. Finally, visit the root.
 * 
 * It is worth noting that when you delete nodes in a tree, deletion process
 * will be in post-order. That is to say, when you delete a node, you will
 * delete its left child and its right child before you delete the node itself.
 *
 * Input: [1,null,2,3]
 *  1
 *   \
 *    2
 *   /
 *  3
 *
 * Output: [3,2,1]
 */
public class PostOrderTravel {
    // left => right => root
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> items = new ArrayList<Integer>();
        if (root == null)
            return items;
        helper(root, items);
        return items;
    }

    private void helper(TreeNode root, List<Integer> items) {
        if (root.left != null) {
            helper(root.left, items);
        }

        if (root.right != null) {
            helper(root.right, items);
        }

        items.add(root.val);
    }

    /**
     * Put root node into main stack
     * Put children nodes into 2nd Stack in inverse order: Left => Right
     * Put root node into main stack in correct order: Right => Left
     */
    public List<Integer> postorderTraversalIteratively(TreeNode root) {
        List<Integer> items = new ArrayList<Integer>();
        if (root == null)
            return items;

        Stack<TreeNode> leftStack = new Stack<TreeNode>(), stack = new Stack<TreeNode>();
        leftStack.push(root);

        // push nodes into stack with the order as: Root => Right => Left
        while (!leftStack.isEmpty()) {
            TreeNode temp = leftStack.pop();
            stack.push(temp);
            if (temp.left != null) {
                leftStack.push(temp.left);
            }

            if (temp.right != null) {
                leftStack.push(temp.right);
            }
        }

        // Get items out as Left => Right => Root
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            items.add(n.val);
        }

        return items;
    }
}