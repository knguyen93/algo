package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = -1,
 * 
 * [1,-2,-3,1,3,-2,null,-1]
 * 
 * Results:
 * 
 * [[1,-2,1,-1]]
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null)
            return results;

        List<Integer> lst = new ArrayList<>();
        checkPathSum(results, lst, root, sum);

        return results;
    }

    private void checkPathSum(List<List<Integer>> result, List<Integer> lst, TreeNode root, int sum) {
        int val = root.val;
        if (val == sum && root.left == null && root.right == null) {
            lst.add(val);
            result.add(lst);
        } else {
            lst.add(val);
            if (root.left != null)
                checkPathSum(result, new ArrayList<>(lst), root.left, sum - val);

            if (root.right != null)
                checkPathSum(result, new ArrayList<>(lst), root.right, sum - val);
        }
    }
}
