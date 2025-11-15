/*
 * PROBLEM STATEMENT:
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * Constraints: 1 ≤ nums.length ≤ 10^4, -2^31 ≤ nums[i] ≤ 2^31 - 1
 */

import java.util.Arrays;

public class _87_MoveZeroes {
    // Two pointers approach - O(n) time, O(1) space
    public static void moveZeroes(int[] nums) {
        int writeIndex = 0;
        
        // Move all non-zero elements to the front
        for (int readIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != 0) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        
        // Fill remaining positions with zeros
        while (writeIndex < nums.length) {
            nums[writeIndex] = 0;
            writeIndex++;
        }
    }
    
    // Optimal approach with swapping
    public static void moveZeroesOptimal(int[] nums) {
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("Before: " + Arrays.toString(nums1));
        moveZeroes(nums1);
        System.out.println("After: " + Arrays.toString(nums1));
        
        int[] nums2 = {0};
        System.out.println("Before: " + Arrays.toString(nums2));
        moveZeroes(nums2);
        System.out.println("After: " + Arrays.toString(nums2));
        
        int[] nums3 = {0, 1, 0, 3, 12};
        System.out.println("Before (optimal): " + Arrays.toString(nums3));
        moveZeroesOptimal(nums3);
        System.out.println("After (optimal): " + Arrays.toString(nums3));
    }
}