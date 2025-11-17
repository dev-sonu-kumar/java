/*
 * PROBLEM STATEMENT:
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * 
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * 
 * Constraints: 3 ≤ nums.length ≤ 500, -1000 ≤ nums[i] ≤ 1000, -10^4 ≤ target ≤ 10^4
 */

import java.util.*;

public class _48_ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            
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
                    return currentSum; // Exact match
                }
            }
        }
        
        return closestSum;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 1, -4};
        System.out.println("Closest sum to 1: " + threeSumClosest(nums1, 1));
        
        int[] nums2 = {0, 0, 0};
        System.out.println("Closest sum to 1: " + threeSumClosest(nums2, 1));
    }
}