/*
 * PROBLEM STATEMENT:
 * Given an array of integers, find the sum of its elements.
 * 
 * Input: Array of n integers
 * Output: Sum of all elements
 * 
 * Example:
 * Input: [1, 2, 3, 4, 10, 11]
 * Output: 31
 * 
 * Constraints: 1 ≤ n ≤ 1000, 0 ≤ arr[i] ≤ 1000
 */

public class _1_SimpleArraySum {
    public static int simpleArraySum(int[] ar) {
        int sum = 0;
        for (int num : ar) {
            sum += num;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 10, 11};
        System.out.println("Array Sum: " + simpleArraySum(arr));
    }
}