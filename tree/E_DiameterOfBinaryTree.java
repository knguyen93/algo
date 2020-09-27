package tree;

/**
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path between
 * any two nodes in a tree. This path may or may not pass through the root.
 * 
        1
       / \
      2   3
     / \     
    4   5    

 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class E_DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    // find the max of left & right sub-tree
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        // update max if the tree itself has many nodes than current max
        if (left + right + 1 > max) {
            max = left + right;
        }
        return Math.max(left, right) + 1;
    }
}
