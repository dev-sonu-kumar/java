/*
 * PROBLEM STATEMENT:
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 * 
 * Constraints: 1 ≤ nums.length ≤ 10, -10 ≤ nums[i] ≤ 10
 */

import java.util.*;

public class _77_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        System.out.println("Subsets: " + subsets(nums1));
        
        int[] nums2 = {0};
        System.out.println("Subsets: " + subsets(nums2));
    }
}