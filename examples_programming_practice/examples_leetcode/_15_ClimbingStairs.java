/*
 * PROBLEM STATEMENT:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * Constraints: 1 ≤ n ≤ 45
 */

public class _15_ClimbingStairs {
    // Dynamic Programming approach - O(n) time, O(1) space
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        
        int prev2 = 1; // ways to reach step 1
        int prev1 = 2; // ways to reach step 2
        
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    public static void main(String[] args) {
        System.out.println("Ways to climb 2 stairs: " + climbStairs(2));
        System.out.println("Ways to climb 3 stairs: " + climbStairs(3));
        System.out.println("Ways to climb 5 stairs: " + climbStairs(5));
        System.out.println("Ways to climb 10 stairs: " + climbStairs(10));
    }
}