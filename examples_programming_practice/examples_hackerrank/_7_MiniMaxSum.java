/*
 * PROBLEM STATEMENT:
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 * 
 * Input: Array of 5 integers
 * Output: Minimum sum and maximum sum of 4 elements
 * 
 * Example:
 * Input: [1, 3, 5, 7, 9]
 * Output: 16 24
 * Explanation: Min sum = 1+3+5+7 = 16, Max sum = 3+5+7+9 = 24
 * 
 * Constraints: 1 ≤ arr[i] ≤ 10^9
 */

import java.util.Arrays;

public class _7_MiniMaxSum {
    public static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        
        long minSum = 0;
        long maxSum = 0;
        
        // Min sum: sum of first 4 elements
        for (int i = 0; i < 4; i++) {
            minSum += arr[i];
        }
        
        // Max sum: sum of last 4 elements
        for (int i = 1; i < 5; i++) {
            maxSum += arr[i];
        }
        
        System.out.println(minSum + " " + maxSum);
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        miniMaxSum(arr);
    }
}