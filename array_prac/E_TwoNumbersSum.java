package array_prac;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * You can return the answer in any order.
 */
public class E_TwoNumbersSum {

    /**
     * Runtime: 2 ms, faster than 73.64% of Java online submissions for Two Sum.
     * Memory Usage: 39.6 MB, less than 72.85% of Java online submissions for Two Sum.
     */
    public static int[] twoSumHash(int[] nums, int target) {
        if (nums == null || nums.length == 0)
        return null;
        
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], i);
        }
        
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x = target - nums[i];
            if (m.containsKey(x) && i != m.get(x)) {
                return new int[] { i, m.get(x) };
            }
        }
        
        return null;
    }
    
    public static int[] twoSumHash3(int[] nums, int k) { 
        Map<Integer, Integer> pairs = new HashMap<>();
        
        for (int n : nums) {
            int target = k -n;
            if (pairs.containsKey(target)) {
                    return new int[]{n, target};
            } else {
                pairs.put(n, 0);
            }
        }

        return null;
    }

    /**
     * Runtime: 52 ms, faster than 34.13% of Java online submissions for Two Sum.
     * Memory Usage: 39.6 MB, less than 71.55% of Java online submissions for Two Sum.
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return null;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }

        return null;
    }

    public static int twoSum(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

            int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 15, 9, 10, 2, 1, 5, 2, 6, 11, 6 };
        System.out.println(Arrays.toString(twoSumHash3(nums, 17)));
    }
}
