/*
 * PROBLEM STATEMENT:
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * 
 * Example 2:
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * 
 * Constraints: 0 ≤ s.length ≤ 3 * 10^4
 */

import java.util.*;

public class _100_LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        System.out.println("Longest valid parentheses: " + longestValidParentheses("(()"));
        System.out.println("Longest valid parentheses: " + longestValidParentheses(")()())"));
    }
}