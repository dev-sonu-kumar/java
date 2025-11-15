/*
 * PROBLEM STATEMENT:
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * 
 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * 
 * Example 3:
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * 
 * Constraints: 1 ≤ s.length ≤ 10^4, s consists of only English letters and spaces ' '.
 */

public class _11_LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        // Trim trailing spaces and work backwards
        int end = s.length() - 1;
        
        // Skip trailing spaces
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        
        // Count characters of the last word
        int length = 0;
        while (end >= 0 && s.charAt(end) != ' ') {
            length++;
            end--;
        }
        
        return length;
    }
    
    public static void main(String[] args) {
        System.out.println("Length of last word in 'Hello World': " + lengthOfLastWord("Hello World"));
        System.out.println("Length of last word in '   fly me   to   the moon  ': " + lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println("Length of last word in 'luffy is still joyboy': " + lengthOfLastWord("luffy is still joyboy"));
    }
}