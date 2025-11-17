/*
 * PROBLEM STATEMENT:
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * 
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * Example 2:
 * Input: digits = ""
 * Output: []
 * 
 * Constraints: 0 ≤ digits.length ≤ 4, digits[i] is a digit in the range ['2', '9']
 */

import java.util.*;

public class _78_LetterCombinationsOfPhoneNumber {
    private static final String[] PHONE = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    
    private static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        String letters = PHONE[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Letter combinations: " + letterCombinations("23"));
        System.out.println("Letter combinations: " + letterCombinations(""));
    }
}