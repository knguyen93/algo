package string;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 * 
 * e.g:
 * 
 * Input: s = "()"
 * Output: true
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * Input: s = "{[]}"
 * Output: true
 */
public class E_ValidParentheses {
    /**
     * Use Stack to peek and compare the latest open bracket with encounter close bracket
     * 
     * Runtime: 1 ms, faster than 98.95% of Java online submissions for Valid Parentheses. 
     * Memory Usage: 37.3 MB, less than 86.05% of Java online submissions for Valid Parentheses.
     */
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) return false;
                
                Character ch = stack.peek();
                switch (c) {
                    case '}':
                        if (ch != '{') return false;
                        stack.pop();
                        break;
                    case ']':
                        if (ch != '[') return false;
                        stack.pop();
                        break;
                    case ')':
                        if (ch != '(') return false;
                        stack.pop();
                        break;
                    default:
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
