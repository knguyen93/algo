package tree;

import java.util.*;

/**
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 * 
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar
 * 
 * E.g:
 * 
 * Input: 
 * root1 = [3,5,1,6,2,9,8,null,null,7,4], 
 * root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 
 * Output: true
 * 
 * Input: root1 = [1], root2 = [2]
 * Output: false
 * 
 * Input: root1 = [1,2,3], root2 = [1,3,2]
 * Output: false
 */
public class E_CompareLeafsOfTrees {

    /**
     * Idea: travel and get all leafs of each Tree and compare these two list
     * 
     * Runtime: O(n) with n is the number of Nodes
     * Space: O(k) with k is the number of Leafs
     */
    static boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();
        getLeafs(leafs1, root1);
        getLeafs(leafs2, root2);
        return leafs1.equals(leafs2);
    }

    static void getLeafs(List<Integer> lst, TreeNode root) {
        if (root.left == null && root.right == null) {
            lst.add(root.val);
            return;
        }

        if (root.left != null)
            getLeafs(lst, root.left);
        if (root.right != null)
            getLeafs(lst, root.right);
    }

    public static void main(String[] args) {
        
    }
}
