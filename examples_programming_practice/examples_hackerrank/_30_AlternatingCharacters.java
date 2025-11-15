/*
 * PROBLEM STATEMENT:
 * You are given a string containing characters A and B only. Your task is to change it into a string such that there are no matching adjacent characters.
 * To do this, you are allowed to delete zero or more characters in the string.
 * 
 * Your task is to find the minimum number of required deletions.
 * 
 * Example:
 * Input: s = "AAAA"
 * Output: 3
 * Explanation: Delete 3 A's to get "A".
 * 
 * Input: s = "BBBBB"
 * Output: 4
 * 
 * Input: s = "ABABABAB"
 * Output: 0
 * 
 * Constraints: 1 ≤ |s| ≤ 10^5, Each string s[i] ∈ {A, B}
 */

public class _30_AlternatingCharacters {
    public static int alternatingCharacters(String s) {
        int deletions = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                deletions++;
            }
        }
        
        return deletions;
    }
    
    public static void main(String[] args) {
        System.out.println("Deletions for 'AAAA': " + alternatingCharacters("AAAA"));
        System.out.println("Deletions for 'BBBBB': " + alternatingCharacters("BBBBB"));
        System.out.println("Deletions for 'ABABABAB': " + alternatingCharacters("ABABABAB"));
        System.out.println("Deletions for 'BABABA': " + alternatingCharacters("BABABA"));
    }
}