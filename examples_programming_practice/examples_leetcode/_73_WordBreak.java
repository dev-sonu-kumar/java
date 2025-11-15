/*
 * PROBLEM STATEMENT:
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * 
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 * 
 * Constraints: 1 ≤ s.length ≤ 300, 1 ≤ wordDict.length ≤ 1000, 1 ≤ wordDict[i].length ≤ 20
 */

import java.util.*;

public class _73_WordBreak {
    // Dynamic Programming approach - O(n^2) time, O(n) space
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string can always be segmented
        
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
    
    // Memoization approach
    public static boolean wordBreakMemo(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, Boolean> memo = new HashMap<>();
        return wordBreakHelper(s, wordSet, memo);
    }
    
    private static boolean wordBreakHelper(String s, Set<String> wordSet, Map<String, Boolean> memo) {
        if (s.isEmpty()) return true;
        
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix) && wordBreakHelper(s.substring(i), wordSet, memo)) {
                memo.put(s, true);
                return true;
            }
        }
        
        memo.put(s, false);
        return false;
    }
    
    public static void main(String[] args) {
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println("Word break 'leetcode': " + wordBreak("leetcode", wordDict1));
        
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println("Word break 'applepenapple': " + wordBreak("applepenapple", wordDict2));
        
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Word break 'catsandog': " + wordBreak("catsandog", wordDict3));
        
        System.out.println("Word break (memo) 'leetcode': " + wordBreakMemo("leetcode", wordDict1));
    }
}