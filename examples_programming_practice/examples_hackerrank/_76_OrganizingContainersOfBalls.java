/*
 * PROBLEM STATEMENT:
 * David has several containers, each with a number of balls in it. He has just enough containers to sort each type of ball he has into its own container.
 * David wants to sort the balls using his containers. As a first step, he has to organize the containers.
 * 
 * In a single operation, David can swap two balls located in different containers.
 * 
 * Given q queries in the form of 2D arrays, help David determine if he can sort the balls.
 * 
 * Example:
 * Input: container = [[1,1],[1,1]]
 * Output: Possible
 * 
 * Constraints: 1 ≤ q ≤ 10, 1 ≤ n ≤ 100, 0 ≤ container[i][j] ≤ 10^9
 */

import java.util.*;

public class _76_OrganizingContainersOfBalls {
    public static String organizingContainers(int[][] container) {
        int n = container.length;
        
        // Calculate container capacities (total balls in each container)
        long[] containerCapacity = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                containerCapacity[i] += container[i][j];
            }
        }
        
        // Calculate ball type counts (total balls of each type)
        long[] ballTypeCount = new long[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                ballTypeCount[j] += container[i][j];
            }
        }
        
        // Sort both arrays and compare
        Arrays.sort(containerCapacity);
        Arrays.sort(ballTypeCount);
        
        for (int i = 0; i < n; i++) {
            if (containerCapacity[i] != ballTypeCount[i]) {
                return "Impossible";
            }
        }
        
        return "Possible";
    }
    
    public static void main(String[] args) {
        int[][] container1 = {{1, 1}, {1, 1}};
        System.out.println("Organizing containers [[1,1],[1,1]]: " + organizingContainers(container1));
        
        int[][] container2 = {{0, 2}, {1, 1}};
        System.out.println("Organizing containers [[0,2],[1,1]]: " + organizingContainers(container2));
        
        int[][] container3 = {{1, 3, 1}, {2, 1, 2}, {3, 3, 3}};
        System.out.println("Organizing containers [[1,3,1],[2,1,2],[3,3,3]]: " + organizingContainers(container3));
    }
}