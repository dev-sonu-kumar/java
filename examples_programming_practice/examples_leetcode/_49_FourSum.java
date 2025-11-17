/*
 * PROBLEM STATEMENT:
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 0 ≤ a, b, c, d < n, a, b, c, and d are distinct, nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * Example 2:
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * 
 * Constraints: 1 ≤ nums.length ≤ 200, -10^9 ≤ nums[i] ≤ 10^9, -10^9 ≤ target ≤ 10^9
 */

import java.util.*;

public class _49_FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int left = j + 1, right = nums.length - 1;
                
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        System.out.println("4Sum result: " + fourSum(nums1, 0));
        
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println("4Sum result: " + fourSum(nums2, 8));
    }
}