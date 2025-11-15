/*
 * PROBLEM STATEMENT:
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * Constraints: 0 ≤ nums.length ≤ 10^5, -10^9 ≤ nums[i] ≤ 10^9, nums is a non-decreasing array, -10^9 ≤ target ≤ 10^9
 */

import java.util.Arrays;

public class _51_FindFirstAndLastPosition {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Find first occurrence
        result[0] = findFirst(nums, target);
        if (result[0] == -1) {
            return result;
        }
        
        // Find last occurrence
        result[1] = findLast(nums, target);
        
        return result;
    }
    
    private static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private static int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        System.out.println("Range of 8 in [5,7,7,8,8,10]: " + Arrays.toString(searchRange(nums1, 8)));
        System.out.println("Range of 6 in [5,7,7,8,8,10]: " + Arrays.toString(searchRange(nums1, 6)));
        
        int[] nums2 = {};
        System.out.println("Range of 0 in []: " + Arrays.toString(searchRange(nums2, 0)));
    }
}