# Java Basics Guide 🚀

## 📚 Learning Path (Recommended Order)

**Master Java fundamentals step by step:**
1. **Hello World** - Program structure and main method
2. **Command Line Arguments** - Program input handling
3. **Data Types** - Variables and primitive types
4. **Operators** - All operator types and usage
5. **User Input** - Scanner class and input methods
6. **For Loop** - Iteration and counting
7. **While Loop** - Condition-based iteration
8. **Do-While Loop** - Execute-first loops
9. **If-Else** - Conditional logic and decision making
10. **Switch Case** - Multi-way branching

---

## 1. Hello World Program

### Program Objectives
- Understand basic Java program structure
- Learn about main method and its components
- Master the entry point of Java applications

### Key Concepts Covered
- **Class Declaration** - `public class ClassName`
- **Main Method** - `public static void main(String[] args)`
- **Output Statement** - `System.out.println()`
- **Method Modifiers** - public, static, void

### Main Method Breakdown
```java
public static void main(String[] args)
//  ↓      ↓     ↓         ↓
// public: Anyone (JVM) can call this method
// static: No need to create object to run it
// void:   This method doesn't return anything
// main:   Starting point of any Java program
```

### Interview Questions
- Explain each component of the main method signature
- What happens if main method is not static?
- Can we have multiple main methods in a class?

---

## 2. Command Line Arguments

### Program Objectives
- Handle command-line input in Java programs
- Understand String array parameter in main method
- Process and validate command-line arguments

### Key Concepts Covered
- **args[] Array** - Command-line parameter storage
- **Array Length** - `args.length` property
- **Array Iteration** - Processing all arguments
- **Argument Validation** - Checking for required inputs

### Usage Pattern
```java
// Run: java _2_CommandLine arg1 arg2 arg3
for (int i = 0; i < args.length; i++) {
    System.out.println("args" + i + " " + args[i]);
}
```

### Interview Questions
- How to pass arguments to a Java program?
- What is the data type of command-line arguments?
- How to handle missing command-line arguments?

---

## 3. Data Types

### Program Objectives
- Master Java's primitive data types
- Understand variable declaration and initialization
- Learn type characteristics and memory usage

### Primitive Data Types
| Type | Size | Range | Default | Example |
|------|------|-------|---------|---------|
| int | 4 bytes | -2³¹ to 2³¹-1 | 0 | `int num = 123;` |
| double | 8 bytes | ±4.9e-324 to ±1.8e308 | 0.0 | `double pi = 3.14;` |
| char | 2 bytes | 0 to 65,535 | '\u0000' | `char grade = 'A';` |
| boolean | 1 bit | true/false | false | `boolean flag = true;` |

### Reference Types
- **String** - Text data (class, not primitive)
- **Arrays** - Collection of same-type elements
- **Objects** - Instances of classes

### Best Practices
```java
// Good naming conventions
int studentAge = 20;        // camelCase
final double PI = 3.14159;  // Constants in UPPER_CASE
String firstName = "John";  // Descriptive names
```

### Interview Questions
- Difference between primitive and reference types
- Memory allocation for different data types
- Default values of primitive types

---

## 4. All Operators

### Program Objectives
- Master all operator categories in Java
- Understand operator precedence and associativity
- Apply operators in real-world scenarios

### Operator Categories

#### Arithmetic Operators
| Operator | Name | Example | Result |
|----------|------|---------|--------|
| + | Addition | 10 + 3 | 13 |
| - | Subtraction | 10 - 3 | 7 |
| * | Multiplication | 10 * 3 | 30 |
| / | Division | 10 / 3 | 3 |
| % | Modulus | 10 % 3 | 1 |

#### Relational Operators
| Operator | Name | Example | Result |
|----------|------|---------|--------|
| == | Equal to | 10 == 3 | false |
| != | Not equal | 10 != 3 | true |
| > | Greater than | 10 > 3 | true |
| < | Less than | 10 < 3 | false |
| >= | Greater or equal | 10 >= 3 | true |
| <= | Less or equal | 10 <= 3 | false |

#### Logical Operators
| Operator | Name | Example | Result |
|----------|------|---------|--------|
| && | Logical AND | true && false | false |
| \|\| | Logical OR | true \|\| false | true |
| ! | Logical NOT | !true | false |

#### Assignment Operators
| Operator | Example | Equivalent |
|----------|---------|------------|
| += | a += 3 | a = a + 3 |
| -= | a -= 3 | a = a - 3 |
| *= | a *= 3 | a = a * 3 |
| /= | a /= 3 | a = a / 3 |
| %= | a %= 3 | a = a % 3 |

#### Unary Operators
| Operator | Name | Example | Description |
|----------|------|---------|-------------|
| ++a | Pre-increment | ++a | Increment then use |
| a++ | Post-increment | a++ | Use then increment |
| --a | Pre-decrement | --a | Decrement then use |
| a-- | Post-decrement | a-- | Use then decrement |

### Operator Precedence (High to Low)
1. Unary operators (++, --, !)
2. Multiplicative (*, /, %)
3. Additive (+, -)
4. Relational (<, >, <=, >=)
5. Equality (==, !=)
6. Logical AND (&&)
7. Logical OR (||)
8. Assignment (=, +=, -=, etc.)

### Interview Questions
- Explain pre-increment vs post-increment
- What is operator precedence and associativity?
- Difference between & and && operators

---

## 5. Input From User

### Program Objectives
- Master Scanner class for user input
- Handle different input types safely
- Implement input validation techniques

### Scanner Methods
| Method | Purpose | Example |
|--------|---------|---------|
| nextLine() | Full line of text | `scanner.nextLine()` |
| next() | Single word | `scanner.next()` |
| nextInt() | Integer input | `scanner.nextInt()` |
| nextDouble() | Decimal number | `scanner.nextDouble()` |
| nextBoolean() | true/false | `scanner.nextBoolean()` |

### Input Handling Pattern
```java
Scanner scanner = new Scanner(System.in);
System.out.print("Enter name: ");
String name = scanner.nextLine();
System.out.print("Enter age: ");
int age = scanner.nextInt();
scanner.close(); // Always close Scanner
```

### Common Pitfalls
- **Buffer Issues** - Use `nextLine()` after numeric input
- **Resource Leaks** - Always close Scanner
- **Input Validation** - Check for valid input types

### Interview Questions
- How to handle mixed input types with Scanner?
- What happens if wrong data type is entered?
- Best practices for resource management with Scanner

---

## 6. For Loop

### Program Objectives
- Master for loop syntax and structure
- Implement counting and iteration patterns
- Understand loop control variables

### For Loop Structure
```java
for (initialization; condition; update) {
    // Loop body
}
```

### Common Patterns
```java
// Forward counting
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}

// Reverse counting
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}

// Step counting
for (int i = 0; i < 100; i += 5) {
    System.out.println(i);
}
```

### Loop Control
- **break** - Exit loop immediately
- **continue** - Skip current iteration
- **Nested loops** - Loop inside another loop

### Interview Questions
- Explain for loop execution flow
- How to create infinite for loop?
- Difference between for and enhanced for loop

---

## 7. While Loop

### Program Objectives
- Master condition-based iteration
- Understand pre-test loop behavior
- Implement dynamic loop conditions

### While Loop Structure
```java
while (condition) {
    // Loop body
    // Update condition variable
}
```

### Key Characteristics
- **Pre-test Loop** - Condition checked before execution
- **Variable Update** - Must update condition variable inside loop
- **Flexible Conditions** - Any boolean expression

### Common Use Cases
```java
// Input validation
Scanner scanner = new Scanner(System.in);
int number;
do {
    System.out.print("Enter positive number: ");
    number = scanner.nextInt();
} while (number <= 0);

// Menu systems
int choice = 0;
while (choice != 4) {
    // Display menu and get choice
}
```

### Interview Questions
- When to use while loop vs for loop?
- How to avoid infinite while loops?
- Difference between while and do-while loops

---

## 8. Do-While Loop

### Program Objectives
- Master post-test loop behavior
- Understand execute-first loop pattern
- Apply do-while in appropriate scenarios

### Do-While Structure
```java
do {
    // Loop body (executes at least once)
} while (condition);
```

### Key Characteristics
- **Post-test Loop** - Condition checked after execution
- **Guaranteed Execution** - Body runs at least once
- **Semicolon Required** - After while condition

### When to Use Do-While
- **Menu Systems** - Show menu at least once
- **Input Validation** - Get input then validate
- **Game Loops** - Play at least one round

### Interview Questions
- Difference between while and do-while loops?
- When is do-while loop preferred?
- Can do-while loop be converted to while loop?

---

## 9. If-Else Statements

### Program Objectives
- Master conditional logic and decision making
- Implement complex condition chains
- Understand boolean expressions and logic

### If-Else Structure
```java
if (condition1) {
    // Execute if condition1 is true
} else if (condition2) {
    // Execute if condition2 is true
} else {
    // Execute if all conditions are false
}
```

### Condition Types
- **Simple Conditions** - `number > 0`
- **Compound Conditions** - `age >= 18 && hasLicense`
- **Nested Conditions** - if inside if

### Best Practices
```java
// Good: Clear and readable
if (score >= 90) {
    grade = 'A';
} else if (score >= 80) {
    grade = 'B';
} else if (score >= 70) {
    grade = 'C';
} else {
    grade = 'F';
}
```

### Interview Questions
- How to optimize multiple if-else conditions?
- Difference between if-else and switch statements?
- What is short-circuit evaluation?

---

## 10. Switch Case

### Program Objectives
- Master multi-way branching with switch
- Understand case matching and fall-through
- Apply switch for menu-driven programs

### Switch Structure
```java
switch (variable) {
    case value1:
        // Code for value1
        break;
    case value2:
        // Code for value2
        break;
    default:
        // Default code
}
```

### Switch Characteristics
- **Exact Matching** - Cases must match exactly
- **Fall-through** - Execution continues without break
- **Break Statement** - Exits switch block
- **Default Case** - Optional catch-all case

### Supported Data Types
- **Primitive Types** - int, char, byte, short
- **Wrapper Classes** - Integer, Character
- **Enums** - Enumerated types
- **String** - Since Java 7

### When to Use Switch vs If-Else
| Switch | If-Else |
|--------|---------|
| Exact value matching | Range conditions |
| Multiple discrete values | Complex boolean expressions |
| Better performance for many cases | More flexible conditions |
| Cleaner code for menus | Better for continuous ranges |

### Interview Questions
- What data types can be used in switch?
- Explain switch fall-through behavior
- When to use switch vs if-else ladder?

---

## Practice Problems

### Beginner Level
1. Create a calculator using switch statement
2. Build a grade calculator with if-else
3. Print multiplication table using for loop
4. Validate user input with while loop
5. Create a simple menu system

### Intermediate Level
1. Number guessing game with loops and conditions
2. Pattern printing with nested loops
3. Input validation system with multiple data types
4. Simple banking system with switch menu
5. Prime number checker with optimized logic

### Advanced Level
1. Multi-level menu system with switch and loops
2. Data processing system with all operators
3. Interactive quiz application
4. Simple text-based game
5. Comprehensive input validation framework

---

## Interview Preparation Tips

### Common Topics
- **Program Structure** - main method, class basics
- **Data Types** - primitive vs reference types
- **Operators** - precedence, associativity
- **Control Flow** - loops, conditions, branching
- **Input/Output** - Scanner usage, formatting

### Practice Strategy
1. **Understand Fundamentals** - Don't just memorize syntax
2. **Practice Coding** - Write programs for each concept
3. **Debug Programs** - Learn to find and fix errors
4. **Optimize Code** - Improve efficiency and readability
5. **Explain Concepts** - Practice explaining to others

---

## Code Examples Summary

**📁 Study in this sequence:**
1. `_1_Hello.java` - **START HERE** - Program structure
2. `_2_CommandLine.java` - Command-line arguments
3. `_3_DataType.java` - Variables and data types
4. `_4_AllOperators.java` - All operator categories
5. `_5_InputFromUser.java` - User input with Scanner
6. `_6_ForLoop.java` - For loop iteration
7. `_7_WhileLoop.java` - While loop patterns
8. `_8_DoWhileLoop.java` - Do-while loop usage
9. `_9_IfElse.java` - Conditional logic
10. `_10_SwitchCase.java` - Multi-way branching

This guide provides a solid foundation for Java programming fundamentals! 🎯