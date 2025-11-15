/*
 * PROBLEM STATEMENT:
 * James found a love letter that his friend Harry has written to his girlfriend. James is a prankster, so he decides to meddle with the letter.
 * He changes all the words in the letter into palindromes.
 * 
 * To do this, he follows two rules:
 * 1. He can only reduce the value of a letter by 1, i.e. he can change d to c, but he cannot change c to d or d to b.
 * 2. The letter a may not be reduced any further.
 * 
 * Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given string into a palindrome.
 * 
 * Example:
 * Input: s = "abc"
 * Output: 2
 * Explanation: Change 'c' to 'a' (2 operations) to get "aba".
 * 
 * Constraints: 1 ≤ |s| ≤ 10^4
 */

public class _32_TheLoveLetterMystery {
    public static int theLoveLetterMystery(String s) {
        int operations = 0;
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            
            if (leftChar != rightChar) {
                // Always reduce the larger character to match the smaller one
                operations += Math.abs(leftChar - rightChar);
            }
            
            left++;
            right--;
        }
        
        return operations;
    }
    
    public static void main(String[] args) {
        System.out.println("Operations for 'abc': " + theLoveLetterMystery("abc"));
        System.out.println("Operations for 'abcba': " + theLoveLetterMystery("abcba"));
        System.out.println("Operations for 'abcd': " + theLoveLetterMystery("abcd"));
    }
}