/*
 * PROBLEM STATEMENT:
 * Lisa just got a new math workbook. A workbook contains exercise problems, grouped into chapters.
 * Lisa believes a problem to be special if its index (within a chapter) is the same as the page number where it's located.
 * The format of Lisa's book is as follows:
 * - There are n chapters, and each chapter has arr[i] problems.
 * - Each page can hold up to k problems.
 * - Each new chapter starts on a new page, so a chapter may leave a page partially empty.
 * - A page cannot contain problems from more than one chapter.
 * - The page number indexing starts at 1.
 * 
 * Given the details for Lisa's workbook, can you count its number of special problems?
 * 
 * Example:
 * Input: n=2, k=3, arr=[4,2]
 * Output: 1
 * Explanation: Chapter 1 has 4 problems on pages 1,2. Chapter 2 has 2 problems on page 3. Special problem: problem 1 on page 1.
 * 
 * Constraints: 1 ≤ n, k ≤ 100, 1 ≤ arr[i] ≤ 1000
 */

public class _66_LisasWorkbook {
    public static int workbook(int n, int k, int[] arr) {
        int specialProblems = 0;
        int currentPage = 1;
        
        for (int chapter = 0; chapter < n; chapter++) {
            int problems = arr[chapter];
            
            for (int problem = 1; problem <= problems; problem++) {
                // Check if current problem number equals current page number
                if (problem == currentPage) {
                    specialProblems++;
                }
                
                // Move to next page if current page is full
                if (problem % k == 0 || problem == problems) {
                    currentPage++;
                }
            }
        }
        
        return specialProblems;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {4, 2};
        System.out.println("Special problems for n=2, k=3, arr=[4,2]: " + workbook(2, 3, arr1));
        
        int[] arr2 = {3, 8, 15, 11, 14, 1, 9, 2, 24, 31};
        System.out.println("Special problems for complex case: " + workbook(10, 5, arr2));
    }
}