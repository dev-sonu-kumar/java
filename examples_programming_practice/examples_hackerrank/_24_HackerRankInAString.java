/*
 * PROBLEM STATEMENT:
 * We say that a string contains the word hackerrank if a subsequence of its characters spell the word hackerrank.
 * Remeber that a subsequence maintains the relative order of characters selected from a sequence.
 * More formally, let p[0], p[1], ..., p[9] be the respective indices of h, a, c, k, e, r, r, a, n, k in string s.
 * If p[0] < p[1] < p[2] < ... < p[9], then s contains hackerrank.
 * 
 * For each query, print YES if the string contains hackerrank, otherwise, print NO.
 * 
 * Example:
 * Input: s = "hhaacckkekraraannk"
 * Output: YES
 * 
 * Constraints: 2 ≤ q ≤ 10^2, 10 ≤ |s| ≤ 10^4
 */

public class _24_HackerRankInAString {
    public static String hackerrankInString(String s) {
        String target = "hackerrank";
        int targetIndex = 0;
        
        for (char c : s.toCharArray()) {
            if (targetIndex < target.length() && c == target.charAt(targetIndex)) {
                targetIndex++;
            }
        }
        
        return targetIndex == target.length() ? "YES" : "NO";
    }
    
    public static void main(String[] args) {
        System.out.println("'hhaacckkekraraannk' contains hackerrank: " + hackerrankInString("hhaacckkekraraannk"));
        System.out.println("'rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt' contains hackerrank: " + hackerrankInString("rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt"));
    }
}