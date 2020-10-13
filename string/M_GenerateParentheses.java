package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * E.g:
 * 
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * 
 * Input: n = 1
 * Output: ["()"]
 */
public class M_GenerateParentheses {

    /**
     * Idea:
     * 
     * Create recursive function that generates all possible combination of parenthesis with below specifications:
     * - take arguments such as initial String, no. of open & close parenthesis, maximum pairs
     * - if open parenthesis < max then continuing add one more open parenthesis
     * - if close parenthesis < open then continuing add one more close parenthesis
     * - if the String reach the length (2 * pairs) then add String to output
     */
    public static List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        helper(results, "", 0, 0, n);
        return results;
    }

    private static void helper(List<String> results, String initialStr, int open, int close, int max) {
        if (initialStr.length() == max * 2) {
            results.add(initialStr);
            return;
        }

        if (open < max) helper(results, initialStr + "(", open + 1, close, max);
        if (close < open) helper(results, initialStr + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(1));
    }
}
