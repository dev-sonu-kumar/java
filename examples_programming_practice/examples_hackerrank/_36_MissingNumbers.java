/*
 * PROBLEM STATEMENT:
 * Given two arrays of integers, find which elements are present in the second array but missing from the first array.
 * Return the missing numbers sorted in ascending order.
 * 
 * Example:
 * Input: arr = [7, 2, 5, 3, 5, 3], brr = [7, 2, 5, 4, 6, 3, 5, 3]
 * Output: [4, 6]
 * 
 * Constraints: 1 ≤ n ≤ 2×10^5, 1 ≤ m ≤ 2×10^5, 1 ≤ arr[i], brr[i] ≤ 10^4
 */

import java.util.*;

public class _36_MissingNumbers {
    public static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> countA = new HashMap<>();
        Map<Integer, Integer> countB = new HashMap<>();
        
        // Count frequencies in both arrays
        for (int num : arr) {
            countA.put(num, countA.getOrDefault(num, 0) + 1);
        }
        
        for (int num : brr) {
            countB.put(num, countB.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> missing = new ArrayList<>();
        
        // Find numbers that are missing or have different frequencies
        for (int num : countB.keySet()) {
            int countInB = countB.get(num);
            int countInA = countA.getOrDefault(num, 0);
            
            if (countInB > countInA) {
                missing.add(num);
            }
        }
        
        Collections.sort(missing);
        return missing.stream().mapToInt(i -> i).toArray();
    }
    
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 3, 5, 3};
        int[] brr = {7, 2, 5, 4, 6, 3, 5, 3};
        
        int[] result = missingNumbers(arr, brr);
        System.out.println("Missing numbers: " + Arrays.toString(result));
    }
}