/*
 * PROBLEM STATEMENT:
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * 
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * 
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * 
 * Constraints: 1 ≤ n ≤ 10^5, nums.length == n + 1, 1 ≤ nums[i] ≤ n, All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */

public class _88_FindTheDuplicateNumber {
    // Floyd's Cycle Detection Algorithm - O(n) time, O(1) space
    public static int findDuplicate(int[] nums) {
        // Phase 1: Find intersection point in the cycle
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Phase 2: Find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
    
    // Binary search approach - O(n log n) time, O(1) space
    public static int findDuplicateBinarySearch(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            
            // Count numbers <= mid
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate in [1,3,4,2,2]: " + findDuplicate(nums1));
        
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate in [3,1,3,4,2]: " + findDuplicate(nums2));
        
        System.out.println("Duplicate (binary search) in [1,3,4,2,2]: " + findDuplicateBinarySearch(nums1));
    }
}