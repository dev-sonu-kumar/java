# Basic Programming Guide 🚀

## 📚 Learning Path (Recommended Order)

**Start with fundamentals:**
1. **Number Operations** - Mathematical computations and algorithms
2. **Pattern Printing** - Loop control and logical thinking
3. **Input/Output Operations** - User interaction and data types
4. **Conditional Logic** - Decision making and control flow
5. **Basic String Operations** - Text manipulation and character handling

---

## 1. Number Operations

### Program Objectives
- Master basic mathematical operations in programming
- Understand algorithm efficiency and optimization
- Learn fundamental programming constructs

### Key Concepts Covered
- **Even/Odd Detection** - Modulo operator usage
- **Factorial Calculation** - Iterative approach
- **Prime Number Detection** - Optimized algorithm
- **Fibonacci Series** - Sequential number generation
- **GCD/LCM Calculation** - Euclidean algorithm

### Time Complexity Analysis
| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Even/Odd Check | O(1) | O(1) |
| Factorial | O(n) | O(1) |
| Prime Check | O(√n) | O(1) |
| Fibonacci (n terms) | O(n) | O(1) |
| GCD (Euclidean) | O(log min(a,b)) | O(1) |

### Key Algorithms
```java
// Optimized Prime Check
public static boolean isPrime(int num) {
    if (num <= 1) return false;
    if (num <= 3) return true;
    if (num % 2 == 0 || num % 3 == 0) return false;
    
    for (int i = 5; i * i <= num; i += 6) {
        if (num % i == 0 || num % (i + 2) == 0) {
            return false;
        }
    }
    return true;
}
```

### Interview Questions
- Write a program to check if a number is prime
- Find GCD of two numbers without using built-in functions
- Generate Fibonacci series up to n terms
- Check if a number is perfect square

---

## 2. Pattern Printing

### Program Objectives
- Develop logical thinking and problem-solving skills
- Master nested loop structures
- Understand space and character manipulation

### Key Patterns Covered
- **Right Triangle** - Basic incremental pattern
- **Inverted Triangle** - Decremental pattern
- **Pyramid** - Centered pattern with spaces
- **Diamond** - Complex symmetrical pattern
- **Number Patterns** - Sequential numbering
- **Floyd's Triangle** - Continuous numbering

### Pattern Analysis
| Pattern Type | Difficulty | Loops Required | Key Concept |
|--------------|------------|----------------|-------------|
| Right Triangle | Easy | 2 nested | Basic increment |
| Inverted Triangle | Easy | 2 nested | Basic decrement |
| Pyramid | Medium | 2 nested | Space calculation |
| Diamond | Hard | 4 nested | Symmetry logic |
| Number Pattern | Medium | 2 nested | Counter management |
| Floyd's Triangle | Medium | 2 nested | Continuous sequence |

### Pattern Logic
```java
// Pyramid Pattern Logic
for (int i = 1; i <= rows; i++) {
    // Print spaces: (rows - i) spaces
    for (int j = 1; j <= rows - i; j++) {
        System.out.print(" ");
    }
    // Print stars: (2*i - 1) stars
    for (int j = 1; j <= 2 * i - 1; j++) {
        System.out.print("*");
    }
    System.out.println();
}
```

### Interview Questions
- Print a diamond pattern of given size
- Create a number pyramid
- Print Pascal's triangle
- Generate a spiral pattern

---

## 3. Input/Output Operations

### Program Objectives
- Master user input handling with Scanner class
- Understand different data types and conversions
- Learn formatted output techniques
- Implement input validation strategies

### Key Concepts Covered
- **Scanner Usage** - Reading different data types
- **Type Conversions** - String to number parsing
- **Formatted Output** - printf and String.format
- **Input Validation** - Error handling and range checking
- **Interactive Programs** - Calculator and menu systems

### Data Type Operations
| Data Type | Input Method | Conversion | Example |
|-----------|-------------|------------|----------|
| int | nextInt() | Integer.parseInt() | scanner.nextInt() |
| double | nextDouble() | Double.parseDouble() | scanner.nextDouble() |
| String | nextLine() | String.valueOf() | scanner.nextLine() |
| boolean | nextBoolean() | Boolean.parseBoolean() | scanner.nextBoolean() |

### Input Validation Pattern
```java
public static int getValidNumber(Scanner scanner, String prompt, int min, int max) {
    int number;
    do {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input! " + prompt);
            scanner.next();
        }
        number = scanner.nextInt();
    } while (number < min || number > max);
    return number;
}
```

### Interview Questions
- Create a menu-driven calculator
- Implement input validation for different data types
- Build an interactive quiz system
- Handle multiple input formats gracefully

---

## 4. Conditional Logic & Control Flow

### Program Objectives
- Master decision-making constructs in programming
- Understand nested conditions and complex logic
- Learn switch statement usage and best practices
- Implement menu-driven program structures

### Key Concepts Covered
- **If-Else Statements** - Basic and nested conditions
- **Switch Statements** - Multi-way branching
- **Ternary Operator** - Compact conditional expressions
- **Logical Operators** - AND, OR, NOT operations
- **Menu Systems** - User-driven program flow

### Conditional Constructs
| Construct | Use Case | Syntax | Best For |
|-----------|----------|--------|----------|
| if-else | Binary decisions | if (condition) {...} | Simple conditions |
| else-if | Multiple conditions | else if (condition) {...} | Range checking |
| switch | Discrete values | switch (variable) {...} | Menu systems |
| ternary | Compact conditions | condition ? true : false | Simple assignments |

### Switch Statement Best Practices
```java
switch (choice) {
    case 1: case 2: case 3:  // Grouped cases
        handleWeekday();
        break;
    case 6: case 7:
        handleWeekend();
        break;
    default:
        handleInvalidInput();
}
```

### Interview Questions
- Implement a grade calculator with multiple conditions
- Create a day-of-week calculator
- Build a number classification system
- Design a menu-driven application

---

## 5. Basic String Operations

### Program Objectives
- Master fundamental string manipulation techniques
- Understand character-level operations and ASCII values
- Learn string comparison and searching methods
- Implement basic string algorithms

### Key Concepts Covered
- **String Creation** - Literal vs constructor
- **String Methods** - length, charAt, substring
- **String Comparison** - equals, compareTo, contains
- **Case Conversion** - toUpperCase, toLowerCase
- **String Algorithms** - palindrome, reverse, frequency

### Essential String Methods
| Method | Purpose | Time Complexity | Example |
|--------|---------|----------------|----------|
| length() | Get string length | O(1) | str.length() |
| charAt(i) | Get character at index | O(1) | str.charAt(0) |
| substring(i,j) | Extract substring | O(n) | str.substring(0,5) |
| indexOf(ch) | Find character position | O(n) | str.indexOf('a') |
| equals(str) | Compare strings | O(n) | str1.equals(str2) |

### String Algorithm Patterns
```java
// Palindrome Check (Two Pointers)
public static boolean isPalindrome(String str) {
    int left = 0, right = str.length() - 1;
    while (left < right) {
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        left++; right--;
    }
    return true;
}
```

### Interview Questions
- Check if a string is palindrome
- Count character frequency in a string
- Reverse a string without built-in methods
- Find the longest word in a sentence

---

## Problem-Solving Approach

### Step-by-Step Method
1. **Understand the Problem** - Read requirements carefully
2. **Identify Patterns** - Look for mathematical relationships
3. **Plan the Algorithm** - Break down into smaller steps
4. **Code Implementation** - Write clean, readable code
5. **Test with Examples** - Verify with different inputs
6. **Optimize if Needed** - Improve time/space complexity

### Common Mistakes to Avoid
- **Off-by-one errors** in loop conditions
- **Integer overflow** in factorial calculations
- **Inefficient algorithms** for prime checking
- **Incorrect space calculations** in patterns
- **Not handling edge cases** (negative numbers, zero)

### Best Practices
- **Use meaningful variable names**
- **Add comments for complex logic**
- **Handle edge cases properly**
- **Optimize for readability first, then performance**
- **Test with boundary values**

---

## Code Examples Summary

**📁 Study in this sequence:**
1. `_1_NumberOperationsExample.java` - **START HERE** - Mathematical operations
2. `_2_PatternPrintingExample.java` - Loop control and pattern logic
3. `_3_InputOutputExample.java` - User input and data handling
4. `_4_ConditionalLogicExample.java` - Decision making and control flow
5. `_5_BasicStringOperationsExample.java` - Text manipulation and algorithms

---

## Practice Problems

### Beginner Level
1. Check if a number is Armstrong number
2. Find sum of digits of a number
3. Print multiplication table
4. Create a simple calculator with input validation
5. Build a student grade management system

### Intermediate Level
1. Create an interactive menu-driven banking system
2. Implement string manipulation utilities
3. Build a word frequency analyzer
4. Design a pattern generator with user input
5. Create a number guessing game with hints

### Advanced Level
1. Build a text-based adventure game
2. Implement a simple expression evaluator
3. Create a file-based data management system
4. Design a multi-level menu system
5. Build a comprehensive string processing toolkit

---

## Interview Preparation Tips

### Common Topics
- **Mathematical algorithms** (GCD, LCM, Prime)
- **Pattern recognition** and implementation
- **Input/Output handling** and validation
- **Conditional logic** and decision trees
- **String manipulation** and algorithms
- **Loop optimization** techniques
- **Edge case handling**
- **Time complexity analysis**

### Practice Strategy
1. **Start with simple problems** and gradually increase complexity
2. **Focus on logic building** rather than memorizing solutions
3. **Practice different pattern types** to improve spatial thinking
4. **Time yourself** to improve problem-solving speed
5. **Explain your approach** clearly during interviews

This guide provides a solid foundation for basic programming concepts essential for technical interviews and competitive programming! 🎯