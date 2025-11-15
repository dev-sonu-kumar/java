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
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Constraints: 0 ≤ s.length ≤ 5 * 10^4, s consists of English letters, digits, symbols and spaces.
 */

import java.util.*;

public class _55_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If character is already seen and is within current window
            if (charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= left) {
                left = charIndex.get(currentChar) + 1;
            }
            
            charIndex.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    // Alternative approach using Set
    public static int lengthOfLongestSubstringSet(String s) {
        Set<Character> window = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            
            window.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        System.out.println("Longest substring length for 'abcabcbb': " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("Longest substring length for 'bbbbb': " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("Longest substring length for 'pwwkew': " + lengthOfLongestSubstring("pwwkew"));
        System.out.println("Longest substring length for '': " + lengthOfLongestSubstring(""));
    }
}