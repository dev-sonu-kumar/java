/*
 * PROBLEM STATEMENT:
 * Two friends like to pool their money and go to the ice cream parlor. They always choose two distinct flavors and they spend all of their money.
 * Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.
 * 
 * Example:
 * Input: money = 4, cost = [1, 4, 5, 3, 2]
 * Output: [1, 4] (1-indexed)
 * Explanation: The first flavor costs 1 and the fourth flavor costs 3. Together they cost 4.
 * 
 * Constraints: 1 ≤ t ≤ 50, 2 ≤ n ≤ 10^4, 1 ≤ cost[i] ≤ 10^4, 1 ≤ money ≤ 2×10^4
 */

import java.util.*;

public class _35_IceCreamParlor {
    public static int[] icecreamParlor(int m, int[] arr) {
        Map<Integer, Integer> priceToIndex = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int complement = m - arr[i];
            
            if (priceToIndex.containsKey(complement)) {
                return new int[]{priceToIndex.get(complement) + 1, i + 1}; // 1-indexed
            }
            
            priceToIndex.put(arr[i], i);
        }
        
        return new int[]{}; // Should never reach here given constraints
    }
    
    public static void main(String[] args) {
        int[] cost = {1, 4, 5, 3, 2};
        int money = 4;
        int[] result = icecreamParlor(money, cost);
        System.out.println("Ice cream flavors: " + Arrays.toString(result));
        
        int[] cost2 = {2, 2, 4, 3};
        int money2 = 4;
        int[] result2 = icecreamParlor(money2, cost2);
        System.out.println("Ice cream flavors: " + Arrays.toString(result2));
    }
}