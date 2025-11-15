/*
 * PROBLEM STATEMENT:
 * You are the benevolent ruler of Rankhacker Castle, and today you're distributing bread.
 * Your subjects are in a line, and some of them already have some loaves. Times are hard and your castle's food stocks are dwindling, so you must distribute as few loaves as possible according to the following rules:
 * 1. Every time you give a loaf of bread to some person i, you must also give a loaf of bread to the person immediately in front of or behind them in the line (i.e., persons i±1).
 * 2. After all the bread is distributed, each person must have an even number of loaves.
 * 
 * Given the number of loaves already held by each citizen, find and print the minimum number of loaves you must distribute to satisfy the two rules above.
 * If this is not possible, print NO.
 * 
 * Example:
 * Input: B = [2, 3, 4, 5, 6]
 * Output: 4
 * Explanation: Give 2 loaves to positions 1,2 and 2 loaves to positions 3,4. Total = 4.
 * 
 * Constraints: 1 ≤ N ≤ 100, 1 ≤ B[i] ≤ 100
 */

public class _68_FairRations {
    public static String fairRations(int[] B) {
        int loaves = 0;
        
        for (int i = 0; i < B.length - 1; i++) {
            if (B[i] % 2 == 1) { // If current person has odd loaves
                B[i]++;     // Give one loaf to current person
                B[i + 1]++; // Give one loaf to next person
                loaves += 2;
            }
        }
        
        // Check if last person has even loaves
        if (B[B.length - 1] % 2 == 1) {
            return "NO";
        }
        
        return String.valueOf(loaves);
    }
    
    public static void main(String[] args) {
        int[] B1 = {2, 3, 4, 5, 6};
        System.out.println("Min loaves for [2,3,4,5,6]: " + fairRations(B1));
        
        int[] B2 = {1, 2};
        System.out.println("Min loaves for [1,2]: " + fairRations(B2));
        
        int[] B3 = {1};
        System.out.println("Min loaves for [1]: " + fairRations(B3));
    }
}