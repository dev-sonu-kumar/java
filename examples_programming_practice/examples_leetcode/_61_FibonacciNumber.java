/*
 * PROBLEM STATEMENT:
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1.
 * That is, F(0) = 0, F(1) = 1, F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 * 
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 
 * Example 2:
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 
 * Example 3:
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * 
 * Constraints: 0 ≤ n ≤ 30
 */

public class _61_FibonacciNumber {
    // Iterative approach - O(n) time, O(1) space
    public static int fib(int n) {
        if (n <= 1) return n;
        
        int prev2 = 0;
        int prev1 = 1;
        
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    // Recursive approach with memoization - O(n) time, O(n) space
    public static int fibMemo(int n) {
        int[] memo = new int[n + 1];
        return fibHelper(n, memo);
    }
    
    private static int fibHelper(int n, int[] memo) {
        if (n <= 1) return n;
        
        if (memo[n] != 0) return memo[n];
        
        memo[n] = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
        return memo[n];
    }
    
    public static void main(String[] args) {
        System.out.println("F(2) = " + fib(2));
        System.out.println("F(3) = " + fib(3));
        System.out.println("F(4) = " + fib(4));
        System.out.println("F(10) = " + fib(10));
        
        System.out.println("F(10) with memoization = " + fibMemo(10));
    }
}