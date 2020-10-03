package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A string S of lowercase English letters is given. We want to partition this
 * string into as many parts as possible so that each letter appears in at most
 * one part, and return a list of integers representing the size of these parts.
 * 
 * E.g:
 * 
 * Input: S = "ababcbacadefegdehijhklij" 
 * Output: [9,7,8] Explanation: The partition is "ababcbaca", "defegde", "hijhklij". This is a partition so that
 * each letter appears in at most one part. 
 * 
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * 
 * NOTES:
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 */
public class M_PartitionLabels {
    /**
     * The idea: 
     * 1. Find the last index (lastIdx) of current Character (curr)
     * 2. Loop from start to lastIdx
     * 3. If found any character other than curr, put new character into the set & update max lastIdx
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> results = new ArrayList<>();

        // keep characters between start to the last index of curr
        Set<Character> set = new HashSet<>();

        Character curr = S.charAt(0);
        int lastIdx = S.lastIndexOf(curr);
        int start = -1;

        for (int i = 0; i < S.length(); i++) {
            curr = S.charAt(i);
            if (i < lastIdx) {
                if (!set.contains(curr)) {
                    // add new item to set
                    set.add(curr);
                    // update lastIdx if the lastIdx of in range character exceed the lastIdx
                    lastIdx = Math.max(lastIdx, S.lastIndexOf(curr));
                }
            } else {
                results.add(lastIdx - start);
                start = i;
                // We might want to update the lastIdx to solve corner cases
                lastIdx = i + 1 < S.length() ? S.lastIndexOf(S.charAt(i + 1)) : lastIdx;
                set = new HashSet<>();
            }
        }

        return results;
    }

    /**
     * Leetcode Solution
     */
    public List<Integer> partitionLabels1(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;
        
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        M_PartitionLabels test = new M_PartitionLabels();
        System.out.println(test.partitionLabels("caedbdedda"));
        System.out.println(test.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
