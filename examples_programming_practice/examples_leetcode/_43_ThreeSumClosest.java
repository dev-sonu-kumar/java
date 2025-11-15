/*
 * PROBLEM STATEMENT:
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * 
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 * 
 * Constraints: 3 ≤ nums.length ≤ 500, -1000 ≤ nums[i] ≤ 1000, -10^4 ≤ target ≤ 10^4
 */

import java.util.Arrays;

public class _43_ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum; // Exact match found
                }
            }
        }
        
        return closestSum;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 1, -4};
        System.out.println("3Sum closest to 1 for [-1,2,1,-4]: " + threeSumClosest(nums1, 1));
        
        int[] nums2 = {0, 0, 0};
        System.out.println("3Sum closest to 1 for [0,0,0]: " + threeSumClosest(nums2, 1));
    }
}