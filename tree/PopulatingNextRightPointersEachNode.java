package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode: You are given a perfect binary tree where all leaves are on the
 * same level, and every parent has two children.
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL. Initially, all next
 * pointers are set to NULL
 * 
 * Input: root = [1,2,3,4,5,6,7]
 * 
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * 
 * Explanation: Given the above perfect binary tree (Figure A), your function
 * should populate each next pointer to point to its next right node, just like
 * in Figure B. The serialized output is in level order as connected by the next
 * pointers, with '#' signifying the end of each level.
 */
public class PopulatingNextRightPointersEachNode {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Loop over the queue by Tree's Level
        while (!q.isEmpty()) {
            int size = q.size(); // init Tree's Level size
            Node current = q.poll(); // init first Node
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);

            // loop over all available nodes then connect, fetch their children for next round
            for (int i = 1; i < size; i++) {
                Node n = q.poll();
                current.next = n;
                current = n;
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
        }

        return root;
    }

    public Node connectRecursively(Node root) {
        if (root == null) return null;
        if (root.left != null) connectRecursively(root.left, root.right);
        return root;
    }

    private Node connectRecursively(Node prev, Node next) {
        if (next == null) return prev;
        if (prev == null) return next;

        // connect two nodes
        prev.next = next;

        // connect children
        Node n = connectRecursively(prev.left, prev.right);
        Node n1 = connectRecursively(n, next.left);
        connectRecursively(n1, next.right);

        return next;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}