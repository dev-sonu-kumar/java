/*
 * PROBLEM STATEMENT:
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * 
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * 
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 * 
 * Example 2:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Right -> Down
 * 3. Down -> Down -> Right
 * 
 * Constraints: 1 ≤ m, n ≤ 100
 */

public class _71_UniquePaths {
    // Dynamic Programming approach - O(m*n) time, O(m*n) space
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Initialize first row and column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
    
    // Space optimized approach - O(m*n) time, O(n) space
    public static int uniquePathsOptimized(int m, int n) {
        int[] dp = new int[n];
        
        // Initialize first row
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }
        
        // Fill row by row
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        
        return dp[n-1];
    }
    
    // Mathematical approach using combinations - O(min(m,n)) time, O(1) space
    public static int uniquePathsMath(int m, int n) {
        // Total moves = (m-1) + (n-1) = m+n-2
        // Choose (m-1) down moves from total moves = C(m+n-2, m-1)
        long result = 1;
        int moves = m + n - 2;
        int choose = Math.min(m - 1, n - 1);
        
        for (int i = 0; i < choose; i++) {
            result = result * (moves - i) / (i + 1);
        }
        
        return (int) result;
    }
    
    public static void main(String[] args) {
        System.out.println("Unique paths for 3x7 grid: " + uniquePaths(3, 7));
        System.out.println("Unique paths for 3x2 grid: " + uniquePaths(3, 2));
        System.out.println("Unique paths (optimized) for 3x7 grid: " + uniquePathsOptimized(3, 7));
        System.out.println("Unique paths (math) for 3x7 grid: " + uniquePathsMath(3, 7));
    }
}