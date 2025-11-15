/*
 * PROBLEM STATEMENT:
 * Given a sequence of integers a, a triplet (a[i], a[j], a[k]) is beautiful if:
 * - i < j < k
 * - a[j] - a[i] = a[k] - a[j] = d
 * 
 * Given an increasing sequenced array of integers and the value of d, count the number of beautiful triplets in the sequence.
 * 
 * Example:
 * Input: d = 3, arr = [1, 2, 4, 5, 7, 8, 10]
 * Output: 3
 * Explanation: Beautiful triplets: (1,4,7), (4,7,10), (2,5,8)
 * 
 * Constraints: 1 ≤ n ≤ 10^4, 1 ≤ d ≤ 20, 0 ≤ arr[i] ≤ 2×10^4
 */

import java.util.*;

public class _80_BeautifulTriplets {
    public static int beautifulTriplets(int d, int[] arr) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }
        
        int count = 0;
        
        // For each number, check if it can be the first element of a beautiful triplet
        for (int num : arr) {
            int second = num + d;
            int third = num + 2 * d;
            
            if (numSet.contains(second) && numSet.contains(third)) {
                count++;
            }
        }
        
        return count;
    }
    
    // Alternative approach without using Set
    public static int beautifulTripletsAlternative(int d, int[] arr) {
        int count = 0;
        int n = arr.length;
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[j] - arr[i] == d) {
                    for (int k = j + 1; k < n; k++) {
                        if (arr[k] - arr[j] == d) {
                            count++;
                            break; // Found the triplet, move to next j
                        }
                    }
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 10};
        System.out.println("Beautiful triplets with d=3: " + beautifulTriplets(3, arr));
        
        int[] arr2 = {2, 2, 3, 4, 5};
        System.out.println("Beautiful triplets with d=1: " + beautifulTriplets(1, arr2));
        
        System.out.println("Beautiful triplets (alternative) with d=3: " + beautifulTripletsAlternative(3, arr));
    }
}