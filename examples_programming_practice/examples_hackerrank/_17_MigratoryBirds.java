/*
 * PROBLEM STATEMENT:
 * Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type.
 * If more than 1 type has been spotted that maximum amount, return the smallest of their ids.
 * 
 * Example:
 * Input: arr = [1, 4, 4, 4, 5, 3]
 * Output: 4
 * Explanation: Type 4 appears 3 times, which is the maximum frequency.
 * 
 * Constraints: 5 ≤ arr.length ≤ 2×10^5, It is guaranteed that each type is 1, 2, 3, 4, or 5.
 */

public class _17_MigratoryBirds {
    public static int migratoryBirds(int[] arr) {
        int[] count = new int[6]; // Index 0 unused, 1-5 for bird types
        
        // Count frequency of each bird type
        for (int bird : arr) {
            count[bird]++;
        }
        
        // Find the type with maximum frequency (smallest id in case of tie)
        int maxCount = 0;
        int result = 1;
        
        for (int i = 1; i <= 5; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                result = i;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 4, 4, 4, 5, 3};
        System.out.println("Most frequent bird type: " + migratoryBirds(arr));
    }
}