/*
 * PROBLEM STATEMENT:
 * Your algorithms have become so good at predicting the market that you now know what the share price of Wooden Orange Toothpicks Inc. (WOT) will be for the next number of days.
 * 
 * Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own, or not make any transaction at all.
 * What is the maximum profit you can obtain with an optimum trading strategy?
 * 
 * Example:
 * Input: prices = [5, 3, 2, 4, 1]
 * Output: 0
 * Explanation: No profit can be made since prices are generally decreasing.
 * 
 * Constraints: 1 ≤ n ≤ 50000, 1 ≤ prices[i] ≤ 100000
 */

public class _49_StockMaximize {
    public static long stockmax(int[] prices) {
        int n = prices.length;
        long profit = 0;
        int maxPrice = 0;
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            } else {
                // Buy at current price and sell at maxPrice
                profit += maxPrice - prices[i];
            }
        }
        
        return profit;
    }
    
    public static void main(String[] args) {
        int[] prices1 = {5, 3, 2, 4, 1};
        System.out.println("Max profit for [5,3,2,4,1]: " + stockmax(prices1));
        
        int[] prices2 = {1, 2, 100};
        System.out.println("Max profit for [1,2,100]: " + stockmax(prices2));
        
        int[] prices3 = {1, 3, 1, 2};
        System.out.println("Max profit for [1,3,1,2]: " + stockmax(prices3));
    }
}