/*
 * PROBLEM STATEMENT:
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * 
 * Constraints: 2 ≤ nums.length ≤ 10^5, -30 ≤ nums[i] ≤ 30, The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */

import java.util.Arrays;

public class _89_ProductOfArrayExceptSelf {
    // Two-pass approach - O(n) time, O(1) extra space
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // First pass: calculate left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Second pass: calculate right products and multiply with left products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }
    
    // Alternative approach with separate left and right arrays
    public static int[] productExceptSelfVerbose(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];
        
        // Calculate left products
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        // Calculate right products
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        // Multiply left and right products
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Product except self [1,2,3,4]: " + Arrays.toString(productExceptSelf(nums1)));
        
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Product except self [-1,1,0,-3,3]: " + Arrays.toString(productExceptSelf(nums2)));
        
        System.out.println("Product except self (verbose) [1,2,3,4]: " + Arrays.toString(productExceptSelfVerbose(nums1)));
    }
}