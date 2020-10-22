package array_prac;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 */
public class M_MajorityElementII {
    public static List<Integer> majorityElement2(int[] nums) {
        int limit = nums.length / 3;
        return IntStream.of(nums).boxed().collect(
                Collectors.collectingAndThen(
                    Collectors.groupingBy(Function.identity(), Collectors.counting()), m -> {
                        m.values().removeIf(k -> k <= limit);
                        return new ArrayList<>(m.keySet());
                }));
    }

    public static List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int num = nums[0], count = 0, limit = nums.length / 3;
        List<Integer> results = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                if (count >= limit)
                    results.add(num);
                num = nums[i];
                count = 0;
            }
        }

        if (count >= limit)
            results.add(num);

        return results;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3 };
        int[] arr2 = { 1 };
        int[] arr3 = { 1, 2 };

        System.out.println(majorityElement(arr)); // 3
        System.out.println(majorityElement(arr2)); //1
        System.out.println(majorityElement(arr3)); //1,2
    }
}
