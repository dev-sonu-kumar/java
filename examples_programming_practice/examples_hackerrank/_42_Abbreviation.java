/*
 * PROBLEM STATEMENT:
 * You can perform the following operations on string a:
 * 1. Capitalize zero or more of a's lowercase letters.
 * 2. Delete all of the remaining lowercase letters in a.
 * 
 * Given two strings, a and b, determine if it's possible to make a equal to b as described.
 * 
 * Example:
 * Input: a = "daBcd", b = "ABC"
 * Output: YES
 * Explanation: Delete 'd', capitalize 'a' to 'A', keep 'B', capitalize 'c' to 'C', delete 'd'.
 * 
 * Constraints: 1 ≤ |a|, |b| ≤ 1000
 */

public class _42_Abbreviation {
    public static String abbreviation(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        // dp[i][j] represents if first i characters of a can form first j characters of b
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        // Fill first row - can we form empty string b from prefix of a?
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] && Character.isLowerCase(a.charAt(i-1));
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char charA = a.charAt(i-1);
                char charB = b.charAt(j-1);
                
                if (Character.isUpperCase(charA)) {
                    // If uppercase, must match exactly
                    dp[i][j] = (charA == charB) && dp[i-1][j-1];
                } else {
                    // If lowercase, we can either delete it or capitalize it
                    dp[i][j] = dp[i-1][j]; // Delete lowercase
                    
                    if (Character.toUpperCase(charA) == charB) {
                        dp[i][j] = dp[i][j] || dp[i-1][j-1]; // Capitalize and match
                    }
                }
            }
        }
        
        return dp[m][n] ? "YES" : "NO";
    }
    
    public static void main(String[] args) {
        System.out.println("Can 'daBcd' become 'ABC': " + abbreviation("daBcd", "ABC"));
        System.out.println("Can 'AfPZN' become 'APZNC': " + abbreviation("AfPZN", "APZNC"));
    }
}