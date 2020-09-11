package binary_search_tree;

import tree.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST. Calling next() will return the next
 * smallest number in the BST.
 * 
 * NOTES:
 * 
 * next() and hasNext() should run in average O(1) time and uses O(h) memory,
 * where h is the height of the tree.
 * 
 * You may assume that next() call will always be valid, that is, there will be
 * at least a next smallest number in the BST when next() is called.
 */
enum Khanh {
    KHANH
}

 public class BSTIterator {
    TreeNode root = null;

    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    /** @return the next smallest number */
    public int next() {
        if (root == null)
            return -1;
        int val = root.val;
        TreeNode n = root, prev = root;
        if (n.left != null) {
            // travel all the way down to the left
            while (n.left != null) {
                prev = n;
                n = n.left;
            }
        }

        if (n.left != null) {
            val = n.left.val;
            n.left = null;
        } else { // right OR root
            val = n.val;
            if (n == root) {
                root = root.right;
            } else {
                prev.left = n.right;
            }
        }

        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return root != null;
    }

    /**
     * Your BSTIterator object will be instantiated and called as such: 
     * 
     * BSTIterator obj = new BSTIterator(root); 
     * int param_1 = obj.next(); 
     * boolean param_2 = obj.hasNext();
     */

     public static void main(String[] args) {
         System.out.println(Khanh.KHANH instanceof Comparable);
     }
}
