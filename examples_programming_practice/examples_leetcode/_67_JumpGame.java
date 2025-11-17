/*
 * PROBLEM STATEMENT:
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * 
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * 
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * 
 * Constraints: 1 ≤ nums.length ≤ 10^4, 0 ≤ nums[i] ≤ 10^5
 */

public class _67_JumpGame {
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Can jump: " + canJump(nums1));
        
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Can jump: " + canJump(nums2));
    }
}