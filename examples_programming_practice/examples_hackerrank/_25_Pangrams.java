/*
 * PROBLEM STATEMENT:
 * A pangram is a string that contains every letter of the alphabet. Given a sentence determine whether it is a pangram in the English alphabet.
 * Ignore case. Return either pangram or not pangram as appropriate.
 * 
 * Example:
 * Input: s = "The quick brown fox jumps over the lazy dog"
 * Output: pangram
 * 
 * Constraints: 0 < length of s < 1000, s consists only of uppercase letters, lowercase letters, and spaces.
 */

public class _25_Pangrams {
    public static String pangrams(String s) {
        boolean[] alphabet = new boolean[26];
        
        for (char c : s.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                alphabet[c - 'a'] = true;
            }
        }
        
        for (boolean present : alphabet) {
            if (!present) {
                return "not pangram";
            }
        }
        
        return "pangram";
    }
    
    public static void main(String[] args) {
        System.out.println("'The quick brown fox jumps over the lazy dog': " + pangrams("The quick brown fox jumps over the lazy dog"));
        System.out.println("'We promptly judged antique ivory buckles for the next prize': " + pangrams("We promptly judged antique ivory buckles for the next prize"));
    }
}