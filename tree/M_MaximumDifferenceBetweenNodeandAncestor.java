package tree;

import java.util.LinkedList;
import java.util.Queue;

public class M_MaximumDifferenceBetweenNodeandAncestor {
    int maxD = 0;

    public int maxAncestorDiffIterative(TreeNode root) {
        maxD = 0;//reset
        if (root == null)
            return maxD;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> nextQ = new LinkedList<TreeNode>();
        nextQ.add(root);

        // get the node and go all the way down
        while (!nextQ.isEmpty()) {
            TreeNode temp = nextQ.poll();
            int parent = temp.val;
            q.add(temp);
            if (temp.left != null)
                nextQ.add(temp.left);
            if (temp.right != null)
                nextQ.add(temp.right);

            // go all the way down to the leaf
            while (!q.isEmpty()) {
                int size = q.size();

                for (int i = 0; i < size; i++) {
                    TreeNode n = q.poll();
                    int left = 0;
                    int right = 0;

                    if (n.left != null) {
                        q.add(n.left);
                        left = Math.abs(parent - n.left.val);
                    }
                    if (n.right != null) {
                        q.add(n.right);
                        right = Math.abs(parent - n.right.val);
                    }

                    maxD = Math.max(maxD, Math.max(left, right));
                }
            }
        }

        return maxD;
    }

    /**
     * Faster approach
     */
    public int maxAncestorDiffRecursive(TreeNode root) {
        maxD = 0;//reset
        if (root == null)
            return maxD;
        maxDiff(root, root.val, root.val);
        return maxD;
    }

    /**
     * Max diff can be resulted from:
     * 1. root - minimum ancestor val
     * 2. root - maximum ancestor val
     * 
     * So we only keep thoese two values
     */
    private void maxDiff(TreeNode root, int min, int max) {
        if (root == null)
            return;

        maxD = Math.max(maxD, Math.abs(root.val - min));
        maxD = Math.max(maxD, Math.abs(root.val - max));

        int newMin = Math.min(root.val, min), newMax = Math.max(root.val, max);

        maxDiff(root.left, newMin, newMax);
        maxDiff(root.right, newMin, newMax);
    }
}
