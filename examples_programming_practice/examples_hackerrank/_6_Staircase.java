/*
 * PROBLEM STATEMENT:
 * Staircase detail: This is a staircase of size n = 4:
 *    #
 *   ##
 *  ###
 * ####
 * 
 * Its base and height are both equal to n. It is drawn using # symbols and spaces.
 * The last line is not preceded by any spaces.
 * 
 * Input: Integer n
 * Output: Print a staircase of size n using # symbols
 * 
 * Constraints: 0 < n ≤ 100
 */

public class _6_Staircase {
    public static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // Print hashes
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        staircase(6);
    }
}