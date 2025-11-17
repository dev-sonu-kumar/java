/*
 * PROBLEM STATEMENT:
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * Example 1:
 * Input: s = "aa", p = "a"
 * Output: false
 * 
 * Example 2:
 * Input: s = "aa", p = "a*"
 * Output: true
 * 
 * Constraints: 1 ≤ s.length ≤ 20, 1 ≤ p.length ≤ 20
 */

public class _99_RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || 
                              (matches(s, p, i, j - 1) && dp[i - 1][j]);
                } else {
                    dp[i][j] = matches(s, p, i, j) && dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
    
    private static boolean matches(String s, String p, int i, int j) {
        return p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1);
    }
    
    public static void main(String[] args) {
        System.out.println("Match: " + isMatch("aa", "a"));
        System.out.println("Match: " + isMatch("aa", "a*"));
    }
}