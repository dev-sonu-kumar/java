/*
 * PROBLEM STATEMENT:
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * 
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 * 
 * Example 2:
 * Input: m = 3, n = 2
 * Output: 3
 * 
 * Constraints: 1 ≤ m, n ≤ 100
 */

public class _66_UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }
    
    public static void main(String[] args) {
        System.out.println("Unique paths (3x7): " + uniquePaths(3, 7));
        System.out.println("Unique paths (3x2): " + uniquePaths(3, 2));
    }
}