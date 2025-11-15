/*
 * PROBLEM STATEMENT:
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * Note:
 * - Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * - In Java, the compiler represents the signed integers using 2's complement notation.
 * 
 * Example 1:
 * Input: n = 00000010100101000001111010011100
 * Output:   964176192 (00111001011110000010100101000000)
 * 
 * Example 2:
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * 
 * Constraints: The input must be a binary string of length 32
 */

public class _84_ReverseBits {
    // Bit manipulation approach
    public static int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>= 1;
        }
        
        return result;
    }
    
    // Alternative approach using Integer methods
    public static int reverseBitsAlt(int n) {
        return Integer.reverse(n);
    }
    
    // Divide and conquer approach
    public static int reverseBitsDivideConquer(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
    
    public static void main(String[] args) {
        int n1 = 0b00000010100101000001111010011100;
        System.out.println("Reverse bits of " + n1 + ": " + reverseBits(n1));
        
        int n2 = -3; // 11111111111111111111111111111101 in binary
        System.out.println("Reverse bits of " + n2 + ": " + reverseBits(n2));
        
        System.out.println("Reverse bits (alt) of " + n1 + ": " + reverseBitsAlt(n1));
    }
}