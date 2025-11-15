/*
 * PROBLEM STATEMENT:
 * You are in charge of the cake for a child's birthday. You have decided the cake will have one candle for each year of their total age.
 * They will only be able to blow out the tallest candles. Count how many candles are tallest.
 * 
 * Input: Array of candle heights
 * Output: Number of tallest candles
 * 
 * Example:
 * Input: [4, 4, 1, 3]
 * Output: 2
 * Explanation: The tallest candles are 4 units high. There are 2 of them.
 * 
 * Constraints: 1 ≤ n ≤ 10^5, 1 ≤ candles[i] ≤ 10^7
 */

public class _8_BirthdayCakeCandles {
    public static int birthdayCakeCandles(int[] candles) {
        int maxHeight = 0;
        int count = 0;
        
        // Find maximum height
        for (int height : candles) {
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        
        // Count candles with maximum height
        for (int height : candles) {
            if (height == maxHeight) {
                count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[] candles = {4, 4, 1, 3};
        System.out.println("Tallest candles count: " + birthdayCakeCandles(candles));
    }
}