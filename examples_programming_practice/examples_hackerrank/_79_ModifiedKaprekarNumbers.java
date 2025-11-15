/*
 * PROBLEM STATEMENT:
 * A modified Kaprekar number is a positive whole number with a special property.
 * If you square it, then split the number into two integers and sum those integers, you have the same value you started with.
 * 
 * Consider a positive whole number n with d digits. We square n to arrive at a number that is either 2×d digits long or (2×d)-1 digits long.
 * Split the string representation of the square into two parts, l and r. The right hand part, r must be d digits long.
 * The left is the remaining substring. Convert those substrings back to integers, denote them as l and r.
 * If l + r = n, then n is a modified Kaprekar number. If l is empty, then l = 0.
 * 
 * Example:
 * Input: p = 1, q = 100
 * Output: 1 9 45 55 99
 * 
 * Constraints: 1 ≤ p < q < 100000
 */

import java.util.*;

public class _79_ModifiedKaprekarNumbers {
    public static void kaprekarNumbers(int p, int q) {
        List<Integer> kaprekarNums = new ArrayList<>();
        
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                kaprekarNums.add(i);
            }
        }
        
        if (kaprekarNums.isEmpty()) {
            System.out.println("INVALID RANGE");
        } else {
            for (int num : kaprekarNums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    private static boolean isKaprekar(int n) {
        long square = (long) n * n;
        String squareStr = String.valueOf(square);
        int d = String.valueOf(n).length();
        
        // Split the square into left and right parts
        if (squareStr.length() < d) {
            return false;
        }
        
        String rightStr = squareStr.substring(squareStr.length() - d);
        String leftStr = squareStr.substring(0, squareStr.length() - d);
        
        int right = Integer.parseInt(rightStr);
        int left = leftStr.isEmpty() ? 0 : Integer.parseInt(leftStr);
        
        return left + right == n;
    }
    
    public static void main(String[] args) {
        System.out.print("Kaprekar numbers between 1 and 100: ");
        kaprekarNumbers(1, 100);
        
        System.out.print("Kaprekar numbers between 400 and 700: ");
        kaprekarNumbers(400, 700);
    }
}