/*
 * PROBLEM STATEMENT:
 * You wish to buy video games from the famous online video game store Mist.
 * Usually, all games cost the same amount - p dollars. However, they are planning to have the usual Halloween Sale.
 * When a game is purchased, the price of the next game reduces by d dollars until the price becomes equal to or less than m dollars.
 * After that, every game will cost m dollars. How many games can you buy during the Halloween Sale?
 * 
 * Example:
 * Input: p = 20, d = 3, m = 6, s = 80
 * Output: 6
 * Explanation: Prices: 20, 17, 14, 11, 8, 6, 6... Total for 6 games = 76 ≤ 80
 * 
 * Constraints: 1 ≤ m ≤ p ≤ 100, 1 ≤ d ≤ 100, 1 ≤ s ≤ 10^4
 */

public class _82_HalloweenSale {
    public static int howManyGames(int p, int d, int m, int s) {
        int games = 0;
        int currentPrice = p;
        
        while (s >= currentPrice) {
            s -= currentPrice;
            games++;
            
            // Reduce price for next game, but not below minimum
            currentPrice = Math.max(currentPrice - d, m);
        }
        
        return games;
    }
    
    public static void main(String[] args) {
        System.out.println("Games can buy: " + howManyGames(20, 3, 6, 80));
        System.out.println("Games can buy: " + howManyGames(20, 3, 6, 85));
    }
}