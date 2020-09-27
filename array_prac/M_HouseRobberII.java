package array_prac;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * E.g:
 * 
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * 
 * Devide into 2 Sub-Dynamic programming which are:
 * + [0 -> n-1]
 * + [1 -> n]
 */
public class M_HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        // get Max of rob(0, end -1) & rob(1, end);
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    // rob the bigest by Index
    private int rob(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int dp[] = new int[end - start + 1];
        dp[0] = 0;
        dp[1] = nums[start];
        int count = 1;

        for (int i = start + 1; i < end; i++) {
            dp[count + 1] = Math.max(dp[count], dp[count - 1] + nums[i]);
            count++;
        }

        return dp[dp.length - 1];
    }
}
