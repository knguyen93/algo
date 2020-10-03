package string;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * E.g:
 * 
 * Input: "babad" 
 * Output: "bab" Note: "aba" is also a valid answer.
 * 
 * Input: "cbbd"
 * Output: "bb"
 */
public class M_LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return s;

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // expand in 2 case: with & without middle item
            int max = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1; // the number of expanded items
    }

    public static void main(String[] args) {
        System.out.println("accc".substring(0, 1));
        System.out.println(longestPalindrome("acccc"));
    }
}
