/*
 * PROBLEM STATEMENT:
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target.
 * 
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * 
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * 
 * Constraints: 1 ≤ target ≤ 10^9, 1 ≤ nums.length ≤ 10^5, 1 ≤ nums[i] ≤ 10^4
 */

public class _60_MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println("Min subarray length: " + minSubArrayLen(7, nums1));
        
        int[] nums2 = {1, 4, 4};
        System.out.println("Min subarray length: " + minSubArrayLen(4, nums2));
    }
}