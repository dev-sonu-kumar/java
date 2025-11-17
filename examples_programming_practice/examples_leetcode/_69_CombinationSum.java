/*
 * PROBLEM STATEMENT:
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * 
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * 
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * 
 * Constraints: 1 ≤ candidates.length ≤ 30, 2 ≤ candidates[i] ≤ 40, 1 ≤ target ≤ 40
 */

import java.util.*;

public class _69_CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        System.out.println("Combination sum: " + combinationSum(candidates1, 7));
        
        int[] candidates2 = {2, 3, 5};
        System.out.println("Combination sum: " + combinationSum(candidates2, 8));
    }
}