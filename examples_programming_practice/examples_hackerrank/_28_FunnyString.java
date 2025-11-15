/*
 * PROBLEM STATEMENT:
 * In this challenge, you will determine whether a string is funny or not.
 * To determine if a string is funny, create a copy and reverse it. Iterate through each string and compare the absolute difference in ASCII values for each pair of characters.
 * If the absolute differences are the same, then the string is funny.
 * 
 * Example:
 * Input: s = "acxz"
 * Output: Funny
 * Explanation: 
 * s = "acxz", reverse = "zxca"
 * |a-c| = |z-x| = 2, |c-x| = |x-c| = 21, |x-z| = |c-a| = 2
 * All differences match, so it's funny.
 * 
 * Constraints: 2 ≤ |s| ≤ 10000
 */

public class _28_FunnyString {
    public static String funnyString(String s) {
        int n = s.length();
        
        for (int i = 1; i < n; i++) {
            int diff1 = Math.abs(s.charAt(i) - s.charAt(i - 1));
            int diff2 = Math.abs(s.charAt(n - i) - s.charAt(n - i - 1));
            
            if (diff1 != diff2) {
                return "Not Funny";
            }
        }
        
        return "Funny";
    }
    
    public static void main(String[] args) {
        System.out.println("'acxz' is: " + funnyString("acxz"));
        System.out.println("'bcxz' is: " + funnyString("bcxz"));
    }
}