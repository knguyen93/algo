package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode: Given a binary tree, check whether it is a mirror of itself (ie,
 * symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric
 * 
 *     1
 *   /  \
 *  2    2 
 * / \  / \
 * 3  4 4  3
 */
public class SymmetricTree {

    /**
     * Iterative
     */
    public boolean isSymmetric(TreeNode root) {
        // check left vs right
        if (root == null || (root.left == null && root.right == null))
            return true;

        if ((root.left == null && root.right != null) 
                || (root.left != null && root.right == null)
                || root.left.val != root.right.val)
            return false;

        /**
         * check: left.left vs right.right 
         *  && left.right vs right.left
         */
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root.left.left);
        q.add(root.right.right);
        q.add(root.left.right);
        q.add(root.right.left);

        while (!q.isEmpty()) {
            // get two nodes each time and compare
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();

            if (n1 == null && n2 == null)
                continue;

            if ((n1 == null && n2 != null) || (n1 != null && n2 == null) || n1.val != n2.val)
                return false;

            // put nested child for next round
            q.add(n1.left);
            q.add(n2.right);
            q.add(n1.right);
            q.add(n2.left);
        }
        return true;
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        // check left vs right
        if (root == null)
            return true;
        return isSymmetricRecursive(root.left, root.right);
    }

    private boolean isSymmetricRecursive(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null)
            return true;
        if ((n1 == null && n2 != null) || (n1 != null && n2 == null) || n1.val != n2.val)
            return false;
        /**
         * check: left.left vs right.right 
         *  && left.right vs right.left
         */
        return isSymmetricRecursive(n1.left, n2.right) && isSymmetricRecursive(n1.right, n2.left);
    }
}