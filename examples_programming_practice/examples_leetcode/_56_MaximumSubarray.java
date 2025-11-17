/*
 * PROBLEM STATEMENT:
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * 
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * 
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * 
 * Constraints: 1 ≤ nums.length ≤ 10^5, -10^4 ≤ nums[i] ≤ 10^4
 */

public class _56_MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max subarray sum: " + maxSubArray(nums1));
        
        int[] nums2 = {1};
        System.out.println("Max subarray sum: " + maxSubArray(nums2));
    }
}