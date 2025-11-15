/*
 * PROBLEM STATEMENT:
 * Consider a matrix where each cell contains either a 0 or a 1 and any cell containing a 1 is called a filled cell.
 * Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally.
 * A region is a set of one or more filled cells such that each filled cell is connected to at least one other cell in the region.
 * Find the size of the largest region.
 * 
 * Example:
 * Input: matrix = [[1,1,0,0],[0,1,1,0],[0,0,1,0],[1,0,0,0]]
 * Output: 5
 * 
 * Constraints: 1 ≤ n, m ≤ 10
 */

public class _39_ConnectedCellsInAGrid {
    public static int connectedCell(int[][] matrix) {
        int maxRegion = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    int regionSize = dfs(matrix, i, j, rows, cols);
                    maxRegion = Math.max(maxRegion, regionSize);
                }
            }
        }
        
        return maxRegion;
    }
    
    private static int dfs(int[][] matrix, int row, int col, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] == 0) {
            return 0;
        }
        
        matrix[row][col] = 0; // Mark as visited
        int size = 1;
        
        // Check all 8 directions
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < 8; i++) {
            size += dfs(matrix, row + dx[i], col + dy[i], rows, cols);
        }
        
        return size;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {1, 0, 0, 0}
        };
        
        System.out.println("Largest connected region: " + connectedCell(matrix));
    }
}