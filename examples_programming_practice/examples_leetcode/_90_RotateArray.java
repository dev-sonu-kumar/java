/*
 * PROBLEM STATEMENT:
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation: rotate 1 steps to the right: [7,1,2,3,4,5,6], rotate 2 steps to the right: [6,7,1,2,3,4,5], rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation: rotate 1 steps to the right: [99,-1,-100,3], rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * Constraints: 1 ≤ nums.length ≤ 10^5, -2^31 ≤ nums[i] ≤ 2^31 - 1, 0 ≤ k ≤ 10^5
 */

import java.util.Arrays;

public class _90_RotateArray {
    // Reverse approach - O(n) time, O(1) space
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle k > n
        
        // Reverse entire array
        reverse(nums, 0, n - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining elements
        reverse(nums, k, n - 1);
    }
    
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    // Cyclic replacement approach - O(n) time, O(1) space
    public static void rotateCyclic(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;
        
        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Before rotation: " + Arrays.toString(nums1));
        rotate(nums1, 3);
        System.out.println("After rotation by 3: " + Arrays.toString(nums1));
        
        int[] nums2 = {-1, -100, 3, 99};
        System.out.println("Before rotation: " + Arrays.toString(nums2));
        rotate(nums2, 2);
        System.out.println("After rotation by 2: " + Arrays.toString(nums2));
        
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Before cyclic rotation: " + Arrays.toString(nums3));
        rotateCyclic(nums3, 3);
        System.out.println("After cyclic rotation by 3: " + Arrays.toString(nums3));
    }
}