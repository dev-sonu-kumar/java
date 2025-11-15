/*
 * PROBLEM STATEMENT:
 * Lily likes to play games with integers. She has created a new game where she determines the difference between the number and its reverse.
 * For instance, given the number 12, its reverse is 21. Their difference is |12 - 21| = 9.
 * The number is beautiful if and only if this difference is evenly divisible by k.
 * 
 * Given a range of numbered days, [i...j] and a number k, determine the number of days in the range that are beautiful.
 * 
 * Example:
 * Input: i = 20, j = 23, k = 6
 * Output: 2
 * Explanation: Days 20 and 22 are beautiful.
 * 
 * Constraints: 1 ≤ i ≤ j ≤ 2×10^6, 1 ≤ k ≤ 2×10^9
 */

public class _89_BeautifulDaysAtTheMovies {
    public static int beautifulDays(int i, int j, int k) {
        int count = 0;
        
        for (int day = i; day <= j; day++) {
            int reversed = reverseNumber(day);
            int difference = Math.abs(day - reversed);
            
            if (difference % k == 0) {
                count++;
            }
        }
        
        return count;
    }
    
    private static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
    
    public static void main(String[] args) {
        System.out.println("Beautiful days (20-23, k=6): " + beautifulDays(20, 23, 6));
        System.out.println("Beautiful days (13-45, k=3): " + beautifulDays(13, 45, 3));
    }
}