/*
 * PROBLEM STATEMENT:
 * Your task is to construct an array such that:
 * 1. It contains exactly n elements.
 * 2. Each element is between 1 and k, inclusive.
 * 3. No two adjacent elements are the same.
 * 4. The first element is 1 and the last element is x.
 * 
 * Count the number of ways to construct such an array. Since the answer can be large, print it modulo 10^9 + 7.
 * 
 * Example:
 * Input: n = 4, k = 3, x = 2
 * Output: 2
 * Explanation: [1,2,1,2] and [1,3,1,2] are the valid arrays.
 * 
 * Constraints: 1 ≤ n ≤ 10^5, 1 ≤ k ≤ 10^5, 1 ≤ x ≤ k
 */

public class _47_ConstructTheArray {
    private static final int MOD = 1000000007;
    
    public static long countArray(int n, int k, int x) {
        if (n == 1) {
            return x == 1 ? 1 : 0;
        }
        
        // dp[i][0] = ways to reach position i with value x
        // dp[i][1] = ways to reach position i with value != x
        long same = 1;    // dp[1][0] = 1 (first element is 1, and if x == 1)
        long different = 0; // dp[1][1] = 0 (first element is 1, so if x != 1, we have 0 ways)
        
        if (x != 1) {
            same = 0;
            different = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            long newSame = different;
            long newDifferent = (same * (k - 1) + different * (k - 2)) % MOD;
            
            same = newSame;
            different = newDifferent;
        }
        
        return same;
    }
    
    public static void main(String[] args) {
        System.out.println("Ways to construct array (n=4, k=3, x=2): " + countArray(4, 3, 2));
        System.out.println("Ways to construct array (n=3, k=2, x=1): " + countArray(3, 2, 1));
    }
}