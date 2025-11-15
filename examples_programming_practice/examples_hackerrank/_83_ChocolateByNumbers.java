/*
 * PROBLEM STATEMENT:
 * Two children, A and B, are sharing a chocolate bar. The bar is divided into small squares arranged in a rectangular pattern.
 * Child A gets the first move and can choose any square. Then they alternate turns.
 * On each turn, a child chooses one piece of chocolate from those remaining and eats it.
 * The goal is to be the last one to eat a piece of chocolate.
 * 
 * Example:
 * Input: n = 2, m = 2
 * Output: First
 * Explanation: A can always win by taking 3 pieces, leaving 1 for B.
 * 
 * Constraints: 1 ≤ n, m ≤ 10^9
 */

public class _83_ChocolateByNumbers {
    public static String choclate(int n, int m) {
        // Total pieces of chocolate
        long total = (long) n * m;
        
        // If total is odd, first player wins
        // If total is even, second player wins (assuming optimal play)
        return (total % 2 == 1) ? "First" : "Second";
    }
    
    public static void main(String[] args) {
        System.out.println("Winner for 2x2: " + choclate(2, 2));
        System.out.println("Winner for 1x1: " + choclate(1, 1));
        System.out.println("Winner for 2x3: " + choclate(2, 3));
    }
}