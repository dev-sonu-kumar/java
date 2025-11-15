/*
 * PROBLEM STATEMENT:
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * - '.' Matches any single character.
 * - '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Example 1:
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * Example 2:
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * Example 3:
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * Constraints: 1 ≤ s.length ≤ 20, 1 ≤ p.length ≤ 20, s contains only lowercase English letters, p contains only lowercase English letters, '.', and '*'.
 */

public class _94_RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] represents if s[0...i-1] matches p[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // Empty string matches empty pattern
        
        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == '*') {
                    // Two cases: use * as zero occurrences or one/more occurrences
                    dp[i][j] = dp[i][j - 2]; // Zero occurrences
                    
                    if (matches(sc, p.charAt(j - 2))) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // One or more occurrences
                    }
                } else {
                    if (matches(sc, pc)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
    
    private static boolean matches(char s, char p) {
        return p == '.' || s == p;
    }
    
    public static void main(String[] args) {
        System.out.println("'aa' matches 'a': " + isMatch("aa", "a"));
        System.out.println("'aa' matches 'a*': " + isMatch("aa", "a*"));
        System.out.println("'ab' matches '.*': " + isMatch("ab", ".*"));
        System.out.println("'mississippi' matches 'mis*is*p*.': " + isMatch("mississippi", "mis*is*p*."));
    }
}