/*
 * PROBLEM STATEMENT:
 * Taum is planning to celebrate HackerRank's birthday. He wants to buy some black gifts and some white gifts.
 * - Black gifts cost blackCost each
 * - White gifts cost whiteCost each
 * - Gifts can be converted from one color to another at a conversion cost of z per gift converted
 * 
 * Given the number of black and white gifts and their costs, find the minimum amount Taum will spend.
 * 
 * Example:
 * Input: b = 10, w = 10, bc = 1, wc = 1, z = 1
 * Output: 20
 * 
 * Constraints: 1 ≤ T ≤ 10, 0 ≤ b, w, bc, wc, z ≤ 10^9
 */

public class _85_TaumAndBday {
    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Cost of buying black gifts directly vs converting from white
        long blackCost = Math.min(bc, wc + z);
        
        // Cost of buying white gifts directly vs converting from black
        long whiteCost = Math.min(wc, bc + z);
        
        return (long) b * blackCost + (long) w * whiteCost;
    }
    
    public static void main(String[] args) {
        System.out.println("Min cost: " + taumBday(10, 10, 1, 1, 1));
        System.out.println("Min cost: " + taumBday(5, 9, 2, 3, 4));
        System.out.println("Min cost: " + taumBday(3, 6, 9, 1, 1));
    }
}