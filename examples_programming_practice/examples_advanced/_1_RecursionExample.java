/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates recursive programming techniques:
 * 1. Basic recursion - Factorial and Fibonacci
 * 2. Tree traversal simulation using recursion
 * 3. Backtracking - N-Queens problem
 * 4. Divide and conquer - Merge sort
 * 5. Mathematical recursion - Tower of Hanoi
 * 6. String recursion - Generate all permutations
 */

import java.util.*;

public class _1_RecursionExample {
    public static void main(String[] args) {
        System.out.println("=== Recursion Examples ===");
        
        // 1. Basic recursion
        System.out.println("\n1. Basic Recursion:");
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Fibonacci of 8: " + fibonacci(8));
        
        // 2. Array operations
        System.out.println("\n2. Recursive Array Operations:");
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("Array sum: " + arraySum(arr, 0));
        System.out.println("Array max: " + arrayMax(arr, 0, arr[0]));
        
        // 3. String recursion
        System.out.println("\n3. String Recursion:");
        System.out.println("Reverse 'hello': " + reverseString("hello"));
        System.out.println("'madam' is palindrome: " + isPalindrome("madam", 0, 4));
        
        // 4. Permutations
        System.out.println("\n4. String Permutations:");
        List<String> permutations = new ArrayList<>();
        generatePermutations("ABC", "", permutations);
        System.out.println("Permutations of 'ABC': " + permutations);
        
        // 5. Tower of Hanoi
        System.out.println("\n5. Tower of Hanoi (3 disks):");
        towerOfHanoi(3, 'A', 'C', 'B');
        
        // 6. N-Queens (4x4 board)
        System.out.println("\n6. N-Queens Problem (4x4):");
        solveNQueens(4);
        
        // 7. Merge Sort
        System.out.println("\n7. Merge Sort:");
        int[] sortArray = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original: " + Arrays.toString(sortArray));
        mergeSort(sortArray, 0, sortArray.length - 1);
        System.out.println("Sorted: " + Arrays.toString(sortArray));
    }
    
    // Basic factorial using recursion
    public static long factorial(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }
        // Recursive case
        return n * factorial(n - 1);
    }
    
    // Fibonacci using recursion (inefficient but demonstrates concept)
    public static int fibonacci(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }
        // Recursive case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    // Sum of array elements using recursion
    public static int arraySum(int[] arr, int index) {
        // Base case
        if (index >= arr.length) {
            return 0;
        }
        // Recursive case
        return arr[index] + arraySum(arr, index + 1);
    }
    
    // Find maximum in array using recursion
    public static int arrayMax(int[] arr, int index, int currentMax) {
        // Base case
        if (index >= arr.length) {
            return currentMax;
        }
        // Recursive case
        int newMax = Math.max(currentMax, arr[index]);
        return arrayMax(arr, index + 1, newMax);
    }
    
    // Reverse string using recursion
    public static String reverseString(String str) {
        // Base case
        if (str.length() <= 1) {
            return str;
        }
        // Recursive case
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    
    // Check palindrome using recursion
    public static boolean isPalindrome(String str, int start, int end) {
        // Base case
        if (start >= end) {
            return true;
        }
        // Check current characters and recurse
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }
    
    // Generate all permutations of a string
    public static void generatePermutations(String str, String current, List<String> result) {
        // Base case - no more characters to permute
        if (str.length() == 0) {
            result.add(current);
            return;
        }
        
        // Try each character as the next character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            generatePermutations(remaining, current + ch, result);
        }
    }
    
    // Tower of Hanoi problem
    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        // Base case
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        // Move n-1 disks from source to auxiliary
        towerOfHanoi(n - 1, source, auxiliary, destination);
        
        // Move the largest disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        
        // Move n-1 disks from auxiliary to destination
        towerOfHanoi(n - 1, auxiliary, destination, source);
    }
    
    // N-Queens problem solver
    public static void solveNQueens(int n) {
        int[][] board = new int[n][n];
        if (solveNQueensUtil(board, 0, n)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists for " + n + " queens");
        }
    }
    
    // Utility function for N-Queens
    public static boolean solveNQueensUtil(int[][] board, int col, int n) {
        // Base case - all queens placed
        if (col >= n) {
            return true;
        }
        
        // Try placing queen in each row of current column
        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1; // Place queen
                
                // Recursively place queens in remaining columns
                if (solveNQueensUtil(board, col + 1, n)) {
                    return true;
                }
                
                // Backtrack - remove queen
                board[row][col] = 0;
            }
        }
        
        return false; // No solution found
    }
    
    // Check if queen placement is safe
    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        
        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        // Check lower diagonal on left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    // Print the board
    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "Q" : ".") + " ");
            }
            System.out.println();
        }
    }
    
    // Merge Sort implementation
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    // Merge function for merge sort
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        // Copy data to temporary arrays
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        
        // Merge the temporary arrays
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}