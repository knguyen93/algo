package array_prac;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * E.g:
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class E_MajorityElement {
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Boyer-Moore Voting Algorithm
     * 
     * If we had some way of counting instances of the majority element as +1 and instances of any other element as -1
     * summing them would make it obvious that the majority element is indeed the majority element.
     * 
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
