/*
 * PROBLEM STATEMENT:
 * There will be two arrays of integers. Determine all integers that satisfy the following two conditions:
 * 1. The elements of the first array are all factors of the integer being considered
 * 2. The integer being considered is a factor of all elements of the second array
 * 
 * These numbers are referred to as being between the two arrays. Determine how many such numbers exist.
 * 
 * Example:
 * Input: a = [2, 6], b = [24, 36]
 * Output: 2
 * Explanation: Numbers 6 and 12 satisfy both conditions.
 * 
 * Constraints: 1 ≤ n, m ≤ 10, 1 ≤ a[i] ≤ 100, 1 ≤ b[i] ≤ 100
 */

public class _13_BetweenTwoSets {
    public static int getTotalX(int[] a, int[] b) {
        int lcmA = a[0];
        for (int i = 1; i < a.length; i++) {
            lcmA = lcm(lcmA, a[i]);
        }
        
        int gcdB = b[0];
        for (int i = 1; i < b.length; i++) {
            gcdB = gcd(gcdB, b[i]);
        }
        
        int count = 0;
        for (int i = lcmA; i <= gcdB; i += lcmA) {
            if (gcdB % i == 0) {
                count++;
            }
        }
        
        return count;
    }
    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    public static void main(String[] args) {
        int[] a = {2, 6};
        int[] b = {24, 36};
        System.out.println("Numbers between sets: " + getTotalX(a, b));
    }
}