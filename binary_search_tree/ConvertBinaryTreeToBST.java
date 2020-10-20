package binary_search_tree;

import java.util.*;

public class ConvertBinaryTreeToBST {
    // convert Binary Tree to BST
    /**
     * 
     *      3 
     *   4     2 
     * 1  5      6 
     */
    static void convertBTtreeToBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Map<TreeNode, Integer> left = new HashMap<>();
        Map<TreeNode, Integer> right = new HashMap<>();
        travelAndCount(root, values, left, right);
        // sort ASC
        Collections.sort(values);
        reconstruct(root, values, left, right, 0);
    }

    static void reconstruct(TreeNode root, List<Integer> values, Map<TreeNode, Integer> left, 
        Map<TreeNode, Integer> right, int start) {
            int l = left.getOrDefault(root, 0);
            root.val = values.get(l + start);

            if (root.left != null)
                reconstruct(root.left, values, left, right, start);
            
            if (root.right != null)
                reconstruct(root.right, values, left, right, start + l + 1);
    }

    static int travelAndCount(TreeNode root, List<Integer> values, Map<TreeNode, Integer> left, Map<TreeNode, Integer> right) {
        values.add(root.val);

        int l = 0, r = 0;
        if (root.left != null) {
            l = travelAndCount(root.left, values, left, right);
            left.put(root, l);
        }
        
        if (root.right != null)  {
            r = travelAndCount(root.right, values, left, right);
            right.put(root, r);
        }
        
        return 1 + l + r;   
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(6);

        printTree(root);
        convertBTtreeToBST(root);
        printTree(root);
    }

    static void printTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(), count = 0;
            
            while (count < size) {
                TreeNode n = q.poll();
                count++;

                if (n == null) {
                    System.out.print("null ");
                    continue;
                }
                System.out.print(n.val + " ");
                q.add(n.left);
                q.add(n.right);
            }
            count = 0;
            System.out.println("\n");
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
