/*
 * PROBLEM STATEMENT:
 * We define a modified Fibonacci sequence using the following definition:
 * Given terms t1 and t2 where t1, t2 are given, term tn is computed as:
 * tn = tn-1 + (tn-2)^2
 * 
 * Given three integers, t1, t2, and n, compute and print the term tn as described above.
 * 
 * Example:
 * Input: t1 = 0, t2 = 1, n = 5
 * Output: 5
 * Explanation: t3 = 1 + 0^2 = 1, t4 = 1 + 1^2 = 2, t5 = 2 + 1^2 = 3... wait, let me recalculate
 * t3 = t2 + t1^2 = 1 + 0^2 = 1
 * t4 = t3 + t2^2 = 1 + 1^2 = 2  
 * t5 = t4 + t3^2 = 2 + 1^2 = 3
 * 
 * Constraints: 0 ≤ t1, t2 ≤ 2, 3 ≤ n ≤ 20
 */

import java.math.BigInteger;

public class _41_FibonacciModified {
    public static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger prev2 = BigInteger.valueOf(t1);
        BigInteger prev1 = BigInteger.valueOf(t2);
        
        if (n == 1) return prev2;
        if (n == 2) return prev1;
        
        BigInteger current = BigInteger.ZERO;
        
        for (int i = 3; i <= n; i++) {
            current = prev1.add(prev2.multiply(prev2));
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
    
    public static void main(String[] args) {
        System.out.println("Fibonacci Modified (0,1,5): " + fibonacciModified(0, 1, 5));
        System.out.println("Fibonacci Modified (0,1,6): " + fibonacciModified(0, 1, 6));
    }
}