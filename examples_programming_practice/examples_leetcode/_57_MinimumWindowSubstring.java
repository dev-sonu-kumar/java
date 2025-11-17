/*
 * PROBLEM STATEMENT:
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * 
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * 
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * 
 * Constraints: m == s.length, n == t.length, 1 ≤ m, n ≤ 10^5
 */

import java.util.*;

public class _57_MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                
                char d = s.charAt(left);
                left++;
                
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
    
    public static void main(String[] args) {
        System.out.println("Min window: " + minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("Min window: " + minWindow("a", "a"));
    }
}