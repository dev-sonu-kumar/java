/*
 * PROBLEM STATEMENT:
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * 
 * Constraints: 0 ≤ s.length ≤ 5 * 10^4
 */

import java.util.*;

public class _58_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
        System.out.println("Longest substring length: " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Longest substring length: " + lengthOfLongestSubstring("bbbbb"));
    }
}