/*
 * PROBLEM STATEMENT:
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * 
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * 
 * Constraints: 1 ≤ s.length ≤ 300, 1 ≤ wordDict.length ≤ 1000
 */

import java.util.*;

public class _68_WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
    public static void main(String[] args) {
        List<String> dict1 = Arrays.asList("leet", "code");
        System.out.println("Word break: " + wordBreak("leetcode", dict1));
        
        List<String> dict2 = Arrays.asList("apple", "pen");
        System.out.println("Word break: " + wordBreak("applepenapple", dict2));
    }
}