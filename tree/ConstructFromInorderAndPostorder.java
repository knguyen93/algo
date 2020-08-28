package tree;

/**
 * Leetcode: Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 */
public class ConstructFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0)
            return null;

        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] in, int[] post, int inStart, int inEnd, int pStart, int pEnd) {
        if (inStart > inEnd || pStart > pEnd)
            return null;

        TreeNode root = new TreeNode(post[pEnd]);
        int rootIndex = -1;

        /**
         * Find the index of root in inorder list.
         * - Left side are the left nodes
         * - Right side are right nodes
         */
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val) {
                rootIndex = i;
                break;
            }
        }

        // Split postorder list into left nodes and right nodes
        int rightPStart = pStart + rootIndex - inStart;
        // exclude the root node in inorder & preorder list
        root.left = buildTree(in, post, inStart, rootIndex - 1, pStart, rightPStart - 1);
        root.right = buildTree(in, post, rootIndex + 1, inEnd, rightPStart, pEnd - 1);
        return root;
    }
}