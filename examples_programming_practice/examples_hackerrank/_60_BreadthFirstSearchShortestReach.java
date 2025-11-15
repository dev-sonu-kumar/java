/*
 * PROBLEM STATEMENT:
 * Consider an undirected graph consisting of n nodes where each node is labeled from 1 to n and the edge between any two nodes is always of length 6.
 * We define node s to be the starting position for a BFS. Given a graph, determine the distances from the start node to each of its descendants and return the list in node number order, ascending.
 * If a node is unreachable, its distance is -1. Exclude the start node from the list.
 * 
 * Example:
 * Input: n=4, edges=[[1,2],[1,3]], s=1
 * Output: [6, 6, -1]
 * Explanation: Distances from node 1: to 2=6, to 3=6, to 4=-1 (unreachable).
 * 
 * Constraints: 1 ≤ n ≤ 1000, 1 ≤ m ≤ n*(n-1)/2, 1 ≤ u,v ≤ n, 1 ≤ s ≤ n
 */

import java.util.*;

public class _60_BreadthFirstSearchShortestReach {
    public static int[] bfs(int n, int[][] edges, int s) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // BFS to find shortest distances
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[s] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[current] + 6;
                    queue.offer(neighbor);
                }
            }
        }
        
        // Prepare result excluding start node
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                result.add(distances[i]);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public static void main(String[] args) {
        int[][] edges1 = {{1, 2}, {1, 3}};
        int[] result1 = bfs(4, edges1, 1);
        System.out.println("Distances from node 1: " + Arrays.toString(result1));
        
        int[][] edges2 = {{2, 3}};
        int[] result2 = bfs(3, edges2, 2);
        System.out.println("Distances from node 2: " + Arrays.toString(result2));
    }
}