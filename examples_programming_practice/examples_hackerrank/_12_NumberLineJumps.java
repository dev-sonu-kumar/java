/*
 * PROBLEM STATEMENT:
 * You are choreographing a circus show with various animals. For one act, you are given two kangaroos on a number line ready to jump in the positive direction.
 * - The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.
 * - The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.
 * 
 * You have to figure out a way to get both kangaroos at the same location at the same time as part of the show.
 * If it is possible, return YES, otherwise return NO.
 * 
 * Example:
 * Input: x1=0, v1=3, x2=4, v2=2
 * Output: YES
 * Explanation: After 4 jumps, both kangaroos will be at position 12.
 * 
 * Constraints: 0 ≤ x1 < x2 ≤ 10000, 1 ≤ v1, v2 ≤ 10000
 */

public class _12_NumberLineJumps {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // If kangaroo 1 is behind and moving slower or same speed, they'll never meet
        if (x1 < x2 && v1 <= v2) {
            return "NO";
        }
        
        // If kangaroo 1 is ahead and moving faster or same speed, they'll never meet
        if (x1 > x2 && v1 >= v2) {
            return "NO";
        }
        
        // Check if they can meet at some point
        // x1 + v1*t = x2 + v2*t
        // (v1 - v2)*t = x2 - x1
        // t = (x2 - x1) / (v1 - v2)
        
        if (v1 == v2) {
            return x1 == x2 ? "YES" : "NO";
        }
        
        int numerator = x2 - x1;
        int denominator = v1 - v2;
        
        // Check if t is a non-negative integer
        if (numerator % denominator == 0 && numerator / denominator >= 0) {
            return "YES";
        }
        
        return "NO";
    }
    
    public static void main(String[] args) {
        System.out.println(kangaroo(0, 3, 4, 2)); // YES
        System.out.println(kangaroo(0, 2, 5, 3)); // NO
    }
}