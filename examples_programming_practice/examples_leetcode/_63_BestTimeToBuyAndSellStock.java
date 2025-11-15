/*
 * PROBLEM STATEMENT:
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * 
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * 
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * Constraints: 1 ≤ prices.length ≤ 10^5, 0 ≤ prices[i] ≤ 10^4
 */

public class _63_BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        
        return maxProfit;
    }
    
    // Alternative approach with clearer logic
    public static int maxProfitAlternative(int[] prices) {
        if (prices.length <= 1) return 0;
        
        int buyPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            }
        }
        
        return maxProfit;
    }
    
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit from [7,1,5,3,6,4]: " + maxProfit(prices1));
        
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max profit from [7,6,4,3,1]: " + maxProfit(prices2));
        
        int[] prices3 = {1, 2};
        System.out.println("Max profit from [1,2]: " + maxProfit(prices3));
    }
}