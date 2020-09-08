package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
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
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class ZigzagLevelOrderTravel {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<TreeNode> nextS = new Stack<TreeNode>();
        List<Integer> level = new ArrayList<>();
        boolean lTr = true;
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            level.add(n.val);

            //Since Stack works as LIFO, we need to reverse the order of adding Left & Right nodes
            if (lTr) {
                if (n.left != null) nextS.push(n.left);
                if (n.right != null) nextS.push(n.right);
            } else {
                if (n.right != null) nextS.push(n.right);
                if (n.left != null) nextS.push(n.left);
            }

            if (s.isEmpty()) { // end of current level
                list.add(level);
                level = new ArrayList<>();
                s = nextS;

                // reset everything
                nextS = new Stack<TreeNode>();
                lTr = !lTr;
            }
        }

        return list;
    }
}
