/*
 * PROBLEM STATEMENT:
 * An integer d is a divisor of an integer n if the remainder of n ÷ d is 0.
 * Given an integer, for each digit that makes up the integer determine whether it is a divisor.
 * Count the number of divisors. Return the number of digits in n that are divisors of n.
 * 
 * Example:
 * Input: n = 124
 * Output: 3
 * Explanation: 1, 2, and 4 are all divisors of 124.
 * 
 * Constraints: 1 ≤ n ≤ 10^9
 */

public class _61_FindDigits {
    public static int findDigits(int n) {
        int count = 0;
        int original = n;
        
        while (n > 0) {
            int digit = n % 10;
            
            if (digit != 0 && original % digit == 0) {
                count++;
            }
            
            n /= 10;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println("Divisor digits in 124: " + findDigits(124));
        System.out.println("Divisor digits in 111: " + findDigits(111));
        System.out.println("Divisor digits in 10: " + findDigits(10));
    }
}