# Java 8 Features Guide 🚀

## 📚 Learning Path (Recommended Order)

**Master Java 8 fundamentals:**
1. **Lambda Expressions** - Functional programming basics
2. **Stream API** - Data processing and transformations
3. **Optional** - Null-safe programming
4. **Date/Time API** - Modern date handling

---

## 1. Lambda Expressions

### Program Objectives
- Understand functional programming concepts in Java
- Master lambda syntax and functional interfaces
- Learn method references and their usage
- Apply lambdas with collections effectively

### Key Concepts Covered
- **Basic Lambda Syntax** - `() -> expression`
- **Functional Interfaces** - Predicate, Function, Consumer, Supplier
- **Method References** - `Class::method`
- **Lambda with Collections** - Enhanced iteration and processing

### Functional Interfaces
| Interface | Method | Purpose | Example |
|-----------|--------|---------|---------|
| Predicate<T> | test(T) | Boolean test | `n -> n > 0` |
| Function<T,R> | apply(T) | Transform T to R | `s -> s.length()` |
| Consumer<T> | accept(T) | Process T | `s -> System.out.println(s)` |
| Supplier<T> | get() | Supply T | `() -> Math.random()` |

### Lambda Syntax Evolution
```java
// Anonymous class
Runnable r1 = new Runnable() {
    public void run() { System.out.println("Hello"); }
};

// Lambda expression
Runnable r2 = () -> System.out.println("Hello");

// Method reference
list.forEach(System.out::println);
```

---

## 2. Stream API

### Program Objectives
- Master stream creation and operations
- Understand intermediate vs terminal operations
- Learn parallel processing with streams
- Apply collectors for data aggregation

### Key Operations
- **Intermediate Operations** - filter, map, sorted, distinct, limit
- **Terminal Operations** - collect, reduce, forEach, count
- **Collectors** - toList, groupingBy, partitioningBy
- **Parallel Streams** - parallelStream() for performance

### Stream Pipeline Pattern
```java
List<String> result = collection.stream()
    .filter(predicate)          // Intermediate
    .map(function)              // Intermediate
    .sorted()                   // Intermediate
    .collect(Collectors.toList()); // Terminal
```

### Performance Considerations
| Operation | Time Complexity | When to Use |
|-----------|----------------|-------------|
| filter() | O(n) | Remove unwanted elements |
| map() | O(n) | Transform elements |
| sorted() | O(n log n) | Order elements |
| parallel() | Varies | Large datasets (>1000 elements) |

---

## 3. Optional

### Program Objectives
- Eliminate null pointer exceptions
- Write null-safe code patterns
- Master Optional chaining operations
- Understand when and how to use Optional

### Key Methods
- **Creation** - `empty()`, `of()`, `ofNullable()`
- **Checking** - `isPresent()`, `isEmpty()`
- **Retrieval** - `get()`, `orElse()`, `orElseGet()`
- **Transformation** - `map()`, `flatMap()`, `filter()`

### Optional Best Practices
```java
// ❌ Don't do this
Optional<String> opt = Optional.ofNullable(getString());
if (opt.isPresent()) {
    return opt.get().toUpperCase();
}

// ✅ Do this instead
return Optional.ofNullable(getString())
    .map(String::toUpperCase)
    .orElse("DEFAULT");
```

### Common Anti-patterns
- Never use `Optional.get()` without checking `isPresent()`
- Don't use Optional for fields or method parameters
- Prefer `orElse()` for constants, `orElseGet()` for computations

---

## 4. Date and Time API

### Program Objectives
- Replace legacy Date and Calendar classes
- Handle dates, times, and time zones properly
- Perform date calculations and formatting
- Work with periods and durations

### Core Classes
- **LocalDate** - Date without time (2024-01-15)
- **LocalTime** - Time without date (14:30:00)
- **LocalDateTime** - Date and time (2024-01-15T14:30:00)
- **ZonedDateTime** - Date, time, and timezone

### Date Operations
| Operation | Method | Example |
|-----------|--------|---------|
| Add time | plus*() | `date.plusDays(7)` |
| Subtract time | minus*() | `date.minusMonths(1)` |
| Compare | isBefore/isAfter | `date1.isBefore(date2)` |
| Format | format() | `date.format(formatter)` |

### Immutability Advantage
```java
LocalDate date = LocalDate.now();
LocalDate nextWeek = date.plusWeeks(1); // Returns new instance
// 'date' remains unchanged - thread-safe!
```

---

## Interview Preparation

### Lambda Expressions
- Write a lambda to filter even numbers from a list
- Convert anonymous class to lambda expression
- Explain the difference between lambda and method reference
- Implement custom functional interface

### Stream API
- Process a list of employees to find highest salary
- Group students by grade using collectors
- Explain parallel stream benefits and limitations
- Chain multiple stream operations efficiently

### Optional
- Refactor null-checking code to use Optional
- Explain Optional chaining with map and filter
- When should you NOT use Optional?
- Handle nested Optional scenarios

### Date/Time API
- Calculate age from birthdate
- Format dates for different locales
- Handle time zone conversions
- Compare and sort dates

---

## Practice Problems

### Beginner Level
1. Filter and print even numbers using streams
2. Create Optional wrapper for user input validation
3. Format current date in multiple patterns
4. Convert list of strings to uppercase using lambdas

### Intermediate Level
1. Group employees by department and calculate average salary
2. Chain Optional operations for nested object access
3. Calculate business days between two dates
4. Implement parallel processing for large datasets

### Advanced Level
1. Build a functional pipeline for data transformation
2. Create custom collectors for complex aggregations
3. Handle multiple time zones in scheduling application
4. Optimize stream operations for performance

---

## Code Examples Summary

**📁 Study in this sequence:**
1. `_1_LambdaBasicsExample.java` - **START HERE** - Functional programming
2. `_2_StreamAPIExample.java` - Data processing and transformations
3. `_3_OptionalExample.java` - Null-safe programming patterns
4. `_4_DateTimeAPIExample.java` - Modern date and time handling

---

## Best Practices

### Lambda Expressions
- Keep lambdas short and readable
- Use method references when possible
- Avoid side effects in lambda expressions
- Prefer standard functional interfaces

### Stream API
- Use parallel streams only for CPU-intensive operations
- Avoid stateful operations in parallel streams
- Chain operations efficiently
- Use appropriate collectors

### Optional
- Never call `get()` without checking presence
- Use `orElse()` for default values
- Chain operations with `map()` and `filter()`
- Don't overuse Optional everywhere

### Date/Time API
- Always use immutable date/time classes
- Handle time zones explicitly when needed
- Use appropriate precision (Date vs DateTime)
- Format dates consistently across application

This guide provides comprehensive coverage of Java 8's most important features for modern Java development! 🎯