package array_prac;

import java.util.Arrays;

/**
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * e.g:
 * 
 * Input: [2, 6, 4, 8, 10, 9, 15] 
 * Output: 5 
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to 
 * make the whole array sorted in ascending order.
 * 
 * NOTES:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class E_ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int[] cpNums = nums.clone();
        Arrays.sort(cpNums); // Sort the array
        int startIdx = 0, endIdx = nums.length;

        // find the start index of different element
        for (int i = 0; i < cpNums.length; i++) {
            if (cpNums[i] != nums[i]) {
                startIdx = i;
                break;
            }

            if (i == cpNums.length - 1)
                return 0;
        }

        // find the end index of different element
        for (int i = cpNums.length - 1; i >= 0; i--) {
            if (cpNums[i] != nums[i]) {
                endIdx = i;
                break;
            }
        }

        return endIdx - startIdx + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 6, 4, 8, 10, 9, 15 };
        System.out.println(findUnsortedSubarray(arr));
    }
}
