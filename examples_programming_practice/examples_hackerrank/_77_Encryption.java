/*
 * PROBLEM STATEMENT:
 * An English text needs to be encrypted using the following encryption scheme.
 * First, the spaces are removed from the text. Let L be the length of this text.
 * Then, characters are written into a grid, whose rows and columns have the following constraints:
 * floor(sqrt(L)) ≤ rows ≤ columns ≤ ceil(sqrt(L))
 * 
 * Example:
 * Input: s = "haveaniceday"
 * Output: "hae and via ecy"
 * Explanation: L=12, sqrt(12)≈3.46, so 3≤rows≤columns≤4. Use 3x4 grid.
 * Grid: h a v e
 *       a n i c
 *       e d a y
 * Read columns: "hae and via ecy"
 * 
 * Constraints: 1 ≤ |s| ≤ 81
 */

public class _77_Encryption {
    public static String encryption(String s) {
        // Remove spaces
        s = s.replaceAll(" ", "");
        int L = s.length();
        
        if (L == 0) return "";
        
        // Calculate rows and columns
        int rows = (int) Math.floor(Math.sqrt(L));
        int cols = (int) Math.ceil(Math.sqrt(L));
        
        // Ensure rows * cols >= L
        if (rows * cols < L) {
            rows = cols;
        }
        
        StringBuilder result = new StringBuilder();
        
        // Read column by column
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                int index = row * cols + col;
                if (index < L) {
                    result.append(s.charAt(index));
                }
            }
            if (col < cols - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("Encryption of 'haveaniceday': " + encryption("haveaniceday"));
        System.out.println("Encryption of 'feedthedog': " + encryption("feedthedog"));
        System.out.println("Encryption of 'chillout': " + encryption("chillout"));
    }
}