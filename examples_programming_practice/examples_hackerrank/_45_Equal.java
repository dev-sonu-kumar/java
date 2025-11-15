/*
 * PROBLEM STATEMENT:
 * Christy is interning at HackerRank. One day she has to distribute some chocolates to her colleagues.
 * She is biased towards her friends and may have distributed the chocolates unequally.
 * One of the colleagues points this out, so she has to make sure everyone gets equal number of chocolates.
 * 
 * But she can't take back chocolates from anyone. So she can only give more chocolates to some people.
 * She can give 1, 2, or 5 chocolates in one operation. Find the minimum number of operations needed.
 * 
 * Example:
 * Input: arr = [2, 2, 3, 7]
 * Output: 2
 * Explanation: Give 5 chocolates to first person, 5 to second person. Total operations = 2.
 * 
 * Constraints: 1 ≤ n ≤ 10000, 0 ≤ arr[i] ≤ 1000
 */

public class _45_Equal {
    public static int equal(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
        }
        
        int minOps = Integer.MAX_VALUE;
        
        // Try reducing minimum by 0, 1, 2, 3, 4 (to handle edge cases)
        for (int base = 0; base < 5; base++) {
            int target = min - base;
            int operations = 0;
            
            for (int num : arr) {
                int diff = num - target;
                operations += minOperations(diff);
            }
            
            operations += base * arr.length; // Add operations for reducing base
            minOps = Math.min(minOps, operations);
        }
        
        return minOps;
    }
    
    private static int minOperations(int n) {
        if (n < 0) return Integer.MAX_VALUE;
        
        int ops = 0;
        ops += n / 5;
        n %= 5;
        ops += n / 2;
        n %= 2;
        ops += n;
        
        return ops;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {2, 2, 3, 7};
        System.out.println("Min operations for [2,2,3,7]: " + equal(arr1));
        
        int[] arr2 = {1, 5, 5};
        System.out.println("Min operations for [1,5,5]: " + equal(arr2));
    }
}