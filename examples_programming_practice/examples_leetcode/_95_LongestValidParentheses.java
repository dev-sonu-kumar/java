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
 * Example 3:
 * Input: s = ""
 * Output: 0
 * 
 * Constraints: 0 ≤ s.length ≤ 3 * 10^4, s[i] is '(', or ')'.
 */

import java.util.Stack;

public class _95_LongestValidParentheses {
    // Dynamic Programming approach - O(n) time, O(n) space
    public static int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int maxLength = 0;
        
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // Case: ...()
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (dp[i - 1] > 0) {
                    // Case: ...))
                    int matchIndex = i - dp[i - 1] - 1;
                    if (matchIndex >= 0 && s.charAt(matchIndex) == '(') {
                        dp[i] = dp[i - 1] + 2 + (matchIndex > 0 ? dp[matchIndex - 1] : 0);
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        
        return maxLength;
    }
    
    // Stack approach - O(n) time, O(n) space
    public static int longestValidParenthesesStack(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base for calculating length
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // New base
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        System.out.println("Longest valid parentheses in '(()': " + longestValidParentheses("(()"));
        System.out.println("Longest valid parentheses in ')()())': " + longestValidParentheses(")()())"));
        System.out.println("Longest valid parentheses in '': " + longestValidParentheses(""));
        
        System.out.println("Longest valid parentheses (stack) in ')()())': " + longestValidParenthesesStack(")()())"));
    }
}