package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * E.g:
 * 
 * Input: s = "abcabcbb" 
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Input: s = "bbbbb" 
 * Output: 1 
 * Explanation: The answer is "b", with the length of 1.
 */
public class M_LongestSubstringWithoutRepeatingCharacters {

    /**
     * This is a sliding window problem.
     * 
     * Idea: The Set's size is the number of non-duplicate Characters we looking for
     * 
     * 1. init two pointers at 0
     * 2. Loop until end's pointer reach the end of String
     * 2.1. if Character does not exist in the Set => add to Set & update max & end++
     * 2.2. otherwise, remove the Character at the start's pointer => start++
     * 
     * Credit to Nick White
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s))
            return 0;

        int start = 0, end = 0, length = s.length(), max = 0;
        Set<Character> set = new HashSet<>();

        while (end < length) {
            Character c = s.charAt(end);
            if (!set.contains(c)) {
                set.add(c);
                max = Math.max(set.size(), max);
                end++; // expand the Window
            } else {
                set.remove(s.charAt(start));
                start++; // reduce the Window's size from start
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
