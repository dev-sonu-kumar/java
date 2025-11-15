/*
 * PROBLEM STATEMENT:
 * A person wants to determine the most expensive computer keyboard and USB drive that can be purchased with a give budget.
 * Given price lists for keyboards and USB drives and a budget, find the cost to buy them. If it is not possible to buy both items, return -1.
 * 
 * Example:
 * Input: b = 10, keyboards = [3, 1], drives = [5, 2, 8]
 * Output: 9
 * Explanation: Buy keyboard for 1 and drive for 8, total = 9.
 * 
 * Constraints: 1 ≤ n, m ≤ 1000, 1 ≤ b ≤ 10^6, 1 ≤ keyboard[i], drive[i] ≤ 10^6
 */

public class _99_ElectronicsShop {
    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int maxSpent = -1;
        
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                int total = keyboard + drive;
                if (total <= b) {
                    maxSpent = Math.max(maxSpent, total);
                }
            }
        }
        
        return maxSpent;
    }
    
    public static void main(String[] args) {
        int[] keyboards = {3, 1};
        int[] drives = {5, 2, 8};
        System.out.println("Max money spent (budget=10): " + getMoneySpent(keyboards, drives, 10));
        
        int[] keyboards2 = {4};
        int[] drives2 = {5};
        System.out.println("Max money spent (budget=5): " + getMoneySpent(keyboards2, drives2, 5));
    }
}