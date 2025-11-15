/*
 * PROBLEM STATEMENT:
 * Given an array of integers and a positive integer k, determine the number of (i,j) pairs where i < j and ar[i] + ar[j] is divisible by k.
 * 
 * Example:
 * Input: ar = [1, 3, 2, 6, 1, 2], k = 3
 * Output: 5
 * Explanation: Here are the valid pairs: (0,2), (0,5), (1,5), (2,4), (4,5)
 * 
 * Constraints: 2 ≤ n ≤ 100, 1 ≤ k ≤ 100, 1 ≤ ar[i] ≤ 100
 */

public class _16_DivisibleSumPairs {
    public static int divisibleSumPairs(int n, int k, int[] ar) {
        int count = 0;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar[i] + ar[j]) % k == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[] ar = {1, 3, 2, 6, 1, 2};
        int k = 3;
        System.out.println("Divisible sum pairs: " + divisibleSumPairs(ar.length, k, ar));
    }
}