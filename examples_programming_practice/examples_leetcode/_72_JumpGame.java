/*
 * PROBLEM STATEMENT:
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * 
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * 
 * Constraints: 1 ≤ nums.length ≤ 10^4, 0 ≤ nums[i] ≤ 10^5
 */

public class _72_JumpGame {
    // Greedy approach - O(n) time, O(1) space
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // Can't reach this position
            }
            
            maxReach = Math.max(maxReach, i + nums[i]);
            
            if (maxReach >= nums.length - 1) {
                return true; // Can reach the last index
            }
        }
        
        return true;
    }
    
    // Alternative approach working backwards
    public static boolean canJumpBackward(int[] nums) {
        int lastGoodIndex = nums.length - 1;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndex) {
                lastGoodIndex = i;
            }
        }
        
        return lastGoodIndex == 0;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Can jump [2,3,1,1,4]: " + canJump(nums1));
        
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Can jump [3,2,1,0,4]: " + canJump(nums2));
        
        int[] nums3 = {0};
        System.out.println("Can jump [0]: " + canJump(nums3));
        
        System.out.println("Can jump (backward) [2,3,1,1,4]: " + canJumpBackward(nums1));
    }
}