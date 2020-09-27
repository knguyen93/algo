package array_prac;

import java.util.Arrays;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * e.g:
 * 
 * Input: [2,2,1]
 * Output: 1
 * 
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class E_SingleNumber {
    /**
     * Runtime: 4 ms, faster than 47.93% of Java online submissions for Single Number. 
     * Memory Usage: 40 MB, less than 87.34% of Java online submissions for Single Number.
     */
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            if (i + 1 == nums.length || nums[i] != nums[i + 1])
                return nums[i];
        }

        return 0;
    }

    /**
     * From LeetCode Solution
     * 
     * Using Bit Manipulation
     * 
     * a XOR a = 0
     * a XOR 0 = a
     * 
     * => a XOR b XOR a =(a XOR a) XOR b = 0 XOR b=b
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number. 
     * Memory Usage: 40.7 MB, less than 41.32% of Java online submissions for Single Number.
     */
    public int singleNumber2(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
