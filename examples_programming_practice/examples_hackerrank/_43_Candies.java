/*
 * PROBLEM STATEMENT:
 * Alice is a kindergarten teacher. She wants to give some candies to the children in her class.
 * All the children sit in a line and each of them has a rating score according to his or her performance in the class.
 * Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies.
 * Alice wants to minimize the total number of candies she must buy.
 * 
 * Example:
 * Input: arr = [1, 2, 2]
 * Output: 4
 * Explanation: Give candies [1, 2, 1] for a total of 4.
 * 
 * Constraints: 1 ≤ n ≤ 10^5, 1 ≤ arr[i] ≤ 10^5
 */

public class _43_Candies {
    public static long candies(int n, int[] arr) {
        int[] candies = new int[n];
        
        // Initialize all children with 1 candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        
        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        
        // Right to left pass
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        
        long total = 0;
        for (int candy : candies) {
            total += candy;
        }
        
        return total;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2};
        System.out.println("Candies needed for [1,2,2]: " + candies(3, arr1));
        
        int[] arr2 = {2, 4, 2, 6, 1, 7, 8, 9, 2, 1};
        System.out.println("Candies needed for [2,4,2,6,1,7,8,9,2,1]: " + candies(10, arr2));
    }
}