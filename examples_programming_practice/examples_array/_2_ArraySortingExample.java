/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates various sorting algorithms:
 * 1. Bubble Sort - Simple comparison-based sorting
 * 2. Selection Sort - Find minimum and place at beginning
 * 3. Insertion Sort - Build sorted array one element at a time
 * 4. Binary Search - Search in sorted array (O(log n))
 * 5. Performance comparison of sorting algorithms
 */

import java.util.Arrays;

public class _2_ArraySortingExample {
    public static void main(String[] args) {
        System.out.println("=== Array Sorting Algorithms ===");
        
        // Test data
        int[] originalArray = {64, 34, 25, 12, 22, 11, 90, 5, 77, 30};
        System.out.println("Original array: " + Arrays.toString(originalArray));
        
        // 1. Bubble Sort
        System.out.println("\n1. Bubble Sort:");
        int[] bubbleArray = originalArray.clone();
        bubbleSort(bubbleArray);
        System.out.println("Sorted: " + Arrays.toString(bubbleArray));
        
        // 2. Selection Sort
        System.out.println("\n2. Selection Sort:");
        int[] selectionArray = originalArray.clone();
        selectionSort(selectionArray);
        System.out.println("Sorted: " + Arrays.toString(selectionArray));
        
        // 3. Insertion Sort
        System.out.println("\n3. Insertion Sort:");
        int[] insertionArray = originalArray.clone();
        insertionSort(insertionArray);
        System.out.println("Sorted: " + Arrays.toString(insertionArray));
        
        // 4. Binary Search
        System.out.println("\n4. Binary Search:");
        int target = 25;
        int index = binarySearch(bubbleArray, target);
        System.out.println("Element " + target + " found at index: " + index);
        
        // 5. Performance comparison
        System.out.println("\n5. Performance Comparison:");
        performanceComparison();
    }
    
    // Bubble Sort - O(n²) time complexity
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swapping occurred, array is sorted
            if (!swapped) break;
        }
    }
    
    // Selection Sort - O(n²) time complexity
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            // Find minimum element in remaining array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap minimum element with first element
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    
    // Insertion Sort - O(n²) worst case, O(n) best case
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    // Binary Search - O(log n) time complexity (requires sorted array)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Not found
    }
    
    // Performance comparison of sorting algorithms
    public static void performanceComparison() {
        int[] sizes = {100, 1000, 5000};
        
        for (int size : sizes) {
            System.out.println("\nArray size: " + size);
            
            // Generate random array
            int[] testArray = generateRandomArray(size);
            
            // Test Bubble Sort
            int[] bubbleArray = testArray.clone();
            long startTime = System.nanoTime();
            bubbleSort(bubbleArray);
            long bubbleTime = System.nanoTime() - startTime;
            
            // Test Selection Sort
            int[] selectionArray = testArray.clone();
            startTime = System.nanoTime();
            selectionSort(selectionArray);
            long selectionTime = System.nanoTime() - startTime;
            
            // Test Insertion Sort
            int[] insertionArray = testArray.clone();
            startTime = System.nanoTime();
            insertionSort(insertionArray);
            long insertionTime = System.nanoTime() - startTime;
            
            System.out.println("Bubble Sort: " + (bubbleTime / 1_000_000) + " ms");
            System.out.println("Selection Sort: " + (selectionTime / 1_000_000) + " ms");
            System.out.println("Insertion Sort: " + (insertionTime / 1_000_000) + " ms");
        }
    }
    
    // Generate random array for testing
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }
}