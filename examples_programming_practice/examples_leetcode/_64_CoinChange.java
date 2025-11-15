/*
 * PROBLEM STATEMENT:
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * Example 1:
 * Input: coins = [1,3,4], amount = 6
 * Output: 2
 * Explanation: 6 = 3 + 3
 * 
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 * 
 * Constraints: 1 ≤ coins.length ≤ 12, 1 ≤ coins[i] ≤ 2^31 - 1, 0 ≤ amount ≤ 10^4
 */

import java.util.Arrays;

public class _64_CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize with impossible value
        dp[0] = 0; // Base case: 0 coins needed for amount 0
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    // Alternative BFS approach
    public static int coinChangeBFS(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        boolean[] visited = new boolean[amount + 1];
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                for (int coin : coins) {
                    int next = current + coin;
                    
                    if (next == amount) {
                        return level;
                    }
                    
                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] coins1 = {1, 3, 4};
        System.out.println("Min coins for amount 6 with [1,3,4]: " + coinChange(coins1, 6));
        
        int[] coins2 = {2};
        System.out.println("Min coins for amount 3 with [2]: " + coinChange(coins2, 3));
        
        int[] coins3 = {1};
        System.out.println("Min coins for amount 0 with [1]: " + coinChange(coins3, 0));
    }
}