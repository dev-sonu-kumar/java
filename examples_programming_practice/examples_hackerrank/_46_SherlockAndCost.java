/*
 * PROBLEM STATEMENT:
 * In this challenge, you will be given an array B and must determine an array A.
 * There is a special rule: For all i, 1 ≤ A[i] ≤ B[i].
 * That is, A[i] can be any number you choose such that 1 ≤ A[i] ≤ B[i].
 * Your task is to select a series of A[i] given B[i] such that the sum of the absolute difference of consecutive pairs is maximized.
 * 
 * Example:
 * Input: B = [1, 2, 3]
 * Output: 2
 * Explanation: A = [1, 1, 3] gives |1-1| + |1-3| = 0 + 2 = 2.
 * 
 * Constraints: 1 ≤ n ≤ 10^5, 1 ≤ B[i] ≤ 100
 */

public class _46_SherlockAndCost {
    public static int cost(int[] B) {
        int n = B.length;
        if (n <= 1) return 0;
        
        // dp[i][0] = max cost ending at position i with A[i] = 1
        // dp[i][1] = max cost ending at position i with A[i] = B[i]
        int low = 0;  // A[i-1] = 1
        int high = 0; // A[i-1] = B[i-1]
        
        for (int i = 1; i < n; i++) {
            int newLow = Math.max(low, high + Math.abs(B[i-1] - 1));
            int newHigh = Math.max(low + Math.abs(B[i] - 1), high + Math.abs(B[i] - B[i-1]));
            
            low = newLow;
            high = newHigh;
        }
        
        return Math.max(low, high);
    }
    
    public static void main(String[] args) {
        int[] B1 = {1, 2, 3};
        System.out.println("Max cost for [1,2,3]: " + cost(B1));
        
        int[] B2 = {10, 1, 10, 1, 10};
        System.out.println("Max cost for [10,1,10,1,10]: " + cost(B2));
    }
}