/*
 * PROBLEM STATEMENT:
 * Flatland is a country with a number of cities, some of which have space stations.
 * Cities are numbered consecutively from 0 to n-1. A city with a space station can provide services to any city located within its vicinity.
 * If city i has a space station, it can provide services to cities max(0, i-1), max(0, i), and min(n-1, i+1).
 * 
 * Given a list of cities which have space stations, find the maximum distance from any city to its nearest space station.
 * 
 * Example:
 * Input: n=5, c=[0,4]
 * Output: 2
 * Explanation: Cities 0 and 4 have space stations. City 2 is farthest from any space station (distance 2).
 * 
 * Constraints: 1 ≤ n ≤ 10^5, 1 ≤ m ≤ n, 0 ≤ c[i] < n
 */

import java.util.Arrays;

public class _67_FlatlandSpaceStations {
    public static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int maxDistance = 0;
        
        // Distance from city 0 to first space station
        maxDistance = Math.max(maxDistance, c[0]);
        
        // Distance from last space station to city n-1
        maxDistance = Math.max(maxDistance, n - 1 - c[c.length - 1]);
        
        // Distance between consecutive space stations
        for (int i = 1; i < c.length; i++) {
            int distance = (c[i] - c[i - 1]) / 2;
            maxDistance = Math.max(maxDistance, distance);
        }
        
        return maxDistance;
    }
    
    public static void main(String[] args) {
        int[] c1 = {0, 4};
        System.out.println("Max distance for n=5, c=[0,4]: " + flatlandSpaceStations(5, c1));
        
        int[] c2 = {0, 1, 2, 4, 3, 5};
        System.out.println("Max distance for n=6, c=[0,1,2,4,3,5]: " + flatlandSpaceStations(6, c2));
    }
}