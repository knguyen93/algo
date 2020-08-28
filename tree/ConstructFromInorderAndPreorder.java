package tree;

/**
 * Leetcode: Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 */
public class ConstructFromInorderAndPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] pre, int[] in, int pStart, int pEnd, int start, int end) {
        if (pStart > pEnd || start > end)
            return null;

        TreeNode root = new TreeNode(pre[pStart]);
        int rootIdx = -1;
        /**
         * Find root index in inorder list
         * - Left side are left nodes
         * - Right side are right nodes
         */
        for (int i = start; i <= end; i++) {
            if (in[i] == root.val) {
                rootIdx = i;
                break;
            }
        }

        int preEnd = pStart + rootIdx - start;
        // exclude the root node in inorder & preorder list
        root.left = buildTree(pre, in, pStart + 1, preEnd, start, rootIdx - 1);
        root.right = buildTree(pre, in, preEnd + 1, pEnd, rootIdx + 1, end);
        return root;
    }
}