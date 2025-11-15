/*
 * PROBLEM STATEMENT:
 * John Watson knows of an operation called a right circular rotation on an array of integers.
 * One rotation operation moves the last array element to the first position and shifts all remaining elements right one.
 * To test Sherlock's abilities, Watson provides Sherlock with an array of integers. Sherlock is to perform exactly k right circular rotations on the array.
 * Then Watson will ask m queries. For each query, you are given an index and asked to report the element at that index.
 * 
 * Example:
 * Input: a = [3, 4, 5], k = 2, queries = [1, 2]
 * Output: [5, 3]
 * Explanation: After 2 rotations: [5, 3, 4]. queries[1]=3, queries[2]=4... wait, let me recalculate.
 * After 2 rotations: [4, 5, 3]. queries at index 1=5, index 2=3.
 * 
 * Constraints: 1 ≤ n ≤ 10^5, 1 ≤ k ≤ 10^5, 1 ≤ m ≤ 500, 0 ≤ queries[i] < n
 */

import java.util.*;

public class _92_CircularArrayRotation {
    public static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int n = a.length;
        k = k % n; // Optimize rotations
        
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int originalIndex = (queries[i] - k + n) % n;
            result[i] = a[originalIndex];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] a = {3, 4, 5};
        int[] queries = {1, 2};
        int[] result = circularArrayRotation(a, 2, queries);
        System.out.println("Query results: " + Arrays.toString(result));
    }
}