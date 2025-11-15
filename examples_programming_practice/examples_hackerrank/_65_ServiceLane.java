/*
 * PROBLEM STATEMENT:
 * A driver is driving on the freeway. The check engine light of his vehicle is on, and the driver wants to get to a service lane as soon as possible.
 * The freeway has n segments. Each segment has a certain width. The service lane runs parallel to the freeway and can be entered at any segment.
 * The driver can only enter the service lane at segments where the width is at least as wide as his vehicle.
 * 
 * Given the width of n segments and t test cases where each test case has a starting and ending segment, determine the largest vehicle that can pass through the service lane.
 * 
 * Example:
 * Input: width = [2,3,1,2,3,2,3,3], cases = [[0,3],[4,6],[6,7],[3,5],[0,7]]
 * Output: [1,2,3,2,1]
 * 
 * Constraints: 2 ≤ n ≤ 100000, 1 ≤ t ≤ 1000, 0 ≤ i ≤ j < n, 1 ≤ width[k] ≤ 3
 */

public class _65_ServiceLane {
    public static int[] serviceLane(int[] width, int[][] cases) {
        int[] results = new int[cases.length];
        
        for (int i = 0; i < cases.length; i++) {
            int start = cases[i][0];
            int end = cases[i][1];
            
            int minWidth = Integer.MAX_VALUE;
            for (int j = start; j <= end; j++) {
                minWidth = Math.min(minWidth, width[j]);
            }
            
            results[i] = minWidth;
        }
        
        return results;
    }
    
    public static void main(String[] args) {
        int[] width = {2, 3, 1, 2, 3, 2, 3, 3};
        int[][] cases = {{0, 3}, {4, 6}, {6, 7}, {3, 5}, {0, 7}};
        
        int[] results = serviceLane(width, cases);
        System.out.print("Service lane results: ");
        for (int result : results) {
            System.out.print(result + " ");
        }
        System.out.println();
    }
}