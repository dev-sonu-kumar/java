/*
 * PROBLEM STATEMENT:
 * A numeric string, s, is beautiful if it can be split into a sequence of two or more positive integers, a[1], a[2], ..., a[n], satisfying the following conditions:
 * 1. a[i] - a[i-1] = 1 for any 1 < i ≤ n (i.e., each element in the sequence is 1 more than the previous element).
 * 2. No a[i] contains a leading zero. For example, we can't choose 01, 02, and 03 because they have leading zeros that make them invalid.
 * 
 * Given a string of digits, determine if it is beautiful. If it is, print YES x, where x is the first number of the increasing sequence.
 * If it's not, print NO.
 * 
 * Example:
 * Input: s = "1234"
 * Output: YES 1
 * 
 * Constraints: 1 ≤ |s| ≤ 32
 */

public class _27_SeparateTheNumbers {
    public static void separateNumbers(String s) {
        if (s.length() == 1 || s.charAt(0) == '0') {
            System.out.println("NO");
            return;
        }
        
        for (int len = 1; len <= s.length() / 2; len++) {
            String firstNum = s.substring(0, len);
            if (isBeautiful(s, firstNum)) {
                System.out.println("YES " + firstNum);
                return;
            }
        }
        
        System.out.println("NO");
    }
    
    private static boolean isBeautiful(String s, String firstNum) {
        long num = Long.parseLong(firstNum);
        String expected = firstNum;
        
        while (expected.length() < s.length()) {
            num++;
            expected += String.valueOf(num);
        }
        
        return expected.equals(s);
    }
    
    public static void main(String[] args) {
        separateNumbers("1234");
        separateNumbers("91011");
        separateNumbers("99100");
        separateNumbers("101103");
    }
}