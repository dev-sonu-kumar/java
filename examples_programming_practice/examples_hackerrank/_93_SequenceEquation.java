/*
 * PROBLEM STATEMENT:
 * Given a sequence of n integers, p(1), p(2), ..., p(n) where each element is distinct and satisfies 1 ≤ p(x) ≤ n.
 * For each x where 1 ≤ x ≤ n, that is x increments from 1 to n, find any integer y such that p(p(y)) = x and keep a history of the values of y in a return array.
 * 
 * Example:
 * Input: p = [5, 2, 1, 3, 4]
 * Output: [4, 2, 5, 1, 3]
 * 
 * Constraints: 1 ≤ n ≤ 50, 1 ≤ p[i] ≤ n, Each element in the sequence is distinct.
 */

import java.util.*;

public class _93_SequenceEquation {
    public static int[] permutationEquation(int[] p) {
        int n = p.length;
        int[] position = new int[n + 1]; // 1-indexed
        
        // Store position of each value
        for (int i = 0; i < n; i++) {
            position[p[i]] = i + 1;
        }
        
        int[] result = new int[n];
        
        // For each x, find y such that p(p(y)) = x
        for (int x = 1; x <= n; x++) {
            int y = position[position[x]];
            result[x - 1] = y;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] p = {5, 2, 1, 3, 4};
        int[] result = permutationEquation(p);
        System.out.println("Sequence equation result: " + Arrays.toString(result));
    }
}