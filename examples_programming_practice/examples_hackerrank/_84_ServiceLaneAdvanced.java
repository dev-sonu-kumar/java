/*
 * PROBLEM STATEMENT:
 * Calvin is driving his favorite vehicle on the 101 freeway. He notices that the check engine light of his vehicle is on, and he wants to service it immediately to avoid any risks.
 * Luckily, a service lane runs parallel to the highway. The service lane varies in width along its length.
 * 
 * You will be given an array of widths at points along the service lane. Then you will be given a list of vehicles that want to pass through the service lane represented by their widths.
 * For each vehicle, find if it can pass through the entire lane.
 * 
 * Example:
 * Input: width = [2,3,1,2,3,2,3,3], vehicles = [1,2,3,4]
 * Output: [YES, YES, NO, NO]
 * 
 * Constraints: 1 ≤ n ≤ 100000, 1 ≤ vehicles ≤ 1000, 1 ≤ width[i] ≤ 3, 1 ≤ vehicle_width ≤ 3
 */

import java.util.*;

public class _84_ServiceLaneAdvanced {
    public static String[] canPass(int[] width, int[] vehicles) {
        int minWidth = Arrays.stream(width).min().orElse(0);
        String[] results = new String[vehicles.length];
        
        for (int i = 0; i < vehicles.length; i++) {
            results[i] = vehicles[i] <= minWidth ? "YES" : "NO";
        }
        
        return results;
    }
    
    public static void main(String[] args) {
        int[] width = {2, 3, 1, 2, 3, 2, 3, 3};
        int[] vehicles = {1, 2, 3, 4};
        
        String[] results = canPass(width, vehicles);
        System.out.println("Can pass: " + Arrays.toString(results));
    }
}