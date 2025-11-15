/*
 * PROBLEM STATEMENT:
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
 * Print the decimal value of each fraction on a new line with 6 places after the decimal.
 * 
 * Input: Array of n integers
 * Output: Three ratios (positive, negative, zero) with 6 decimal places
 * 
 * Example:
 * Input: [-4, 3, -9, 0, 4, 1]
 * Output: 
 * 0.500000
 * 0.333333
 * 0.166667
 * 
 * Constraints: 0 < n ≤ 100, -100 ≤ arr[i] ≤ 100
 */

public class _5_PlusMinus {
    public static void plusMinus(int[] arr) {
        int n = arr.length;
        int positive = 0, negative = 0, zero = 0;
        
        for (int num : arr) {
            if (num > 0) positive++;
            else if (num < 0) negative++;
            else zero++;
        }
        
        System.out.printf("%.6f%n", (double) positive / n);
        System.out.printf("%.6f%n", (double) negative / n);
        System.out.printf("%.6f%n", (double) zero / n);
    }
    
    public static void main(String[] args) {
        int[] arr = {-4, 3, -9, 0, 4, 1};
        plusMinus(arr);
    }
}