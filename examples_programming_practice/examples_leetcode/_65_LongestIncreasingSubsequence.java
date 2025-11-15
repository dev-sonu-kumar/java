/*
 * PROBLEM STATEMENT:
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * 
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,18], therefore the length is 4.
 * 
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * 
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * 
 * Constraints: 1 ≤ nums.length ≤ 2500, -10^4 ≤ nums[i] ≤ 10^4
 */

import java.util.Arrays;

public class _65_LongestIncreasingSubsequence {
    // Dynamic Programming approach - O(n^2) time, O(n) space
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxLength = 0;
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }
        
        return maxLength;
    }
    
    // Binary Search approach - O(n log n) time, O(n) space
    public static int lengthOfLISOptimal(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        
        for (int num : nums) {
            int left = 0, right = size;
            
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            tails[left] = num;
            if (left == size) {
                size++;
            }
        }
        
        return size;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS length for [10,9,2,5,3,7,101,18]: " + lengthOfLIS(nums1));
        
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("LIS length for [0,1,0,3,2,3]: " + lengthOfLIS(nums2));
        
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("LIS length for [7,7,7,7,7,7,7]: " + lengthOfLIS(nums3));
        
        System.out.println("LIS length (optimal) for [10,9,2,5,3,7,101,18]: " + lengthOfLISOptimal(nums1));
    }
}