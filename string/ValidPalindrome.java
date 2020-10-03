package string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * Constraints: s consists only of printable ASCII characters.
 * 
 * E.g:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if ("".equals(s))
            return true;

        String str = s.toLowerCase();
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            char lChar = str.charAt(left);
            char rChar = str.charAt(right);

            // ignore non-alphanumeric
            if (!isAlphanumeric(lChar)) left++;
            else if (!isAlphanumeric(rChar)) right--;
            else if (lChar != rChar) return false;
            
            // update pointers
            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
