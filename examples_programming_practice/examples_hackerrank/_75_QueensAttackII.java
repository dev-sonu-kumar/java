/*
 * PROBLEM STATEMENT:
 * You will be given a square chess board with one queen and a number of obstacles placed on it.
 * Determine how many squares the queen can attack.
 * 
 * A queen can attack any square that lies in the same row, column, or diagonal as the queen.
 * 
 * Example:
 * Input: n=4, k=0, r_q=4, c_q=4, obstacles=[]
 * Output: 9
 * Explanation: Queen at (4,4) can attack 9 squares in all directions.
 * 
 * Constraints: 0 ≤ k ≤ 10^5, 1 ≤ n ≤ 10^5, 1 ≤ r_q, c_q ≤ n
 */

import java.util.*;

public class _75_QueensAttackII {
    public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        
        int totalAttacks = 0;
        
        // 8 directions: up, down, left, right, and 4 diagonals
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        
        for (int[] dir : directions) {
            int dr = dir[0];
            int dc = dir[1];
            
            int r = r_q + dr;
            int c = c_q + dc;
            
            while (r >= 1 && r <= n && c >= 1 && c <= n) {
                if (obstacleSet.contains(r + "," + c)) {
                    break;
                }
                totalAttacks++;
                r += dr;
                c += dc;
            }
        }
        
        return totalAttacks;
    }
    
    public static void main(String[] args) {
        int[][] obstacles1 = {};
        System.out.println("Queen attacks for n=4, queen at (4,4), no obstacles: " + queensAttack(4, 0, 4, 4, obstacles1));
        
        int[][] obstacles2 = {{5, 5}, {4, 2}, {2, 3}};
        System.out.println("Queen attacks for n=5, queen at (4,3), with obstacles: " + queensAttack(5, 3, 4, 3, obstacles2));
    }
}