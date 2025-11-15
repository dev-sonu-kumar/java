/*
 * PROBLEM STATEMENT:
 * Given a string, remove characters until the string is made up of any two alternating characters.
 * When you choose a character to remove, all instances of that character must be removed.
 * Determine the longest string possible that contains just two alternating letters.
 * 
 * Example:
 * Input: s = "beabeefeab"
 * Output: 5
 * Explanation: The longest string we can make by deleting characters is "babab" or "aeaea".
 * 
 * Constraints: 1 ≤ |s| ≤ 1000
 */

import java.util.*;

public class _34_TwoCharacters {
    public static int alternate(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        
        int maxLength = 0;
        
        // Try all pairs of characters
        for (char c1 : uniqueChars) {
            for (char c2 : uniqueChars) {
                if (c1 != c2) {
                    String filtered = filterString(s, c1, c2);
                    if (isAlternating(filtered)) {
                        maxLength = Math.max(maxLength, filtered.length());
                    }
                }
            }
        }
        
        return maxLength;
    }
    
    private static String filterString(String s, char c1, char c2) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == c1 || c == c2) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private static boolean isAlternating(String s) {
        if (s.length() <= 1) return true;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("Max alternating length for 'beabeefeab': " + alternate("beabeefeab"));
        System.out.println("Max alternating length for 'asdcbsdcagfsdbgdfanfghbsfdab': " + alternate("asdcbsdcagfsdbgdfanfghbsfdab"));
    }
}