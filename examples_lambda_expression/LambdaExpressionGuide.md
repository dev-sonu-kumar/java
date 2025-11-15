# Java Lambda Expressions Complete Guide 🚀

## 📚 Learning Path (Recommended Order)

**Start with fundamentals:**
1. **Basic Lambda** - Syntax and comparison with anonymous classes
2. **Functional Interfaces** - Built-in and custom interfaces
3. **Method References** - Cleaner syntax alternatives
4. **Stream Operations** - Data processing with lambdas

**Then practical applications:**
5. **Collection Operations** - Real-world usage patterns
6. **Optional Handling** - Null-safe programming
7. **Parallel Processing** - Performance optimization
8. **Advanced Patterns** - Higher-order functions and design patterns

---

## 1. Basic Lambda Expressions

### Definition
Lambda expressions provide a concise way to represent anonymous functions. They enable functional programming in Java.

### Syntax
```java
(parameters) -> expression
(parameters) -> { statements; }
```

### Key Benefits
- **Concise code** - Less boilerplate than anonymous classes
- **Functional programming** - Treat functions as first-class citizens
- **Better readability** - More expressive code
- **Stream API integration** - Perfect for data processing

### When to Use
- Replacing anonymous classes with single method
- Stream operations (filter, map, reduce)
- Event handling
- Callback functions

---

## 2. Functional Interfaces

### Definition
Interface with exactly one abstract method. Can have default and static methods.

### Built-in Functional Interfaces
- **Predicate\<T>** - Takes T, returns boolean
- **Function\<T,R>** - Takes T, returns R  
- **Consumer\<T>** - Takes T, returns void
- **Supplier\<T>** - Takes nothing, returns T
- **BiFunction\<T,U,R>** - Takes T and U, returns R

### Time Complexity
- **Lambda creation**: O(1)
- **Method invocation**: O(1) + method complexity
- **No performance overhead** compared to anonymous classes

### Memory Usage
- **Lower memory footprint** than anonymous classes
- **No extra .class files** generated
- **Captured variables** stored in lambda instance

### When to Use
- Single abstract method interfaces
- Callback patterns
- Strategy pattern implementation
- Functional composition

---

## 3. Method References

### Definition
Shorthand notation for lambda expressions that call existing methods.

### Types
1. **Static method**: `ClassName::methodName`
2. **Instance method of particular object**: `object::methodName`
3. **Instance method of arbitrary object**: `ClassName::methodName`
4. **Constructor**: `ClassName::new`

### Time Complexity
- **Same as lambda expressions**: O(1) + method complexity
- **No additional overhead**

### Memory Usage
- **More efficient** than equivalent lambdas
- **Direct method handle** usage
- **No intermediate lambda objects**

### When to Use
- Method already exists for the operation
- Cleaner than lambda equivalent
- Constructor references for object creation
- Static utility method calls

---

## 4. Stream with Lambda

### Definition
Functional-style operations on collections using lambda expressions for data processing pipelines.

### Core Operations
- **filter()** - Select elements matching criteria
- **map()** - Transform elements
- **reduce()** - Combine elements into single result
- **collect()** - Gather results into collections

### Time Complexity
- **Sequential streams**: O(n) for most operations
- **Parallel streams**: O(n/p) where p = processor cores
- **Sorted operations**: O(n log n)
- **Distinct operations**: O(n) average, O(n²) worst case

### Memory Usage
- **Lazy evaluation** - Operations not executed until terminal operation
- **Intermediate operations** create lightweight stream objects
- **Parallel streams** use ForkJoinPool

### When to Use
- Data transformation pipelines
- Filtering and mapping operations
- Aggregation and grouping
- Large dataset processing

---

## 5. Collection Operations

### Definition
Lambda expressions integrated with Collection API methods for direct manipulation.

### Key Methods
- **forEach()** - Iterate with action
- **removeIf()** - Conditional removal
- **replaceAll()** - Transform all elements
- **sort()** - Custom sorting logic

### Time Complexity
- **forEach**: O(n)
- **removeIf**: O(n)
- **replaceAll**: O(n)
- **sort**: O(n log n)

### Memory Usage
- **In-place operations** where possible
- **No intermediate collections** created
- **Direct collection modification**

### When to Use
- Direct collection manipulation
- Avoiding intermediate collections
- Simple transformations
- Conditional operations

---

## 6. Optional with Lambda

### Definition
Container object that may or may not contain a value, designed to work seamlessly with lambda expressions.

### Key Operations
- **map()** - Transform value if present
- **flatMap()** - Transform and flatten
- **filter()** - Conditional presence
- **ifPresent()** - Action if value exists

### Time Complexity
- **All operations**: O(1) + lambda complexity
- **No iteration overhead**

### Memory Usage
- **Lightweight wrapper** around value
- **No null pointer exceptions**
- **Functional composition** without null checks

### When to Use
- Null-safe programming
- Avoiding null pointer exceptions
- Functional composition chains
- API methods that might return no value

---

## 7. Parallel Processing

### Definition
Lambda expressions with parallel streams and CompletableFuture for concurrent processing.

### Key Concepts
- **parallelStream()** - Automatic parallelization
- **ForkJoinPool** - Work-stealing thread pool
- **CompletableFuture** - Asynchronous computation
- **Thread-safe operations** - Avoiding shared mutable state

### Time Complexity
- **Parallel streams**: O(n/p) where p = available cores
- **Overhead**: Thread creation and coordination costs
- **Optimal for**: CPU-intensive operations on large datasets

### Memory Usage
- **Higher memory usage** due to thread overhead
- **Work-stealing queues** for load balancing
- **Concurrent collections** for thread safety

### When to Use
- Large datasets (>10,000 elements)
- CPU-intensive operations
- Independent computations
- Multi-core systems available

---

## 8. Advanced Patterns

### Definition
Sophisticated lambda usage patterns including higher-order functions, currying, and functional design patterns.

### Advanced Concepts
- **Higher-order functions** - Functions that take/return functions
- **Currying** - Partial application of functions
- **Memoization** - Caching function results
- **Function composition** - Combining functions

### Time Complexity
- **Memoization**: O(1) for cached results, original complexity for new inputs
- **Function composition**: Sum of composed function complexities
- **Higher-order functions**: Depends on implementation

### Memory Usage
- **Memoization**: Additional memory for cache
- **Function composition**: Chain of function objects
- **Closures**: Captured variable storage

### When to Use
- Complex functional compositions
- Performance optimization (memoization)
- Reusable function libraries
- Functional programming patterns

---

## Performance Comparison Table

| Pattern | Time Complexity | Memory Usage | Use Case |
|---------|----------------|--------------|----------|
| Basic Lambda | O(1) + method | Low | Simple operations |
| Method Reference | O(1) + method | Lower | Existing method calls |
| Stream Operations | O(n) - O(n log n) | Lazy evaluation | Data processing |
| Parallel Streams | O(n/p) | Higher (threads) | Large datasets |
| Optional Chains | O(1) per operation | Low wrapper | Null safety |
| Memoization | O(1) cached, O(f) new | Cache storage | Expensive computations |

---

## Best Practices

### ✅ Do:
- Use method references when possible
- Keep lambdas short and focused
- Prefer immutable objects in streams
- Use parallel streams for large datasets only
- Chain Optional operations for null safety

### ❌ Don't:
- Use lambdas for complex logic (extract to methods)
- Modify external variables in lambdas
- Use parallel streams for small datasets
- Ignore exception handling in lambdas
- Create unnecessary intermediate objects

---

## Interview Key Points

### Lambda vs Anonymous Classes:
- **Lambda**: Functional interfaces only, no state, better performance
- **Anonymous**: Any interface, can have state, more memory overhead

### Stream vs Collection:
- **Stream**: Lazy evaluation, functional operations, immutable
- **Collection**: Eager evaluation, imperative operations, mutable

### Parallel Stream Considerations:
- **CPU-bound tasks**: Good candidate
- **I/O-bound tasks**: Poor candidate  
- **Shared mutable state**: Avoid completely
- **Small datasets**: Sequential is faster

---

## Code Examples Summary (Learning Order)

**📁 Study in this sequence:**
1. `_1_BasicLambdaExample.java` - **START HERE** - Syntax and basics
2. `_2_FunctionalInterfaceExample.java` - Built-in and custom interfaces
3. `_3_MethodReferenceExample.java` - Cleaner syntax alternatives
4. `_4_StreamLambdaExample.java` - Data processing pipelines
5. `_5_CollectionLambdaExample.java` - Direct collection operations
6. `_6_OptionalLambdaExample.java` - Null-safe programming
7. `_7_ParallelLambdaExample.java` - Concurrent processing
8. `_8_AdvancedLambdaExample.java` - **ADVANCED** - Design patterns

---

## Modern Java Features

### Java 8+:
- Lambda expressions and method references
- Stream API and Optional
- Functional interfaces in java.util.function

### Java 9+:
- Enhanced Optional methods (ifPresentOrElse, or)
- Stream improvements (takeWhile, dropWhile)

### Java 11+:
- Local variable type inference in lambdas (var)
- String methods with functional style

### Java 17+:
- Pattern matching enhancements
- Sealed classes with functional interfaces

---

## Real-World Applications

### Data Processing:
```java
// ETL pipeline
data.stream()
    .filter(record -> record.isValid())
    .map(this::transform)
    .collect(groupingBy(Record::getCategory))
```

### Event Handling:
```java
// GUI event handling
button.setOnAction(event -> handleButtonClick());
```

### API Design:
```java
// Fluent API with lambdas
queryBuilder
    .where(field -> field.equals("status").in("active", "pending"))
    .orderBy("created_date")
```

This comprehensive guide covers all aspects of lambda expressions from basics to advanced patterns, providing a complete learning path for mastering functional programming in Java! 🎯