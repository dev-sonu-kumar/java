/*
 * PROBLEM STATEMENT:
 * In this challenge, you are required to calculate and print the sum of the elements in an array, keeping in mind that some of those integers may be quite large.
 * 
 * Input: Array of n long integers
 * Output: Sum of all elements as long
 * 
 * Example:
 * Input: [1000000001, 1000000002, 1000000003, 1000000004, 1000000005]
 * Output: 5000000015
 * 
 * Constraints: 1 ≤ n ≤ 10, 0 ≤ arr[i] ≤ 10^10
 */

public class _3_AVeryBigSum {
    public static long aVeryBigSum(long[] ar) {
        long sum = 0;
        for (long num : ar) {
            sum += num;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        long[] arr = {1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L};
        System.out.println("Very Big Sum: " + aVeryBigSum(arr));
    }
}