/*
 * PROBLEM STATEMENT:
 * There are a number of people who will be attending ACM-ICPC World Finals. Each of them may be well versed in a number of topics.
 * Given a list of topics known by each attendee, presented as binary strings, determine the maximum number of topics a 2-person team can know.
 * Also find the number of teams that know the maximum number of topics.
 * 
 * Example:
 * Input: topic = ["10101", "11100", "11010", "00101"]
 * Output: [5, 2]
 * Explanation: Maximum topics = 5, Number of teams with max topics = 2
 * 
 * Constraints: 2 ≤ n ≤ 500, 1 ≤ m ≤ 500
 */

import java.util.*;

public class _86_ACMICPCTeam {
    public static int[] acmTeam(String[] topic) {
        int n = topic.length;
        int maxTopics = 0;
        int teamCount = 0;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int topics = countCombinedTopics(topic[i], topic[j]);
                
                if (topics > maxTopics) {
                    maxTopics = topics;
                    teamCount = 1;
                } else if (topics == maxTopics) {
                    teamCount++;
                }
            }
        }
        
        return new int[]{maxTopics, teamCount};
    }
    
    private static int countCombinedTopics(String person1, String person2) {
        int count = 0;
        for (int i = 0; i < person1.length(); i++) {
            if (person1.charAt(i) == '1' || person2.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        String[] topic = {"10101", "11100", "11010", "00101"};
        int[] result = acmTeam(topic);
        System.out.println("Max topics and team count: " + Arrays.toString(result));
    }
}