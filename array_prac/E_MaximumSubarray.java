package array_prac;

import java.util.LinkedList;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 */
public class E_MaximumSubarray {
    public static int maxSubArray(int[] nums) throws Error{
        int max = nums[0], cursorMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // ingore the past total if current value is greater than that
            cursorMax = Math.max(nums[i], cursorMax + nums[i]);
            // update the max val
            max = Math.max(cursorMax, max);
        }

        

        return max;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }
}
