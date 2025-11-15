/*
 * PROBLEM STATEMENT:
 * You have two strings of lowercase English letters. You can perform two types of operations on the first string:
 * 1. Append a lowercase English letter to the end of the string.
 * 2. Delete the last character of the string. Performing this operation on an empty string results in an empty string.
 * 
 * Given an integer k and two strings s and t, determine whether or not you can convert s to t by performing exactly k of the above operations on s.
 * If it's possible, return "Yes". Otherwise, return "No".
 * 
 * Example:
 * Input: s = "hackerhappy", t = "hackerrank", k = 9
 * Output: Yes
 * 
 * Constraints: 1 ≤ |s|, |t| ≤ 100, 1 ≤ k ≤ 100
 */

public class _96_AppendAndDelete {
    public static String appendAndDelete(String s, String t, int k) {
        int commonLength = 0;
        int minLength = Math.min(s.length(), t.length());
        
        // Find common prefix length
        for (int i = 0; i < minLength; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                commonLength++;
            } else {
                break;
            }
        }
        
        // Operations needed: delete from s + append to reach t
        int operationsNeeded = (s.length() - commonLength) + (t.length() - commonLength);
        
        // Check if we can perform exactly k operations
        if (operationsNeeded <= k) {
            // Check if remaining operations can be used (must be even to return to same state)
            int remaining = k - operationsNeeded;
            if (remaining % 2 == 0 || remaining >= s.length() + t.length()) {
                return "Yes";
            }
        }
        
        return "No";
    }
    
    public static void main(String[] args) {
        System.out.println("Can convert 'hackerhappy' to 'hackerrank' in 9 ops: " + appendAndDelete("hackerhappy", "hackerrank", 9));
        System.out.println("Can convert 'aba' to 'aba' in 7 ops: " + appendAndDelete("aba", "aba", 7));
    }
}