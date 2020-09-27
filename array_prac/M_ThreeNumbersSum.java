package array_prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * with the helps of git/eMahtab
 */
public class M_ThreeNumbersSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return results;
        Arrays.sort(nums); // sort array in order to use two pointers

        // Devide three sum problem into two sum problem
        for (int i = 0; i < nums.length; i++) {
            // avoid duplication
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1]))
                twoSum(results, nums, 0 - nums[i], i);
        }

        return results;
    }

    private void twoSum(List<List<Integer>> results, int[] nums, int target, int skip) {
        // Using two pointers run from start & end
        int p1 = skip + 1, p2 = nums.length - 1;
        while (p1 < p2) {
            if (nums[p1] + nums[p2] > target) {
                p2--;
                continue;
            }

            if (nums[p1] + nums[p2] < target) {
                p1++;
                continue;
            }

            results.add(Arrays.asList(nums[skip], nums[p1], nums[p2]));
            // move 1 step & make sure no dupplication
            while (p1 < p2 && nums[p1] == nums[p1 + 1])
                p1++;
            while (p1 < p2 && nums[p2] == nums[p2 - 1])
                p2--;
            p1++;
            p2--;
        }
    }

    public static void main(String[] args) {
        M_ThreeNumbersSum s = new M_ThreeNumbersSum();
        System.out.println(s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }
}
