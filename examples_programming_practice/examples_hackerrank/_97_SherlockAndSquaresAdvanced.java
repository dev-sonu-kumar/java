/*
 * PROBLEM STATEMENT:
 * Watson likes to challenge Sherlock's math ability. He will provide a starting and ending value that describe a range of integers, inclusive of the endpoints.
 * Within that range, determine how many square integers there are. This is an advanced version with optimizations.
 * 
 * Example:
 * Input: a = 3, b = 9
 * Output: 2
 * Explanation: There are 2 square integers in the range [3,9]: 4 and 9.
 * 
 * Constraints: 1 ≤ a ≤ b ≤ 10^9
 */

public class _97_SherlockAndSquaresAdvanced {
    public static int squares(int a, int b) {
        long sqrtA = (long) Math.ceil(Math.sqrt(a));
        long sqrtB = (long) Math.floor(Math.sqrt(b));
        
        return (int) Math.max(0, sqrtB - sqrtA + 1);
    }
    
    // Alternative approach with long arithmetic
    public static int squaresLong(long a, long b) {
        long sqrtA = (long) Math.ceil(Math.sqrt(a));
        long sqrtB = (long) Math.floor(Math.sqrt(b));
        
        return (int) Math.max(0, sqrtB - sqrtA + 1);
    }
    
    public static void main(String[] args) {
        System.out.println("Square integers between 3 and 9: " + squares(3, 9));
        System.out.println("Square integers between 17 and 24: " + squares(17, 24));
        System.out.println("Square integers between 100 and 1000: " + squares(100, 1000));
        
        System.out.println("Square integers (long) between 999999999 and 1000000000: " + squaresLong(999999999L, 1000000000L));
    }
}