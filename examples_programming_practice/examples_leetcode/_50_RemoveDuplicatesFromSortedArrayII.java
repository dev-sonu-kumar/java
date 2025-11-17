/*
 * PROBLEM STATEMENT:
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice.
 * The relative order of the elements should be kept the same.
 * Return k after placing the final result in the first k slots of nums.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * 
 * Example 2:
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * 
 * Constraints: 1 ≤ nums.length ≤ 3 * 10^4, -10^4 ≤ nums[i] ≤ 10^4, nums is sorted in non-decreasing order
 */

public class _50_RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int writeIndex = 2;
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[writeIndex - 2]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        
        return writeIndex;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = removeDuplicates(nums1);
        System.out.print("Result length: " + k1 + ", Array: ");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();
        
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k2 = removeDuplicates(nums2);
        System.out.print("Result length: " + k2 + ", Array: ");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
    }
}