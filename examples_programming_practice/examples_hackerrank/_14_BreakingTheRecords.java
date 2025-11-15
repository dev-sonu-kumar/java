/*
 * PROBLEM STATEMENT:
 * Maria plays college basketball and wants to go pro. Each season she maintains a record of her play.
 * She tabulates the number of times she breaks her season record for most points and least points in a game.
 * Points scored in the first game establish her record for the season, and she begins counting from there.
 * 
 * Example:
 * Input: scores = [10, 5, 20, 20, 4, 5, 2, 25, 1]
 * Output: [2, 4]
 * Explanation: She broke her best record twice (after games 2 and 7) and her worst record four times (after games 1, 4, 6, and 8).
 * 
 * Constraints: 1 ≤ n ≤ 1000, 0 ≤ scores[i] ≤ 10^8
 */

import java.util.Arrays;

public class _14_BreakingTheRecords {
    public static int[] breakingRecords(int[] scores) {
        int maxScore = scores[0];
        int minScore = scores[0];
        int maxBreaks = 0;
        int minBreaks = 0;
        
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxBreaks++;
            } else if (scores[i] < minScore) {
                minScore = scores[i];
                minBreaks++;
            }
        }
        
        return new int[]{maxBreaks, minBreaks};
    }
    
    public static void main(String[] args) {
        int[] scores = {10, 5, 20, 20, 4, 5, 2, 25, 1};
        int[] result = breakingRecords(scores);
        System.out.println("Records broken: " + Arrays.toString(result));
    }
}