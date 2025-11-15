/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates advanced string algorithms:
 * 1. Anagram detection - Check if two strings are anagrams
 * 2. String rotation - Check if one string is rotation of another
 * 3. Longest common subsequence (LCS)
 * 4. Pattern matching - Find all occurrences of pattern in text
 * 5. String compression - Basic run-length encoding
 * 6. Remove duplicates from string
 */

import java.util.*;

public class _2_StringAlgorithmsExample {
    public static void main(String[] args) {
        System.out.println("=== String Algorithms ===");
        
        // Test data
        String str1 = "listen";
        String str2 = "silent";
        String str3 = "waterbottle";
        String str4 = "erbottlewat";
        String text = "ABABDABACDABABCABCABCABCABC";
        String pattern = "ABABCABCAB";
        
        // 1. Anagram detection
        System.out.println("\n1. Anagram Detection:");
        System.out.println("'" + str1 + "' and '" + str2 + "' are anagrams: " + areAnagrams(str1, str2));
        System.out.println("'" + str1 + "' and '" + str3 + "' are anagrams: " + areAnagrams(str1, str3));
        
        // 2. String rotation
        System.out.println("\n2. String Rotation:");
        System.out.println("'" + str4 + "' is rotation of '" + str3 + "': " + isRotation(str3, str4));
        
        // 3. Longest Common Subsequence
        System.out.println("\n3. Longest Common Subsequence:");
        String lcs = longestCommonSubsequence("ABCDGH", "AEDFHR");
        System.out.println("LCS of 'ABCDGH' and 'AEDFHR': '" + lcs + "'");
        
        // 4. Pattern matching
        System.out.println("\n4. Pattern Matching:");
        List<Integer> matches = findPatternOccurrences(text, pattern);
        System.out.println("Pattern '" + pattern + "' found at positions: " + matches);
        
        // 5. String compression
        System.out.println("\n5. String Compression:");
        String compressed = compressString("aabcccccaaa");
        System.out.println("'aabcccccaaa' compressed: '" + compressed + "'");
        
        // 6. Remove duplicates
        System.out.println("\n6. Remove Duplicates:");
        String withoutDuplicates = removeDuplicates("programming");
        System.out.println("'programming' without duplicates: '" + withoutDuplicates + "'");
    }
    
    // Check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Method 1: Using sorting
        char[] chars1 = str1.toLowerCase().toCharArray();
        char[] chars2 = str2.toLowerCase().toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2);
    }
    
    // Alternative anagram check using frequency counting
    public static boolean areAnagramsFrequency(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        int[] frequency = new int[26]; // For lowercase letters
        
        for (int i = 0; i < str1.length(); i++) {
            frequency[str1.charAt(i) - 'a']++;
            frequency[str2.charAt(i) - 'a']--;
        }
        
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
    
    // Check if str2 is rotation of str1
    public static boolean isRotation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // If str2 is rotation of str1, then str2 will be substring of str1+str1
        String doubled = str1 + str1;
        return doubled.contains(str2);
    }
    
    // Find longest common subsequence using dynamic programming
    public static String longestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        // Create DP table
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Reconstruct LCS
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        
        return lcs.toString();
    }
    
    // Find all occurrences of pattern in text (naive approach)
    public static List<Integer> findPatternOccurrences(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int textLen = text.length();
        int patternLen = pattern.length();
        
        for (int i = 0; i <= textLen - patternLen; i++) {
            int j;
            for (j = 0; j < patternLen; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == patternLen) {
                occurrences.add(i);
            }
        }
        
        return occurrences;
    }
    
    // Compress string using run-length encoding
    public static String compressString(String str) {
        if (str.length() <= 1) {
            return str;
        }
        
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        char currentChar = str.charAt(0);
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentChar) {
                count++;
            } else {
                compressed.append(currentChar).append(count);
                currentChar = str.charAt(i);
                count = 1;
            }
        }
        
        // Add the last character and its count
        compressed.append(currentChar).append(count);
        
        // Return original string if compression doesn't reduce length
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
    
    // Remove duplicate characters from string
    public static String removeDuplicates(String str) {
        Set<Character> seen = new LinkedHashSet<>();
        
        for (char c : str.toCharArray()) {
            seen.add(c);
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : seen) {
            result.append(c);
        }
        
        return result.toString();
    }
    
    // Alternative: Remove duplicates maintaining first occurrence
    public static String removeDuplicatesArray(String str) {
        boolean[] seen = new boolean[256]; // ASCII characters
        StringBuilder result = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                result.append(c);
            }
        }
        
        return result.toString();
    }
}