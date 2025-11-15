/*
 * PROBLEM STATEMENT:
 * A weighted string is a string of lowercase English letters where each letter has a weight.
 * Character weights are 1 to 26 from a to z as shown below:
 * a=1, b=2, c=3, ..., z=26
 * 
 * The weight of a string is the sum of the weights of all the string's characters.
 * A uniform string consists of a single character repeated zero or more times.
 * For example, ccc and a are uniform strings, but bcb and cd are not.
 * 
 * Given a string, s, let U be the set of weights for all possible uniform substrings of s.
 * You have to answer q queries where each query consists of a single integer, x.
 * For each query, print Yes if x ∈ U. Otherwise, print No.
 * 
 * Example:
 * Input: s = "abccddde", queries = [1, 3, 12, 5, 9, 10]
 * Output: [Yes, Yes, Yes, Yes, No, No]
 * 
 * Constraints: 1 ≤ |s| ≤ 10^5, 1 ≤ q ≤ 10^5, 1 ≤ x ≤ 10^7
 */

import java.util.*;

public class _26_WeightedUniformStrings {
    public static String[] weightedUniformStrings(String s, int[] queries) {
        Set<Integer> uniformWeights = new HashSet<>();
        
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            int charWeight = currentChar - 'a' + 1;
            int count = 1;
            
            // Count consecutive occurrences
            while (i + 1 < s.length() && s.charAt(i + 1) == currentChar) {
                count++;
                i++;
            }
            
            // Add all possible uniform substring weights
            for (int j = 1; j <= count; j++) {
                uniformWeights.add(charWeight * j);
            }
            
            i++;
        }
        
        String[] results = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            results[i] = uniformWeights.contains(queries[i]) ? "Yes" : "No";
        }
        
        return results;
    }
    
    public static void main(String[] args) {
        String s = "abccddde";
        int[] queries = {1, 3, 12, 5, 9, 10};
        String[] results = weightedUniformStrings(s, queries);
        System.out.println("Results: " + Arrays.toString(results));
    }
}