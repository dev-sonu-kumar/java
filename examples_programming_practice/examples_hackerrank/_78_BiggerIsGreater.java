/*
 * PROBLEM STATEMENT:
 * Lexicographical order is often known as alphabetical order when dealing with strings.
 * A string is greater than another string if it comes later in a lexicographically sorted list.
 * 
 * Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
 * - It must be greater than the original word
 * - It must be the smallest word that meets the first condition
 * 
 * Example:
 * Input: w = "ab"
 * Output: "ba"
 * 
 * Input: w = "bb"
 * Output: "no answer"
 * 
 * Input: w = "hefg"
 * Output: "hegg"
 * 
 * Constraints: 1 ≤ T ≤ 10^5, 1 ≤ |w| ≤ 100
 */

import java.util.Arrays;

public class _78_BiggerIsGreater {
    public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int n = chars.length;
        
        // Step 1: Find the largest index i such that chars[i] < chars[i+1]
        int i = n - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }
        
        // If no such index exists, no greater permutation is possible
        if (i < 0) {
            return "no answer";
        }
        
        // Step 2: Find the largest index j such that chars[i] < chars[j]
        int j = n - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }
        
        // Step 3: Swap chars[i] and chars[j]
        swap(chars, i, j);
        
        // Step 4: Reverse the suffix starting at chars[i+1]
        reverse(chars, i + 1, n - 1);
        
        return new String(chars);
    }
    
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Next permutation of 'ab': " + biggerIsGreater("ab"));
        System.out.println("Next permutation of 'bb': " + biggerIsGreater("bb"));
        System.out.println("Next permutation of 'hefg': " + biggerIsGreater("hefg"));
        System.out.println("Next permutation of 'dhck': " + biggerIsGreater("dhck"));
    }
}