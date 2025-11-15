/*
 * PROBLEM STATEMENT:
 * We define subsequence as any subset of an array. We define a subarray as a contiguous subsequence in an array.
 * Given an array, find the maximum possible sum among:
 * 1. all nonempty subarrays.
 * 2. all nonempty subsequences.
 * 
 * Print the respective maximum values as space-separated integers on one line.
 * 
 * Example:
 * Input: arr = [-1, 2, 3, -4, 5, 10]
 * Output: 16 17
 * Explanation: Maximum subarray sum = 16 ([2,3,-4,5,10]), Maximum subsequence sum = 17 ([2,3,5,10])
 * 
 * Constraints: 1 ≤ n ≤ 10^5, -10^4 ≤ arr[i] ≤ 10^4
 */

public class _48_MaximumSubarray {
    public static int[] maxSubarray(int[] arr) {
        // Maximum subarray sum (Kadane's algorithm)
        int maxSubarraySum = arr[0];
        int currentSum = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSubarraySum = Math.max(maxSubarraySum, currentSum);
        }
        
        // Maximum subsequence sum (sum of all positive numbers)
        int maxSubsequenceSum = 0;
        int maxElement = Integer.MIN_VALUE;
        boolean hasPositive = false;
        
        for (int num : arr) {
            maxElement = Math.max(maxElement, num);
            if (num > 0) {
                maxSubsequenceSum += num;
                hasPositive = true;
            }
        }
        
        // If all numbers are negative, take the maximum element
        if (!hasPositive) {
            maxSubsequenceSum = maxElement;
        }
        
        return new int[]{maxSubarraySum, maxSubsequenceSum};
    }
    
    public static void main(String[] args) {
        int[] arr1 = {-1, 2, 3, -4, 5, 10};
        int[] result1 = maxSubarray(arr1);
        System.out.println("Max subarray and subsequence for [-1,2,3,-4,5,10]: " + result1[0] + " " + result1[1]);
        
        int[] arr2 = {1, 2, 3, 4};
        int[] result2 = maxSubarray(arr2);
        System.out.println("Max subarray and subsequence for [1,2,3,4]: " + result2[0] + " " + result2[1]);
    }
}