/*
 * PROBLEM STATEMENT:
 * An integer d is a divisor of an integer n if the remainder of n ÷ d is 0.
 * Given an integer, for each digit that makes up the integer determine whether it is a divisor.
 * Count the number of divisors. Return the number of digits in n that are divisors of n.
 * This is an advanced version that handles edge cases and optimizations.
 * 
 * Example:
 * Input: n = 1012
 * Output: 3
 * Explanation: 1, 1, and 2 are divisors of 1012. 0 is not counted as it would cause division by zero.
 * 
 * Constraints: 1 ≤ n ≤ 10^9
 */

public class _95_FindDigitsAdvanced {
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
    
    // Alternative string-based approach
    public static int findDigitsString(int n) {
        String numStr = String.valueOf(n);
        int count = 0;
        
        for (char c : numStr.toCharArray()) {
            int digit = c - '0';
            if (digit != 0 && n % digit == 0) {
                count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println("Divisor digits in 1012: " + findDigits(1012));
        System.out.println("Divisor digits in 124: " + findDigits(124));
        System.out.println("Divisor digits in 111: " + findDigits(111));
        
        System.out.println("Divisor digits (string) in 1012: " + findDigitsString(1012));
    }
}