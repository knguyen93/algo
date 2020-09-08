package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example: 
 * 
 * Given binary tree [3,9,20,null,null,15,7]
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * Results:
 * 
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BottomUpLevelOrderTravel {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        // Travel from root and push to Stack
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> items = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                items.add(n.val);
                if (n.left != null)
                    q.add(n.left);
                if (n.right != null)
                    q.add(n.right);
            }

            stack.push(items);
        }

        // pop items out of the Stack to get reverse order
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
