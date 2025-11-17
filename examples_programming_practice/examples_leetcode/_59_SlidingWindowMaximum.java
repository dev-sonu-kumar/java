/*
 * PROBLEM STATEMENT:
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * Return the max sliding window.
 * 
 * Example 1:
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * 
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * Constraints: 1 ≤ nums.length ≤ 10^5, -10^4 ≤ nums[i] ≤ 10^4, 1 ≤ k ≤ nums.length
 */

import java.util.*;

public class _59_SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println("Sliding window max: " + Arrays.toString(maxSlidingWindow(nums1, 3)));
        
        int[] nums2 = {1};
        System.out.println("Sliding window max: " + Arrays.toString(maxSlidingWindow(nums2, 1)));
    }
}