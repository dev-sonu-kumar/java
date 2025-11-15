# Advanced Programming Guide 🚀

## 📚 Learning Path (Recommended Order)

**Master advanced concepts:**
1. **Recursion** - Recursive algorithms and backtracking
2. **Data Structures** - Implementation of fundamental data structures

---

## 1. Recursion & Backtracking

### Program Objectives
- Master recursive thinking and problem decomposition
- Understand backtracking algorithms and their applications
- Learn divide-and-conquer strategies
- Practice complex algorithmic problem solving

### Key Concepts Covered
- **Basic Recursion** - Factorial, Fibonacci, mathematical functions
- **Array Recursion** - Sum, max finding, searching
- **String Recursion** - Reversal, palindrome checking
- **Permutation Generation** - All possible arrangements
- **Backtracking** - N-Queens problem solving
- **Divide & Conquer** - Merge sort implementation
- **Mathematical Recursion** - Tower of Hanoi

### Recursion Complexity Analysis
| Algorithm | Time Complexity | Space Complexity | Recurrence Relation |
|-----------|----------------|------------------|-------------------|
| Factorial | O(n) | O(n) | T(n) = T(n-1) + O(1) |
| Fibonacci (naive) | O(2ⁿ) | O(n) | T(n) = T(n-1) + T(n-2) |
| Array Sum | O(n) | O(n) | T(n) = T(n-1) + O(1) |
| Permutations | O(n!) | O(n) | T(n) = n × T(n-1) |
| N-Queens | O(N!) | O(N) | Exponential with pruning |
| Merge Sort | O(n log n) | O(n) | T(n) = 2T(n/2) + O(n) |
| Tower of Hanoi | O(2ⁿ) | O(n) | T(n) = 2T(n-1) + O(1) |

### Recursion Patterns
```java
// Basic Recursion Template
public static ReturnType recursiveFunction(parameters) {
    // Base case - stopping condition
    if (baseCondition) {
        return baseValue;
    }
    
    // Recursive case - problem decomposition
    // Process current level
    // Make recursive call with modified parameters
    return combineResults(
        processCurrentLevel(),
        recursiveFunction(modifiedParameters)
    );
}

// Backtracking Template
public static void backtrack(state, choices) {
    if (isComplete(state)) {
        processResult(state);
        return;
    }
    
    for (choice : choices) {
        if (isValid(choice, state)) {
            makeChoice(choice, state);
            backtrack(state, remainingChoices);
            undoChoice(choice, state); // Backtrack
        }
    }
}
```

### Advanced Recursion Techniques
```java
// Memoization for optimization
private static Map<Integer, Long> memo = new HashMap<>();

public static long fibonacciMemo(int n) {
    if (n <= 1) return n;
    
    if (memo.containsKey(n)) {
        return memo.get(n);
    }
    
    long result = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
    memo.put(n, result);
    return result;
}

// Tail recursion optimization
public static long factorialTail(int n, long accumulator) {
    if (n <= 1) return accumulator;
    return factorialTail(n - 1, n * accumulator);
}
```

### Backtracking Applications
- **N-Queens Problem** - Place N queens on N×N chessboard
- **Sudoku Solver** - Fill 9×9 grid with constraints
- **Maze Solving** - Find path from start to end
- **Subset Generation** - All possible combinations
- **Graph Coloring** - Color vertices with minimum colors

### Interview Questions
- Implement quicksort using recursion
- Generate all valid parentheses combinations
- Solve word search in 2D grid
- Find all paths in a maze
- Implement expression evaluation recursively

---

## 2. Data Structures Implementation

### Program Objectives
- Implement fundamental data structures from scratch
- Understand internal workings and trade-offs
- Master pointer manipulation and memory management
- Learn algorithm design for data structure operations

### Data Structures Covered
- **Stack** - LIFO operations with array implementation
- **Queue** - FIFO operations with circular array
- **Linked List** - Dynamic memory allocation and pointer manipulation
- **Binary Search Tree** - Hierarchical data organization
- **Hash Table** - Key-value storage with collision handling
- **Graph** - Vertex and edge representation with traversals

### Implementation Complexity
| Data Structure | Operation | Time Complexity | Space Complexity |
|----------------|-----------|----------------|------------------|
| Stack | Push/Pop/Peek | O(1) | O(n) |
| Queue | Enqueue/Dequeue | O(1) | O(n) |
| Linked List | Insert/Delete | O(1) at head, O(n) at position | O(n) |
| BST | Search/Insert/Delete | O(log n) avg, O(n) worst | O(n) |
| Hash Table | Get/Put/Remove | O(1) avg, O(n) worst | O(n) |
| Graph | BFS/DFS | O(V + E) | O(V) |

### Key Implementation Details
```java
// Generic Stack with dynamic resizing
public class DynamicStack<T> {
    private T[] array;
    private int top;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public DynamicStack(int initialCapacity) {
        this.capacity = initialCapacity;
        this.array = (T[]) new Object[capacity];
        this.top = -1;
    }
    
    public void push(T item) {
        if (top == capacity - 1) {
            resize();
        }
        array[++top] = item;
    }
    
    private void resize() {
        capacity *= 2;
        array = Arrays.copyOf(array, capacity);
    }
}

// Self-balancing BST operations
public class AVLTree {
    private Node root;
    
    private class Node {
        int data, height;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }
    
    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }
    
    private int getBalance(Node node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }
    
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        
        x.right = y;
        y.left = T2;
        
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        
        return x;
    }
}
```

### Advanced Data Structure Concepts
- **Load Factor Management** in hash tables
- **Collision Resolution** strategies (chaining vs open addressing)
- **Tree Balancing** techniques (AVL, Red-Black trees)
- **Graph Representations** (adjacency list vs matrix)
- **Memory Pool Management** for efficient allocation

---

## Algorithm Design Patterns

### Divide and Conquer
```java
// Generic divide and conquer template
public static Result divideAndConquer(Problem problem) {
    if (problem.isBaseCase()) {
        return problem.solveDirectly();
    }
    
    List<SubProblem> subproblems = problem.divide();
    List<Result> subresults = new ArrayList<>();
    
    for (SubProblem subproblem : subproblems) {
        subresults.add(divideAndConquer(subproblem));
    }
    
    return combine(subresults);
}
```

### Dynamic Programming
```java
// Bottom-up DP approach
public static int longestIncreasingSubsequence(int[] arr) {
    int n = arr.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
    
    return Arrays.stream(dp).max().orElse(0);
}
```

### Greedy Algorithms
```java
// Activity selection problem
public static List<Activity> selectActivities(List<Activity> activities) {
    activities.sort((a, b) -> Integer.compare(a.endTime, b.endTime));
    
    List<Activity> selected = new ArrayList<>();
    int lastEndTime = 0;
    
    for (Activity activity : activities) {
        if (activity.startTime >= lastEndTime) {
            selected.add(activity);
            lastEndTime = activity.endTime;
        }
    }
    
    return selected;
}
```

---

## Problem-Solving Strategies

### Recursive Problem Decomposition
1. **Identify base cases** - Simplest instances that can be solved directly
2. **Define recursive relation** - How to break down larger problems
3. **Ensure progress** - Each recursive call moves toward base case
4. **Combine results** - How to merge solutions from subproblems
5. **Optimize if needed** - Memoization, tail recursion, iterative conversion

### Data Structure Selection Criteria
1. **Access Patterns** - Random vs sequential access requirements
2. **Operation Frequency** - Which operations are most common
3. **Memory Constraints** - Space vs time trade-offs
4. **Concurrency Requirements** - Thread-safety considerations
5. **Performance Requirements** - Worst-case vs average-case guarantees

---

## Code Examples Summary

**📁 Study in this sequence:**
1. `_1_RecursionExample.java` - **START HERE** - Recursive algorithms and backtracking
2. `_2_DataStructuresExample.java` - Data structure implementations

---

## Practice Problems

### Recursion Problems
#### Beginner Level
1. Calculate power of a number recursively
2. Find sum of digits using recursion
3. Print numbers from 1 to n recursively
4. Check if array is sorted recursively
5. Find maximum element in array recursively

#### Intermediate Level
1. Generate all subsets of a set
2. Solve Tower of Hanoi for n disks
3. Find all permutations of a string
4. Implement binary search recursively
5. Calculate nth Catalan number

#### Advanced Level
1. Solve N-Queens problem for any N
2. Generate all valid Sudoku solutions
3. Find shortest path in maze
4. Implement expression tree evaluation
5. Solve knapsack problem recursively

### Data Structure Problems
#### Implementation Challenges
1. Implement stack using two queues
2. Design LRU cache using doubly linked list
3. Implement trie for word storage
4. Design min-heap with decrease-key operation
5. Implement disjoint set with path compression

#### Algorithm Integration
1. Implement Dijkstra's algorithm using priority queue
2. Design autocomplete system using trie
3. Implement LFU cache with optimal time complexity
4. Design data structure for range minimum queries
5. Implement persistent data structures

---

## Interview Preparation Strategy

### Core Concepts to Master
- **Recursion vs Iteration** trade-offs
- **Time/Space complexity** analysis
- **Data structure selection** criteria
- **Algorithm optimization** techniques
- **Memory management** considerations

### Common Interview Topics
- **Tree traversals** (inorder, preorder, postorder)
- **Graph algorithms** (BFS, DFS, shortest path)
- **Dynamic programming** with recursion
- **Backtracking** problem solving
- **Custom data structure** design

### Problem-Solving Tips
1. **Start with brute force** - Get working solution first
2. **Identify patterns** - Look for standard algorithmic approaches
3. **Optimize step by step** - Improve time/space complexity gradually
4. **Test edge cases** - Empty inputs, single elements, large inputs
5. **Explain trade-offs** - Discuss alternative approaches and their pros/cons

This advanced guide provides the foundation for tackling complex algorithmic problems and system design challenges in technical interviews! 🎯