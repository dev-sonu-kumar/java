/*
 * PROBLEM STATEMENT:
 * Little Bobby goes to the local store to spend some money on candy. He has n dollars to spend on candy.
 * Candy costs c dollars per piece. For every m wrappers he turns in, he gets one free candy.
 * How many candies can Bobby eat?
 * 
 * Example:
 * Input: n = 15, c = 3, m = 2
 * Output: 9
 * Explanation: He buys 5 candies, gets 2 free (4 wrappers), then 1 more free (2 wrappers). Total = 5+2+1+1 = 9.
 * 
 * Constraints: 1 ≤ n, c, m ≤ 1000
 */

public class _64_ChocolateFeast {
    public static int chocolateFeast(int n, int c, int m) {
        int candies = n / c; // Initial candies bought
        int wrappers = candies; // Initial wrappers
        
        // Exchange wrappers for more candies
        while (wrappers >= m) {
            int newCandies = wrappers / m;
            candies += newCandies;
            wrappers = wrappers % m + newCandies; // Remaining + new wrappers
        }
        
        return candies;
    }
    
    public static void main(String[] args) {
        System.out.println("Candies Bobby can eat (n=15, c=3, m=2): " + chocolateFeast(15, 3, 2));
        System.out.println("Candies Bobby can eat (n=10, c=2, m=5): " + chocolateFeast(10, 2, 5));
        System.out.println("Candies Bobby can eat (n=12, c=4, m=4): " + chocolateFeast(12, 4, 4));
    }
}