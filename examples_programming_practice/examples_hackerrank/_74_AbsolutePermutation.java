/*
 * PROBLEM STATEMENT:
 * We define P(n,k) to be an array of the first n positive integers where for each element v[i] in the array, |v[i] - i| = k.
 * Given n and k, print the lexicographically smallest absolute permutation. If no absolute permutation exists, print -1.
 * 
 * Example:
 * Input: n = 4, k = 2
 * Output: [3, 4, 1, 2]
 * Explanation: |3-1|=2, |4-2|=2, |1-3|=2, |2-4|=2
 * 
 * Constraints: 1 ≤ T ≤ 10, 1 ≤ n ≤ 10^5, 0 ≤ k ≤ n
 */

import java.util.Arrays;

public class _74_AbsolutePermutation {
    public static int[] absolutePermutation(int n, int k) {
        // Special case: k = 0
        if (k == 0) {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = i + 1;
            }
            return result;
        }
        
        // If n is not divisible by 2*k, no solution exists
        if (n % (2 * k) != 0) {
            return new int[]{-1};
        }
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int pos = i + 1; // 1-indexed position
            
            // Determine which block of 2*k we're in
            int blockIndex = i / (2 * k);
            int posInBlock = i % (2 * k);
            
            if (posInBlock < k) {
                // First half of block: add k
                result[i] = pos + k;
            } else {
                // Second half of block: subtract k
                result[i] = pos - k;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] result1 = absolutePermutation(4, 2);
        System.out.println("Absolute permutation for n=4, k=2: " + Arrays.toString(result1));
        
        int[] result2 = absolutePermutation(3, 0);
        System.out.println("Absolute permutation for n=3, k=0: " + Arrays.toString(result2));
        
        int[] result3 = absolutePermutation(3, 2);
        System.out.println("Absolute permutation for n=3, k=2: " + Arrays.toString(result3));
    }
}