/*
 * PROBLEM STATEMENT:
 * Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.
 * Lily decides to share a contiguous segment of the bar selected such that:
 * - The length of the segment matches Ron's birth month, and
 * - The sum of the integers on the squares is equal to his birth day.
 * 
 * Determine how many ways she can divide the chocolate.
 * 
 * Example:
 * Input: s = [1, 2, 1, 3, 2], d = 3, m = 2
 * Output: 2
 * Explanation: Lily wants to find segments of length 2 that sum to 3. The segments [1, 2] and [2, 1] satisfy this.
 * 
 * Constraints: 1 ≤ n ≤ 100, 1 ≤ s[i] ≤ 5, 1 ≤ d ≤ 31, 1 ≤ m ≤ 12
 */

public class _15_SubarrayDivision {
    public static int birthday(int[] s, int d, int m) {
        int count = 0;
        
        // Check all possible segments of length m
        for (int i = 0; i <= s.length - m; i++) {
            int sum = 0;
            
            // Calculate sum of current segment
            for (int j = i; j < i + m; j++) {
                sum += s[j];
            }
            
            // Check if sum equals birth day
            if (sum == d) {
                count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[] s = {1, 2, 1, 3, 2};
        int d = 3; // birth day
        int m = 2; // birth month
        System.out.println("Ways to divide chocolate: " + birthday(s, d, m));
    }
}