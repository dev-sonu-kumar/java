/*
 * PROBLEM STATEMENT:
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * 
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * 
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * 
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 * 
 * Constraints: 1 ≤ nums.length ≤ 3 * 10^4, -3 * 10^4 ≤ nums[i] ≤ 3 * 10^4, Each element in the array appears twice except for one element which appears only once.
 */

public class _81_SingleNumber {
    // XOR approach - O(n) time, O(1) space
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR cancels out duplicate numbers
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1};
        System.out.println("Single number in [2,2,1]: " + singleNumber(nums1));
        
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Single number in [4,1,2,1,2]: " + singleNumber(nums2));
        
        int[] nums3 = {1};
        System.out.println("Single number in [1]: " + singleNumber(nums3));
    }
}