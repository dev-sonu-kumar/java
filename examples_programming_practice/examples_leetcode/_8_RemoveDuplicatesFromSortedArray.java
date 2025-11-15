/*
 * PROBLEM STATEMENT:
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * 
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * - Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
 * - The remaining elements of nums are not important as well as the size of nums.
 * - Return k.
 * 
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * 
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * 
 * Constraints: 1 ≤ nums.length ≤ 3 * 10^4, -100 ≤ nums[i] ≤ 100, nums is sorted in non-decreasing order.
 */

import java.util.Arrays;

public class _8_RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int writeIndex = 1;
        
        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[readIndex - 1]) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        
        return writeIndex;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int k1 = removeDuplicates(nums1);
        System.out.println("Unique count: " + k1 + ", Array: " + Arrays.toString(Arrays.copyOf(nums1, k1)));
        
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = removeDuplicates(nums2);
        System.out.println("Unique count: " + k2 + ", Array: " + Arrays.toString(Arrays.copyOf(nums2, k2)));
    }
}