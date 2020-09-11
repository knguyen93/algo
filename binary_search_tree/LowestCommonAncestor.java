package binary_search_tree;

import tree.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST. 
 * 
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the
 * lowest node in T that has both p and q as descendants (where we allow a node
 * to be a descendant of itself).”
 * 
 * Given binary search tree: root = [6,2,8,0,4,7,9,null,null,3,5]
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * 
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * 
 * Constraints:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cursor = root;

        while (cursor != null && (cursor.left != null || cursor.right != null)) {
            // p & q are child of root
            if ((cursor.val < p.val && cursor.val > q.val) || (cursor.val > p.val && cursor.val < q.val)) {
                return cursor;
            }

            // p & q are on the same side
            if (cursor.val == p.val || cursor.val == q.val) {
                return cursor;
            }

            cursor = cursor.val < p.val ? cursor.right : cursor.left;
        }

        return null;
    }
}
