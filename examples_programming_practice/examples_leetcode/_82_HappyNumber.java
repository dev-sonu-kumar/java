/*
 * PROBLEM STATEMENT:
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process:
 * - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * - Those numbers for which this process ends in 1 are happy.
 * 
 * Return true if n is a happy number, and false if not.
 * 
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation: 1² + 9² = 82, 8² + 2² = 68, 6² + 8² = 100, 1² + 0² + 0² = 1
 * 
 * Example 2:
 * Input: n = 2
 * Output: false
 * 
 * Constraints: 1 ≤ n ≤ 2^31 - 1
 */

import java.util.HashSet;
import java.util.Set;

public class _82_HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }
        
        return n == 1;
    }
    
    // Floyd's cycle detection approach - O(1) space
    public static boolean isHappyOptimal(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = getSumOfSquares(slow);
            fast = getSumOfSquares(getSumOfSquares(fast));
        } while (slow != fast);
        
        return slow == 1;
    }
    
    private static int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println("Is 19 happy: " + isHappy(19));
        System.out.println("Is 2 happy: " + isHappy(2));
        System.out.println("Is 7 happy: " + isHappy(7));
        
        System.out.println("Is 19 happy (optimal): " + isHappyOptimal(19));
    }
}