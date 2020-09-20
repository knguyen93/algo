package binary_search_tree;

import tree.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * E.G:
 * 
 * Given the sorted array: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * 
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end)
            return null;

        // avoid big number
        int mIdx = (end - start) / 2 + start;

        // create root with a middle number to guarantee its balanced
        TreeNode root = new TreeNode(nums[mIdx]);
        root.left = helper(nums, start, mIdx - 1);
        root.right = helper(nums, mIdx + 1, end);
        return root;
    }
}
