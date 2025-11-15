/*
 * PROBLEM STATEMENT:
 * Given an integer x, return true if x is palindrome integer.
 * 
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is a palindrome while 123 is not.
 * 
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * 
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * 
 * Constraints: -2^31 ≤ x ≤ 2^31 - 1
 */

public class _3_PalindromeNumber {
    // Optimal Solution - O(log n) time, O(1) space
    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) return false;
        
        // Single digit numbers are palindromes
        if (x < 10) return true;
        
        // Numbers ending with 0 (except 0 itself) are not palindromes
        if (x % 10 == 0) return false;
        
        int reversed = 0;
        int original = x;
        
        // Reverse only half the number for optimization
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        
        // For even length: x == reversed
        // For odd length: x == reversed / 10
        return x == reversed || x == reversed / 10;
    }
    
    public static void main(String[] args) {
        System.out.println("121 is palindrome: " + isPalindrome(121));
        System.out.println("-121 is palindrome: " + isPalindrome(-121));
        System.out.println("10 is palindrome: " + isPalindrome(10));
    }
}