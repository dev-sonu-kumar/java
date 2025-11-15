/*
 * PROBLEM STATEMENT:
 * There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock,
 * determine how many pairs of socks with matching colors there are.
 * 
 * Example:
 * Input: ar = [1, 2, 1, 2, 1, 3, 2]
 * Output: 2
 * Explanation: There are 2 pairs: one pair of color 1 and one pair of color 2.
 * 
 * Constraints: 1 ≤ n ≤ 100, 1 ≤ ar[i] ≤ 100
 */

import java.util.HashMap;
import java.util.Map;

public class _20_SalesByMatch {
    public static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> colorCount = new HashMap<>();
        
        // Count frequency of each color
        for (int color : ar) {
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
        }
        
        // Count pairs
        int pairs = 0;
        for (int count : colorCount.values()) {
            pairs += count / 2;
        }
        
        return pairs;
    }
    
    public static void main(String[] args) {
        int[] ar = {1, 2, 1, 2, 1, 3, 2};
        System.out.println("Number of sock pairs: " + sockMerchant(ar.length, ar));
    }
}