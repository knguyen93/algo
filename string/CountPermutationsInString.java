package string;

import java.util.Arrays;

public class CountPermutationsInString {
    public static int countPermutations(String pattern, String str) {
        int count = 0;

        int[] dp = new int[26];
        for (char c : pattern.toCharArray()) {
            dp[c-'a'] = dp[c-'a'] - 1;
        }

        //System.out.println(Arrays.toString(dp));
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(countPermutations("afe", "abcadefeacba"));
    }
}