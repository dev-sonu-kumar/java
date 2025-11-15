/*
 * PROBLEM STATEMENT:
 * Given an amount and the denominations of coins available, determine how many ways change can be made for amount.
 * There is a limitless supply of each coin type.
 * 
 * Example:
 * Input: n = 3, c = [8, 3, 1, 2]
 * Output: 3
 * Explanation: There are 3 ways to make change for n = 3: {1,1,1}, {1,2}, {3}.
 * 
 * Constraints: 1 ≤ c[i] ≤ 50, 1 ≤ n ≤ 250, 1 ≤ m ≤ 50
 */

public class _44_CoinChangeProblem {
    public static long getWays(int n, int[] c) {
        long[] dp = new long[n + 1];
        dp[0] = 1; // One way to make amount 0
        
        // For each coin
        for (int coin : c) {
            // Update dp array for all amounts from coin to n
            for (int amount = coin; amount <= n; amount++) {
                dp[amount] += dp[amount - coin];
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        int[] coins = {8, 3, 1, 2};
        System.out.println("Ways to make change for 3: " + getWays(3, coins));
        
        int[] coins2 = {2, 3, 5};
        System.out.println("Ways to make change for 9: " + getWays(9, coins2));
    }
}