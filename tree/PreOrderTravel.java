package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Pre-order traversal is to visit as follow orders:
 * 1. the root
 * 2. the left subtree
 * 3. the right subtree
 * 
 * LeetCode: Given a binary tree, return the preorder traversal of its nodes'
 * values.
 * 
 * Input: [1,null,2,3]
 * 
 * 1 
 *  \ 
 *    2 
 *  / 
 * 3
 * 
 * Output: [1,2,3]
 */
public class PreOrderTravel {
    public List<Integer> preorderTraversalIteratively(TreeNode root) {
        List<Integer> items = new ArrayList<Integer>();
        if (root == null) return items;
      
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        treeStack.push(root);
      
        while (treeStack.size() > 0) {
          TreeNode item = treeStack.pop();
          // root value
          items.add(item.val);
          
          // push right on hold
          if (item.right != null) {
            treeStack.push(item.right);
          }
          
          // make sure we always handle left node first
          if (item.left != null) {
            treeStack.push(item.left);
          }
        }
      
        return items;
    }
    
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> items = new ArrayList<Integer>();
        if (root == null) return items;
        
        //travel root
        items.add(root.val);
      
        // travel left nodes
        if (root.left != null) {
          items.addAll(preorderTraversalRecursive(root.left));
        }
      
        // travel right nodes
        if (root.right != null) {
          items.addAll(preorderTraversalRecursive(root.right));
        }
      
        return items;
    }
}