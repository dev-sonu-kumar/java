/*
 * PROBLEM STATEMENT:
 * Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * 
 * Example 1:
 * Input: n = 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * 
 * Example 2:
 * Input: n = 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * 
 * Example 3:
 * Input: n = 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 * 
 * Constraints: The input must be a binary string of length 32
 */

public class _85_NumberOf1Bits {
    // Bit manipulation approach - check each bit
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1; // Unsigned right shift
        }
        return count;
    }
    
    // Brian Kernighan's algorithm - O(number of 1 bits)
    public static int hammingWeightOptimal(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // Remove the rightmost 1 bit
            count++;
        }
        return count;
    }
    
    // Using built-in method
    public static int hammingWeightBuiltIn(int n) {
        return Integer.bitCount(n);
    }
    
    public static void main(String[] args) {
        int n1 = 0b00000000000000000000000000001011; // 11 in decimal
        System.out.println("Number of 1 bits in " + n1 + ": " + hammingWeight(n1));
        
        int n2 = 0b00000000000000000000000010000000; // 128 in decimal
        System.out.println("Number of 1 bits in " + n2 + ": " + hammingWeight(n2));
        
        int n3 = -3; // 11111111111111111111111111111101 in binary
        System.out.println("Number of 1 bits in " + n3 + ": " + hammingWeight(n3));
        
        System.out.println("Number of 1 bits (optimal) in " + n1 + ": " + hammingWeightOptimal(n1));
        System.out.println("Number of 1 bits (built-in) in " + n1 + ": " + hammingWeightBuiltIn(n1));
    }
}