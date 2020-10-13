package array_prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly once.
 * 
 * e.g:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Input: strs = [""]
 * Output: [[""]]
 * 
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * Constraints:
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 */
public class M_GroupAnagrams {

    /**
     * Idea:
     * 
     * Loop through the Array:
     * - sort letters in each word
     * - save List of Words has same sorted letters in a map with the key is the sorted letters
     * 
     * Runtime: O(N * K log K) ::: N (total elements in array), K log K (the time to sort K letters in each word)
     * Space: O (N * K) ::: N (total elements in array), K (the maximum letter in a word)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (int i =0; i < strs.length; i++) {
            char letters[] = strs[i].toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            List<String> lst = groups.getOrDefault(key, new ArrayList<>());
            lst.add(strs[i]);
            groups.put(key, lst);
        }

        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        String arr[] = {"eat","tea","tan","ate","nat","bat"};
        String arr2[] = {"a"};

        /**
         * We can easily see that these two Anagrams are equals after sorted
         * So we will use this to determine and grouping these words
         */
        char a[] = {'a', 'e', 't'};
        char a2[] = {'t', 'a', 'e'};
        Arrays.sort(a);
        Arrays.sort(a2);
        System.out.println("a: " + new String(a).equals(new String(a2)));

        System.out.println(groupAnagrams(arr)); //[["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams(arr2)); //[["bat"]]
    }
}
