/*
 * PROBLEM STATEMENT:
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * 
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * 
 * Example 2:
 * Input: s = "raceacar"
 * Output: [["r","a","c","e","a","c","a","r"],["r","a","ce","c","a","r"],["r","ace","ca","r"],["raceacar"]]
 * 
 * Constraints: 1 ≤ s.length ≤ 16
 */

import java.util.*;

public class _79_PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                backtrack(s, end + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("Palindrome partitions: " + partition("aab"));
        System.out.println("Palindrome partitions: " + partition("raceacar"));
    }
}