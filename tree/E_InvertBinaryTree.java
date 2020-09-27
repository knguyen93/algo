package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.
 * Example:
 * 
 * Input:
 * 
     4
   /   \
  2     7
 / \   / \
1   3 6   9

 * Output:
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class E_InvertBinaryTree {
    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) return root;
        TreeNode left = root.right;
        root.right = invertTreeRecursive(root.left);
        root.left = invertTreeRecursive(left);
        return root;
      }
    
      public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
          TreeNode n = q.poll();
          TreeNode left = n.left;
          n.left = n.right;
          n.right = left;
          if (n.left != null) q.add(n.left);
          if (n.right != null) q.add(n.right);
        }
        
        return root;
      }
}
