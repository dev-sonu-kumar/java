/*
 * PROBLEM STATEMENT:
 * Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from 1 to 100 for three categories: problem clarity, originality, and difficulty.
 * 
 * The rating for Alice's challenge is the triplet a = (a[0], a[1], a[2]), and the rating for Bob's challenge is the triplet b = (b[0], b[1], b[2]).
 * 
 * The task is to find their comparison points by comparing a[0] with b[0], a[1] with b[1], and a[2] with b[2].
 * 
 * If a[i] > b[i], then Alice is awarded 1 point.
 * If a[i] < b[i], then Bob is awarded 1 point.
 * If a[i] = b[i], then neither person receives a point.
 * 
 * Example:
 * Input: a = [1, 2, 3], b = [3, 2, 1]
 * Output: [1, 1]
 */

import java.util.Arrays;

public class _2_CompareTheTriplets {
    public static int[] compareTriplets(int[] a, int[] b) {
        int aliceScore = 0;
        int bobScore = 0;
        
        for (int i = 0; i < 3; i++) {
            if (a[i] > b[i]) {
                aliceScore++;
            } else if (a[i] < b[i]) {
                bobScore++;
            }
        }
        
        return new int[]{aliceScore, bobScore};
    }
    
    public static void main(String[] args) {
        int[] alice = {1, 2, 3};
        int[] bob = {3, 2, 1};
        System.out.println("Result: " + Arrays.toString(compareTriplets(alice, bob)));
    }
}