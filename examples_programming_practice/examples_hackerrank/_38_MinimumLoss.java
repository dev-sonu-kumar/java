/*
 * PROBLEM STATEMENT:
 * Lauren has a chart of distinct projected prices for a house over the next several years.
 * She must buy the house in one year and sell it in another, and she must do so at a loss.
 * Find the minimum amount of money she must lose.
 * 
 * Example:
 * Input: price = [20, 7, 8, 2, 5]
 * Output: 2
 * Explanation: She can buy at 7 and sell at 5 for a loss of 2.
 * 
 * Constraints: 2 ≤ n ≤ 2×10^5, 1 ≤ price[i] ≤ 10^16, All prices are distinct.
 */

import java.util.*;

public class _38_MinimumLoss {
    public static int minimumLoss(long[] price) {
        // Create array of price-index pairs
        int n = price.length;
        long[][] priceIndex = new long[n][2];
        
        for (int i = 0; i < n; i++) {
            priceIndex[i][0] = price[i]; // price
            priceIndex[i][1] = i;        // original index
        }
        
        // Sort by price
        Arrays.sort(priceIndex, (a, b) -> Long.compare(a[0], b[0]));
        
        long minLoss = Long.MAX_VALUE;
        
        // Check consecutive elements in sorted array
        for (int i = 1; i < n; i++) {
            long currentPrice = priceIndex[i][0];
            long prevPrice = priceIndex[i-1][0];
            int currentIndex = (int)priceIndex[i][1];
            int prevIndex = (int)priceIndex[i-1][1];
            
            // Can only sell after buying (currentIndex > prevIndex)
            if (currentIndex > prevIndex) {
                long loss = currentPrice - prevPrice;
                minLoss = Math.min(minLoss, loss);
            }
        }
        
        return (int)minLoss;
    }
    
    public static void main(String[] args) {
        long[] price = {20, 7, 8, 2, 5};
        System.out.println("Minimum loss: " + minimumLoss(price));
        
        long[] price2 = {5, 10, 3};
        System.out.println("Minimum loss: " + minimumLoss(price2));
    }
}