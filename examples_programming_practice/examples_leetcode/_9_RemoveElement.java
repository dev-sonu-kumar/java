/*
 * PROBLEM STATEMENT:
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * 
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * - Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 * - The remaining elements of nums are not important as well as the size of nums.
 * - Return k.
 * 
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * 
 * Example 2:
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * 
 * Constraints: 0 ≤ nums.length ≤ 100, 0 ≤ nums[i] ≤ 50, 0 ≤ val ≤ 100
 */

import java.util.Arrays;

public class _9_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int writeIndex = 0;
        
        for (int readIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != val) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        
        return writeIndex;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3};
        int k1 = removeElement(nums1, 3);
        System.out.println("After removing 3: k=" + k1 + ", nums=" + Arrays.toString(Arrays.copyOf(nums1, k1)));
        
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int k2 = removeElement(nums2, 2);
        System.out.println("After removing 2: k=" + k2 + ", nums=" + Arrays.toString(Arrays.copyOf(nums2, k2)));
    }
}