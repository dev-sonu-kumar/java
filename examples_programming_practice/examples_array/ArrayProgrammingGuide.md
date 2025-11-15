# Array Programming Guide 🚀

## 📚 Learning Path (Recommended Order)

**Master array fundamentals:**
1. **Array Basics** - Fundamental operations and traversal
2. **Array Sorting** - Sorting algorithms and search techniques

---

## 1. Array Basics

### Program Objectives
- Master fundamental array operations
- Understand array traversal techniques
- Learn basic search algorithms
- Practice array manipulation methods

### Key Operations Covered
- **Array Initialization** - Different ways to create arrays
- **Traversal Techniques** - Forward and backward iteration
- **Min/Max Finding** - Linear search for extremes
- **Sum/Average Calculation** - Aggregate operations
- **Linear Search** - Sequential element finding
- **Array Reversal** - In-place manipulation
- **Sorted Check** - Order verification

### Time Complexity Analysis
| Operation | Time Complexity | Space Complexity | Notes |
|-----------|----------------|------------------|-------|
| Traversal | O(n) | O(1) | Single pass through array |
| Find Min/Max | O(n) | O(1) | Linear scan required |
| Sum/Average | O(n) | O(1) | Single pass calculation |
| Linear Search | O(n) | O(1) | Worst case: element not found |
| Array Reversal | O(n/2) | O(1) | In-place swapping |
| Sorted Check | O(n) | O(1) | Early termination possible |

### Key Algorithms
```java
// Efficient Min/Max in single pass
public static int[] findMinMax(int[] arr) {
    int min = arr[0], max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] < min) min = arr[i];
        if (arr[i] > max) max = arr[i];
    }
    return new int[]{min, max};
}

// In-place array reversal
public static void reverseArray(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}
```

### Interview Questions
- Find the second largest element in an array
- Rotate an array by k positions
- Find missing number in array of 1 to n
- Remove duplicates from sorted array
- Merge two sorted arrays

---

## 2. Array Sorting

### Program Objectives
- Understand different sorting algorithms
- Compare algorithm performance
- Master binary search technique
- Learn algorithm optimization

### Sorting Algorithms Covered
- **Bubble Sort** - Simple comparison-based sorting
- **Selection Sort** - Find minimum and swap
- **Insertion Sort** - Build sorted array incrementally
- **Binary Search** - Efficient search in sorted array

### Algorithm Comparison
| Algorithm | Time Complexity | Space Complexity | Stability | Best Use Case |
|-----------|----------------|------------------|-----------|---------------|
| Bubble Sort | O(n²) | O(1) | Stable | Educational purposes |
| Selection Sort | O(n²) | O(1) | Unstable | Small datasets |
| Insertion Sort | O(n²) | O(1) | Stable | Nearly sorted data |
| Binary Search | O(log n) | O(1) | N/A | Sorted array search |

### Performance Characteristics
```java
// Bubble Sort - Optimized with early termination
public static void bubbleSort(int[] arr) {
    boolean swapped;
    for (int i = 0; i < arr.length - 1; i++) {
        swapped = false;
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
                swapped = true;
            }
        }
        if (!swapped) break; // Array is sorted
    }
}

// Binary Search - Iterative approach
public static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```

### When to Use Each Algorithm
- **Bubble Sort**: Educational purposes, very small datasets
- **Selection Sort**: Memory-constrained environments
- **Insertion Sort**: Small or nearly sorted datasets
- **Binary Search**: Any search in sorted data

### Interview Questions
- Implement quicksort algorithm
- Find kth largest element in array
- Search in rotated sorted array
- Find peak element in array
- Implement merge sort

---

## Advanced Array Concepts

### Two-Pointer Technique
```java
// Remove duplicates from sorted array
public static int removeDuplicates(int[] arr) {
    if (arr.length == 0) return 0;
    
    int writeIndex = 1;
    for (int readIndex = 1; readIndex < arr.length; readIndex++) {
        if (arr[readIndex] != arr[readIndex - 1]) {
            arr[writeIndex] = arr[readIndex];
            writeIndex++;
        }
    }
    return writeIndex;
}
```

### Sliding Window Technique
```java
// Find maximum sum of k consecutive elements
public static int maxSumSubarray(int[] arr, int k) {
    int maxSum = 0, windowSum = 0;
    
    // Calculate sum of first window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }
    maxSum = windowSum;
    
    // Slide the window
    for (int i = k; i < arr.length; i++) {
        windowSum = windowSum - arr[i - k] + arr[i];
        maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
}
```

---

## Problem-Solving Patterns

### Common Array Problems
1. **Searching Problems** - Linear search, binary search variants
2. **Sorting Problems** - Custom sorting, partial sorting
3. **Two-Pointer Problems** - Pair finding, duplicate removal
4. **Sliding Window** - Subarray problems, optimization
5. **Prefix Sum** - Range queries, cumulative operations

### Problem-Solving Approach
1. **Understand the constraints** - Array size, element range
2. **Identify the pattern** - Search, sort, two-pointer, etc.
3. **Choose optimal algorithm** - Consider time/space trade-offs
4. **Handle edge cases** - Empty array, single element
5. **Optimize if needed** - Early termination, space optimization

---

## Code Examples Summary

**📁 Study in this sequence:**
1. `_1_ArrayBasicsExample.java` - **START HERE** - Fundamental operations
2. `_2_ArraySortingExample.java` - Sorting algorithms and binary search

---

## Practice Problems

### Beginner Level
1. Find sum of all elements in array
2. Count even and odd numbers
3. Find largest and smallest elements
4. Check if array is palindrome
5. Copy array elements to another array

### Intermediate Level
1. Find second largest element
2. Rotate array left/right by k positions
3. Find missing number in sequence
4. Remove duplicates from array
5. Find intersection of two arrays

### Advanced Level
1. Find majority element (Boyer-Moore)
2. Maximum subarray sum (Kadane's algorithm)
3. Trapping rainwater problem
4. Find all pairs with given sum
5. Longest increasing subsequence

---

## Interview Preparation Strategy

### Must-Know Algorithms
- **Linear Search** - O(n) search technique
- **Binary Search** - O(log n) search in sorted array
- **Two-Pointer Technique** - O(n) for pair problems
- **Sliding Window** - O(n) for subarray problems
- **Sorting Algorithms** - At least one O(n log n) algorithm

### Common Mistakes
- **Array bounds** - Index out of bounds errors
- **Integer overflow** - Sum calculations with large numbers
- **Null checks** - Handling null or empty arrays
- **Sorting assumption** - Assuming array is sorted
- **Modifying during iteration** - Concurrent modification issues

### Optimization Tips
- **Early termination** - Break loops when possible
- **Space-time trade-offs** - Use extra space for better time
- **In-place operations** - Modify array without extra space
- **Preprocessing** - Sort or precompute for multiple queries
- **Choose right data structure** - Array vs ArrayList vs other collections

This comprehensive guide covers all essential array programming concepts needed for technical interviews and competitive programming! 🎯