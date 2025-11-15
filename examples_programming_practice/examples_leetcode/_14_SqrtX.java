/*
 * PROBLEM STATEMENT:
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 * 
 * You must not use any built-in exponent function or operator.
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 * 
 * Example 1:
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * 
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 * 
 * Constraints: 0 ≤ x ≤ 2^31 - 1
 */

public class _14_SqrtX {
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        
        int left = 1, right = x;
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (mid <= x / mid) { // Use division to avoid overflow
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("sqrt(4) = " + mySqrt(4));
        System.out.println("sqrt(8) = " + mySqrt(8));
        System.out.println("sqrt(0) = " + mySqrt(0));
        System.out.println("sqrt(1) = " + mySqrt(1));
        System.out.println("sqrt(2147395599) = " + mySqrt(2147395599));
    }
}