package array_prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * e.g:
 * Input: [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class M_Permutations {

    public static List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> results = new ArrayList<>();
      permute(Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList<>(), results);
      return results;
    }
  
    /**
     * Idea:
     * 
     * 1. Pick an element from the Array
     * 2. Add element to currentLst & permute the remaining Array
     * 3. As soon as the Array is empty, add currentLst to results
     */
    private static void permute(List<Integer> nums, List<Integer> currentLst, List<List<Integer>> results) {
      if (nums.size() == 0) {
        results.add(currentLst);
        return;
      }

      for (int i =0; i < nums.size(); i++) {
        Integer n = nums.get(i);
        nums.remove(n);
        List<Integer> list = new ArrayList<>(currentLst);
        list.add(n);
        permute(nums, list, results);
        nums.add(i, n);
      }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[] {1,2,3}));
    }
}
