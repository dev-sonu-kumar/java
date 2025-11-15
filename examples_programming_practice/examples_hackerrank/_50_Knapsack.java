/*
 * PROBLEM STATEMENT:
 * A thief robbing a store can carry a maximal weight of W into his knapsack.
 * There are N items, and the ith item weighs wi and the value is vi.
 * Considering the constraints of maximum weight that can be carried, what is the maximum value (sum of vi) that can be carried?
 * 
 * Note: The thief cannot break an item; either pick the complete item or don't pick it (0-1 property).
 * This is the unbounded knapsack problem where you can use unlimited quantities of each item.
 * 
 * Example:
 * Input: W = 12, weights = [1, 6, 9], values = [24, 5, 12]
 * Output: 288
 * Explanation: Take 12 items of weight 1 each for value 12*24 = 288.
 * 
 * Constraints: 1 ≤ N ≤ 2000, 1 ≤ W ≤ 2000, 1 ≤ wi ≤ W, 1 ≤ vi ≤ 10^8
 */

public class _50_Knapsack {
    public static int unboundedKnapsack(int W, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        
        for (int capacity = 1; capacity <= W; capacity++) {
            for (int i = 0; i < weights.length; i++) {
                if (weights[i] <= capacity) {
                    dp[capacity] = Math.max(dp[capacity], 
                                          dp[capacity - weights[i]] + values[i]);
                }
            }
        }
        
        return dp[W];
    }
    
    public static void main(String[] args) {
        int[] weights = {1, 6, 9};
        int[] values = {24, 5, 12};
        int W = 12;
        
        System.out.println("Max value for W=12: " + unboundedKnapsack(W, weights, values));
        
        int[] weights2 = {10, 20, 30};
        int[] values2 = {60, 100, 120};
        int W2 = 50;
        
        System.out.println("Max value for W=50: " + unboundedKnapsack(W2, weights2, values2));
    }
}