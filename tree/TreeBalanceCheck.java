package tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * "a binary tree in which the left and right subtrees of every node differ in height by no more than 1."
 */
public class TreeBalanceCheck {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        int diff = left > right ? left - right : right - left;

        if (diff <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;

        return false;
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);

        // height is max of left & right
        return 1 + (left > right ? left : right);
    }
}
