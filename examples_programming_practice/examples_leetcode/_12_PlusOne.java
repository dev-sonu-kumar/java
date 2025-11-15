/*
 * PROBLEM STATEMENT:
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading zero, except the number 0 itself.
 * 
 * Increment the large integer by one and return the resulting array of digits.
 * 
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123. Incrementing by one gives 123 + 1 = 124.
 * 
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321. Incrementing by one gives 4321 + 1 = 4322.
 * 
 * Example 3:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9. Incrementing by one gives 9 + 1 = 10.
 * 
 * Constraints: 1 ≤ digits.length ≤ 100, 0 ≤ digits[i] ≤ 9, digits does not contain any leading zeros except for the number 0 itself.
 */

import java.util.Arrays;

public class _12_PlusOne {
    public static int[] plusOne(int[] digits) {
        // Start from the rightmost digit
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // Set to 0 and continue with carry
        }
        
        // If we reach here, all digits were 9
        // Need to create new array with extra digit
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
    
    public static void main(String[] args) {
        int[] digits1 = {1, 2, 3};
        System.out.println("Plus one of [1,2,3]: " + Arrays.toString(plusOne(digits1)));
        
        int[] digits2 = {4, 3, 2, 1};
        System.out.println("Plus one of [4,3,2,1]: " + Arrays.toString(plusOne(digits2)));
        
        int[] digits3 = {9};
        System.out.println("Plus one of [9]: " + Arrays.toString(plusOne(digits3)));
        
        int[] digits4 = {9, 9, 9};
        System.out.println("Plus one of [9,9,9]: " + Arrays.toString(plusOne(digits4)));
    }
}