/*
 * PROBLEM STATEMENT:
 * Sam's house has an apple tree and an orange tree that yield an abundance of fruit.
 * Using the information given below, determine the number of apples and oranges that land on Sam's house.
 * 
 * The house is between points s and t on the x-axis.
 * Apple tree is at point a, orange tree is at point b.
 * When a fruit falls from its tree, it lands d units of distance from its tree of origin along the x-axis.
 * 
 * Input: s, t (house range), a, b (tree positions), apples[], oranges[] (distances)
 * Output: Count of apples and oranges that land on house
 * 
 * Example:
 * House: [7, 11], Apple tree: 5, Orange tree: 15
 * Apples: [-2, 2, 1], Oranges: [5, -6]
 * Output: 1 apple, 1 orange
 */

public class _11_AppleAndOrange {
    public static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleCount = 0;
        int orangeCount = 0;
        
        // Count apples that land on house
        for (int apple : apples) {
            int position = a + apple;
            if (position >= s && position <= t) {
                appleCount++;
            }
        }
        
        // Count oranges that land on house
        for (int orange : oranges) {
            int position = b + orange;
            if (position >= s && position <= t) {
                orangeCount++;
            }
        }
        
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }
    
    public static void main(String[] args) {
        int s = 7, t = 11, a = 5, b = 15;
        int[] apples = {-2, 2, 1};
        int[] oranges = {5, -6};
        countApplesAndOranges(s, t, a, b, apples, oranges);
    }
}