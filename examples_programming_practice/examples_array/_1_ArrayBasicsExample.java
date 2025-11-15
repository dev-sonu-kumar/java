/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates fundamental array operations:
 * 1. Array initialization and traversal
 * 2. Find maximum and minimum elements
 * 3. Calculate sum and average
 * 4. Search for an element (linear search)
 * 5. Reverse an array
 * 6. Check if array is sorted
 */

import java.util.Arrays;

public class _1_ArrayBasicsExample {
    public static void main(String[] args) {
        System.out.println("=== Array Basics Operations ===");
        
        // Initialize test arrays
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {5, 4, 3, 2, 1};
        
        System.out.println("Original array: " + Arrays.toString(arr1));
        
        // 1. Array traversal
        System.out.println("\n1. Array Traversal:");
        traverseArray(arr1);
        
        // 2. Find max and min
        System.out.println("\n2. Max and Min:");
        System.out.println("Maximum: " + findMax(arr1));
        System.out.println("Minimum: " + findMin(arr1));
        
        // 3. Sum and average
        System.out.println("\n3. Sum and Average:");
        int sum = calculateSum(arr1);
        double average = calculateAverage(arr1);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        
        // 4. Linear search
        System.out.println("\n4. Linear Search:");
        int target = 25;
        int index = linearSearch(arr1, target);
        System.out.println("Element " + target + " found at index: " + index);
        
        // 5. Reverse array
        System.out.println("\n5. Array Reversal:");
        int[] reversed = reverseArray(arr1.clone());
        System.out.println("Reversed: " + Arrays.toString(reversed));
        
        // 6. Check if sorted
        System.out.println("\n6. Sorted Check:");
        System.out.println("arr1 is sorted: " + isSorted(arr1));
        System.out.println("arr2 is sorted: " + isSorted(arr2));
        System.out.println("arr3 is sorted (desc): " + isSortedDescending(arr3));
    }
    
    // Traverse and print array elements
    public static void traverseArray(int[] arr) {
        System.out.print("Elements: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Find maximum element
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    // Find minimum element
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    // Calculate sum of all elements
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    
    // Calculate average
    public static double calculateAverage(int[] arr) {
        return (double) calculateSum(arr) / arr.length;
    }
    
    // Linear search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Not found
    }
    
    // Reverse array in-place
    public static int[] reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }
    
    // Check if array is sorted in ascending order
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    // Check if array is sorted in descending order
    public static boolean isSortedDescending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}