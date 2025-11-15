/*
 * PROBLEM STATEMENT:
 * The member states of the UN are planning to send 2 people to the moon. They want them to be from different countries.
 * You will be given a list of pairs of astronaut ID's. Each pair is made of astronauts from the same country.
 * Determine how many ways they can pick a pair of astronauts from different countries.
 * 
 * Example:
 * Input: n=5, astronaut=[[0,1],[2,3],[0,4]]
 * Output: 6
 * Explanation: Groups: {0,1,4} and {2,3}. Ways: 3*2 = 6.
 * 
 * Constraints: 1 ≤ n ≤ 10^5, 0 ≤ p ≤ 10^4
 */

import java.util.*;

public class _59_JourneyToTheMoon {
    public static long journeyToMoon(int n, int[][] astronaut) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] pair : astronaut) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }
        
        boolean[] visited = new boolean[n];
        List<Integer> componentSizes = new ArrayList<>();
        
        // Find all connected components (countries)
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(graph, visited, i);
                componentSizes.add(size);
            }
        }
        
        // Calculate total ways to pick 2 astronauts from different countries
        long totalWays = (long) n * (n - 1) / 2;
        
        // Subtract ways to pick 2 astronauts from same country
        for (int size : componentSizes) {
            totalWays -= (long) size * (size - 1) / 2;
        }
        
        return totalWays;
    }
    
    private static int dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        int size = 1;
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(graph, visited, neighbor);
            }
        }
        
        return size;
    }
    
    public static void main(String[] args) {
        int[][] astronaut1 = {{0, 1}, {2, 3}, {0, 4}};
        System.out.println("Ways to pick astronauts from different countries: " + journeyToMoon(5, astronaut1));
        
        int[][] astronaut2 = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println("Ways to pick astronauts from different countries: " + journeyToMoon(5, astronaut2));
    }
}