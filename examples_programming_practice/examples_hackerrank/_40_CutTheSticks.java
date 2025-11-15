/*
 * PROBLEM STATEMENT:
 * You are given a number of sticks of varying lengths. You will iteratively cut the sticks into smaller sticks, discarding the shortest pieces until there are none left.
 * At each iteration, you must determine the length of the shortest stick remaining, then cut that length from each of the longer sticks.
 * When the remaining sticks are the same length, they cannot be shortened so discard them.
 * 
 * When you start each iteration, your sticks are sorted from longest to shortest. Print the number of sticks that are cut, in each iteration.
 * 
 * Example:
 * Input: arr = [5, 4, 4, 2, 2, 8]
 * Output: [6, 4, 2, 1]
 * 
 * Constraints: 1 ≤ n ≤ 1000, 1 ≤ arr[i] ≤ 1000
 */

import java.util.*;

public class _40_CutTheSticks {
    public static int[] cutTheSticks(int[] arr) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(arr);
        
        int i = 0;
        while (i < arr.length) {
            result.add(arr.length - i);
            
            int currentLength = arr[i];
            // Skip all sticks of the same length
            while (i < arr.length && arr[i] == currentLength) {
                i++;
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 4, 4, 2, 2, 8};
        int[] result = cutTheSticks(arr);
        System.out.println("Sticks cut in each iteration: " + Arrays.toString(result));
        
        int[] arr2 = {1, 2, 3, 4, 3, 3, 2, 1};
        int[] result2 = cutTheSticks(arr2);
        System.out.println("Sticks cut in each iteration: " + Arrays.toString(result2));
    }
}