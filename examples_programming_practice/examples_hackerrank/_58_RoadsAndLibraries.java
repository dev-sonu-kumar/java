/*
 * PROBLEM STATEMENT:
 * Determine the minimum cost to provide library access to all citizens of HackerLand.
 * There are n cities numbered from 1 to n. Initially there are no libraries and the cities are not connected.
 * Building a library in city i costs c_lib.
 * Building a road between cities i and j costs c_road.
 * 
 * Each library serves its city and all cities connected to it via roads.
 * Given q queries, find the minimum cost to make libraries accessible to all citizens for each query.
 * 
 * Example:
 * Input: n=3, c_lib=2, c_road=1, cities=[[1,2],[3,1],[2,3]]
 * Output: 4
 * Explanation: Build 1 library and 2 roads for cost 2+1+1=4.
 * 
 * Constraints: 1 ≤ q ≤ 10, 1 ≤ n ≤ 10^5, 0 ≤ m ≤ min(10^5, n*(n-1)/2), 1 ≤ c_road, c_lib ≤ 10^5
 */

import java.util.*;

public class _58_RoadsAndLibraries {
    public static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        // If library cost <= road cost, build library in each city
        if (c_lib <= c_road) {
            return (long) n * c_lib;
        }
        
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] city : cities) {
            graph.get(city[0]).add(city[1]);
            graph.get(city[1]).add(city[0]);
        }
        
        boolean[] visited = new boolean[n + 1];
        long totalCost = 0;
        
        // Find connected components using DFS
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                int componentSize = dfs(graph, visited, i);
                // Cost = 1 library + (componentSize - 1) roads
                totalCost += c_lib + (long) (componentSize - 1) * c_road;
            }
        }
        
        return totalCost;
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
        int[][] cities1 = {{1, 2}, {3, 1}, {2, 3}};
        System.out.println("Min cost for n=3, c_lib=2, c_road=1: " + roadsAndLibraries(3, 2, 1, cities1));
        
        int[][] cities2 = {{1, 3}, {3, 4}, {2, 4}, {1, 2}, {2, 3}, {5, 6}};
        System.out.println("Min cost for n=6, c_lib=2, c_road=5: " + roadsAndLibraries(6, 2, 5, cities2));
    }
}