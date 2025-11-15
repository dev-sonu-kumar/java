/*
 * PROBLEM STATEMENT:
 * Manasa is out on a hike with friends. She finds a trail of stones with numbers on them.
 * She starts and ends with a stone with number 0. For every step she takes, she can choose to step on a stone with number a or a stone with number b.
 * If she takes n steps, find all the possible values for the sum of the numbers on the stones she steps on.
 * 
 * Example:
 * Input: n = 3, a = 1, b = 2
 * Output: [2, 3, 4, 5, 6]
 * Explanation: Possible paths: 0+1+1+1=3, 0+1+1+2=4, 0+1+2+2=5, 0+2+2+2=6. But we start and end with 0, so subtract 0: [2,3,4,5,6]. Wait, let me recalculate...
 * Actually: She takes n steps, so possible sums are: i*a + (n-i)*b for i from 0 to n.
 * 
 * Constraints: 1 ≤ T ≤ 10, 1 ≤ n ≤ 1000, 0 ≤ a, b ≤ 1000
 */

import java.util.*;

public class _70_ManasaAndStones {
    public static int[] stones(int n, int a, int b) {
        Set<Integer> possibleSums = new TreeSet<>();
        
        // For n steps, we can take i steps of value 'a' and (n-1-i) steps of value 'b'
        // where i ranges from 0 to n-1
        for (int i = 0; i < n; i++) {
            int sum = i * a + (n - 1 - i) * b;
            possibleSums.add(sum);
        }
        
        return possibleSums.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void main(String[] args) {
        int[] result1 = stones(3, 1, 2);
        System.out.println("Possible sums for n=3, a=1, b=2: " + Arrays.toString(result1));
        
        int[] result2 = stones(4, 10, 100);
        System.out.println("Possible sums for n=4, a=10, b=100: " + Arrays.toString(result2));
    }
}