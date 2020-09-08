package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * 
 * Input:
    3
   / \
  9  20
    /  \
   15   7

 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
public class EverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> levels = new ArrayList<>();
        if (root == null) return levels;
      
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
      
        // Travel by level
        while (!q.isEmpty()) {
          int size = q.size();
          double total = 0;
          
          for (int i=0; i < size; i++) {
            TreeNode n = q.poll();
            total += n.val;
            
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
          }
          
          // Calculate everage on each level
          levels.add(total/size);
        }
      
        return levels;
    }
}
