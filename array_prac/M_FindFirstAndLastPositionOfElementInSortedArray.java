package array_prac;

/**
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * 
 * e.g:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non decreasing array.
 * -10^9 <= target <= 10^9
 * 
 */
public class M_FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * Runtime O(log n) mean we need to use binary search
     * 
     * Idea:
     * 
     * We devide array into 2 sub-array
     * Check the middle item:
     * 1. equal to target => expand the range and return
     * 2. less than target => search on the right
     * 3. otherwise, search on the left
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        return helper(nums, target, 0, nums.length - 1);
    }

    private int[] helper(int[] nums, int target, int start, int end) {
        // base case
        if (start == end && nums[start] == target) return new int[] { start, end };
        if (start >= end) return new int[] { -1, -1 };

        int mid = start + (end - start) / 2; // decide whether to go to the left/ right

        // when found the target, we need to expand the target range
        if (nums[mid] == target) {
            int first = mid, second = mid;
            while (first >= start && nums[first] == target) first--;
            while (second <= end && nums[second] == target) second++;
            return new int[] { first + 1, second - 1 };
        }

        if (nums[mid] < target)
            return helper(nums, target, mid + 1, end);

        return helper(nums, target, start, mid - 1);
    }
}
