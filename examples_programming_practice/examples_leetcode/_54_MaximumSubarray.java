/*
 * PROBLEM STATEMENT:
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 * 
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * 
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * 
 * Constraints: 1 ≤ nums.length ≤ 10^5, -10^4 ≤ nums[i] ≤ 10^4
 */

public class _54_MaximumSubarray {
    // Kadane's Algorithm - O(n) time, O(1) space
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    // Alternative implementation
    public static int maxSubArrayAlternative(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max subarray sum for [-2,1,-3,4,-1,2,1,-5,4]: " + maxSubArray(nums1));
        
        int[] nums2 = {1};
        System.out.println("Max subarray sum for [1]: " + maxSubArray(nums2));
        
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Max subarray sum for [5,4,-1,7,8]: " + maxSubArray(nums3));
        
        int[] nums4 = {-1};
        System.out.println("Max subarray sum for [-1]: " + maxSubArray(nums4));
    }
}