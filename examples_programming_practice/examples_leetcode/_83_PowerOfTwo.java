/*
 * PROBLEM STATEMENT:
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2^x.
 * 
 * Example 1:
 * Input: n = 1
 * Output: true
 * Explanation: 2^0 = 1
 * 
 * Example 2:
 * Input: n = 16
 * Output: true
 * Explanation: 2^4 = 16
 * 
 * Example 3:
 * Input: n = 3
 * Output: false
 * 
 * Constraints: -2^31 ≤ n ≤ 2^31 - 1
 */

public class _83_PowerOfTwo {
    // Bit manipulation approach - O(1) time, O(1) space
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    
    // Alternative approach using bit count
    public static boolean isPowerOfTwoAlt(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
    
    // Iterative approach
    public static boolean isPowerOfTwoIterative(int n) {
        if (n <= 0) return false;
        
        while (n % 2 == 0) {
            n /= 2;
        }
        
        return n == 1;
    }
    
    public static void main(String[] args) {
        System.out.println("Is 1 power of two: " + isPowerOfTwo(1));
        System.out.println("Is 16 power of two: " + isPowerOfTwo(16));
        System.out.println("Is 3 power of two: " + isPowerOfTwo(3));
        System.out.println("Is 0 power of two: " + isPowerOfTwo(0));
        System.out.println("Is -16 power of two: " + isPowerOfTwo(-16));
        
        System.out.println("Is 8 power of two (alt): " + isPowerOfTwoAlt(8));
    }
}