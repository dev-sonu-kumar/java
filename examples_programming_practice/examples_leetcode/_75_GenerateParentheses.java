/*
 * PROBLEM STATEMENT:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * 
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * 
 * Constraints: 1 ≤ n ≤ 8
 */

import java.util.*;

public class _75_GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    private static void backtrack(List<String> result, StringBuilder current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }
        
        // Add opening parenthesis if we haven't used all n
        if (open < n) {
            current.append('(');
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }
        
        // Add closing parenthesis if it doesn't exceed opening ones
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
    
    // Alternative approach using dynamic programming
    public static List<String> generateParenthesisDP(int n) {
        List<List<String>> dp = new ArrayList<>();
        
        // Base case
        dp.add(Arrays.asList(""));
        
        for (int i = 1; i <= n; i++) {
            List<String> current = new ArrayList<>();
            
            for (int j = 0; j < i; j++) {
                List<String> left = dp.get(j);
                List<String> right = dp.get(i - 1 - j);
                
                for (String l : left) {
                    for (String r : right) {
                        current.add("(" + l + ")" + r);
                    }
                }
            }
            
            dp.add(current);
        }
        
        return dp.get(n);
    }
    
    public static void main(String[] args) {
        System.out.println("Generate parentheses for n=3: " + generateParenthesis(3));
        System.out.println("Generate parentheses for n=1: " + generateParenthesis(1));
        System.out.println("Generate parentheses (DP) for n=3: " + generateParenthesisDP(3));
    }
}