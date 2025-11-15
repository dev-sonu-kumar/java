/*
 * PROBLEM STATEMENT:
 * You are given a square map as a matrix of integer strings. Each cell of the map has a value denoting its depth.
 * We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth.
 * Two cells are adjacent if they have a common side, or edge.
 * 
 * Find all the cavities on the map and replace their depths with the uppercase character X.
 * 
 * Example:
 * Input: grid = ["989","191","111"]
 * Output: ["989","1X1","111"]
 * Explanation: The center cell (1,1) with value 9 is surrounded by cells with smaller values, so it's a cavity.
 * 
 * Constraints: 1 ≤ n ≤ 100
 */

public class _69_CavityMap {
    public static String[] cavityMap(String[] grid) {
        int n = grid.length;
        String[] result = new String[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = grid[i];
        }
        
        // Check each internal cell
        for (int i = 1; i < n - 1; i++) {
            StringBuilder row = new StringBuilder(result[i]);
            
            for (int j = 1; j < n - 1; j++) {
                char current = grid[i].charAt(j);
                char top = grid[i - 1].charAt(j);
                char bottom = grid[i + 1].charAt(j);
                char left = grid[i].charAt(j - 1);
                char right = grid[i].charAt(j + 1);
                
                // Check if current cell is a cavity
                if (current > top && current > bottom && 
                    current > left && current > right) {
                    row.setCharAt(j, 'X');
                }
            }
            
            result[i] = row.toString();
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String[] grid1 = {"989", "191", "111"};
        String[] result1 = cavityMap(grid1);
        System.out.println("Cavity map result:");
        for (String row : result1) {
            System.out.println(row);
        }
        
        String[] grid2 = {"1112", "1912", "1892", "1234"};
        String[] result2 = cavityMap(grid2);
        System.out.println("\nCavity map result 2:");
        for (String row : result2) {
            System.out.println(row);
        }
    }
}