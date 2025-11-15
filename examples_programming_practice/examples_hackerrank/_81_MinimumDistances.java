/*
 * PROBLEM STATEMENT:
 * The distance between two array values is the number of indices between them.
 * Given an array a, find the minimum distance between any pair of equal elements in the array.
 * If no such pair exists, return -1.
 * 
 * Example:
 * Input: a = [7, 1, 3, 4, 1, 7]
 * Output: 3
 * Explanation: Here we have two pairs: (7,7) and (1,1). The distances are |5-0|=5 and |4-1|=3. Return 3.
 * 
 * Constraints: 1 ≤ n ≤ 10^3, 1 ≤ a[i] ≤ 10^5
 */

import java.util.*;

public class _81_MinimumDistances {
    public static int minimumDistances(int[] a) {
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        
        for (int i = 0; i < a.length; i++) {
            if (lastIndex.containsKey(a[i])) {
                int distance = i - lastIndex.get(a[i]);
                minDistance = Math.min(minDistance, distance);
            }
            lastIndex.put(a[i], i);
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
    
    public static void main(String[] args) {
        int[] a = {7, 1, 3, 4, 1, 7};
        System.out.println("Minimum distance: " + minimumDistances(a));
        
        int[] b = {1, 2, 3, 4, 10};
        System.out.println("Minimum distance: " + minimumDistances(b));
    }
}