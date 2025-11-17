/*
 * PROBLEM STATEMENT:
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * 
 * Constraints: 1 ≤ nums.length ≤ 6, -10 ≤ nums[i] ≤ 10
 */

import java.util.*;

public class _76_Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int num : nums) {
            if (!current.contains(num)) {
                current.add(num);
                backtrack(nums, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        System.out.println("Permutations: " + permute(nums1));
        
        int[] nums2 = {0, 1};
        System.out.println("Permutations: " + permute(nums2));
    }
}