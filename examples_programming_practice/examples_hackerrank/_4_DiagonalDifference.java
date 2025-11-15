/*
 * PROBLEM STATEMENT:
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 * 
 * Input: n x n square matrix
 * Output: Absolute difference between diagonal sums
 * 
 * Example:
 * Matrix:
 * 1 2 3
 * 4 5 6
 * 9 8 9
 * 
 * Primary diagonal: 1 + 5 + 9 = 15
 * Secondary diagonal: 3 + 5 + 9 = 17
 * Difference: |15 - 17| = 2
 * 
 * Constraints: -100 ≤ arr[i][j] ≤ 100
 */

public class _4_DiagonalDifference {
    public static int diagonalDifference(int[][] arr) {
        int n = arr.length;
        int primarySum = 0;
        int secondarySum = 0;
        
        for (int i = 0; i < n; i++) {
            primarySum += arr[i][i];                    // Primary diagonal
            secondarySum += arr[i][n - 1 - i];          // Secondary diagonal
        }
        
        return Math.abs(primarySum - secondarySum);
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {9, 8, 9}
        };
        System.out.println("Diagonal Difference: " + diagonalDifference(matrix));
    }
}