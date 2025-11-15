/*
 * PROBLEM STATEMENT:
 * Given an array of strings of digits, try to find the occurrence of a given pattern of digits.
 * In the grid and pattern arrays, each string represents a row in the grid. For example, consider the following grid:
 * 
 * 1234567890  
 * 0987654321  
 * 1111111111  
 * 1111111111  
 * 2222222222  
 * 
 * Determine whether pattern 876543 appears in the grid.
 * 
 * Example:
 * Input: G = ["7283455864", "6731158619", "8988242643", "3830589324", "2229505813", "5633845374", "6473530293", "7053106601", "0834282956", "4607924137"], P = ["9505", "3845", "3530"]
 * Output: YES
 * 
 * Constraints: 1 ≤ R, C ≤ 1000, 1 ≤ r, c ≤ R, C
 */

public class _71_TheGridSearch {
    public static String gridSearch(String[] G, String[] P) {
        int R = G.length;
        int C = G[0].length();
        int r = P.length;
        int c = P[0].length();
        
        // Try each possible starting position
        for (int i = 0; i <= R - r; i++) {
            for (int j = 0; j <= C - c; j++) {
                if (matchesPattern(G, P, i, j)) {
                    return "YES";
                }
            }
        }
        
        return "NO";
    }
    
    private static boolean matchesPattern(String[] G, String[] P, int startRow, int startCol) {
        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < P[0].length(); j++) {
                if (G[startRow + i].charAt(startCol + j) != P[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String[] G = {"7283455864", "6731158619", "8988242643", "3830589324", "2229505813", "5633845374", "6473530293", "7053106601", "0834282956", "4607924137"};
        String[] P = {"9505", "3845", "3530"};
        
        System.out.println("Pattern found: " + gridSearch(G, P));
    }
}