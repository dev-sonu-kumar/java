/*
 * PROBLEM STATEMENT:
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * 
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * 
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * 
 * Constraints: nums1.length == m, nums2.length == n, 0 ≤ m ≤ 1000, 0 ≤ n ≤ 1000, 1 ≤ m + n ≤ 2000
 */

public class _98_MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        
        while (left <= right) {
            int partitionX = (left + right) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = partitionX - 1;
            } else {
                left = partitionX + 1;
            }
        }
        
        return 0.0;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median: " + findMedianSortedArrays(nums1, nums2));
        
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Median: " + findMedianSortedArrays(nums3, nums4));
    }
}