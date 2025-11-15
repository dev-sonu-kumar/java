/*
 * PROBLEM STATEMENT:
 * There is a sequence of words in CamelCase as a string of letters having the following properties:
 * - It is a concatenation of one or more words consisting of English letters.
 * - All letters in the first word are lowercase.
 * - For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
 * 
 * Given s, determine the number of words in s.
 * 
 * Example:
 * Input: s = "saveChangesInTheEditor"
 * Output: 5
 * 
 * Constraints: 1 ≤ |s| ≤ 10^5
 */

public class _21_CamelCase {
    public static int camelcase(String s) {
        int wordCount = 1; // At least one word
        
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                wordCount++;
            }
        }
        
        return wordCount;
    }
    
    public static void main(String[] args) {
        System.out.println("Words in 'saveChangesInTheEditor': " + camelcase("saveChangesInTheEditor"));
        System.out.println("Words in 'oneTwoThree': " + camelcase("oneTwoThree"));
    }
}