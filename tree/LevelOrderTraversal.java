package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Breadth first search
 * 
 * Leetcode: Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * Input: [3,9,20,null,null,15,7]
 * 
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 
 * Output: [[3], [9,20], [15,7]]
 * 
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null)
            return levels;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> items = new ArrayList<>();
        q.add(root);
        int size = 0;

        // loop all level's of current tree
        while (!q.isEmpty()) {
            size = q.size();// break point
            int count = 0;

            // only travel to the end of the current tree level
            while (count < size) {
                TreeNode n = q.poll();
                items.add(n.val);
                count++;

                if (n.left != null)
                    q.add(n.left);
                if (n.right != null)
                    q.add(n.right);
            }
            levels.add(items);
            items = new ArrayList<>();
        }
        return levels;
    }
}