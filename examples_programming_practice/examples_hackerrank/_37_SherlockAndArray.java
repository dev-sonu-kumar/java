/*
 * PROBLEM STATEMENT:
 * Watson gives Sherlock an array of integers. His challenge is to find an element of the array such that the sum of all elements to the left is equal to the sum of all elements to the right.
 * If no such element exists, return "NO". Otherwise, return "YES".
 * 
 * Example:
 * Input: arr = [1, 2, 3, 3]
 * Output: YES
 * Explanation: The element at index 2 (value 3) has left sum = 1+2 = 3 and right sum = 3.
 * 
 * Constraints: 1 ≤ T ≤ 10, 1 ≤ n ≤ 10^5, 1 ≤ arr[i] ≤ 2×10^4
 */

public class _37_SherlockAndArray {
    public static String balancedSums(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        int leftSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            
            if (leftSum == rightSum) {
                return "YES";
            }
            
            leftSum += arr[i];
        }
        
        return "NO";
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 3};
        System.out.println("Array [1,2,3,3] is balanced: " + balancedSums(arr1));
        
        int[] arr2 = {1, 2, 3};
        System.out.println("Array [1,2,3] is balanced: " + balancedSums(arr2));
        
        int[] arr3 = {1, 1, 4, 1, 1};
        System.out.println("Array [1,1,4,1,1] is balanced: " + balancedSums(arr3));
    }
}