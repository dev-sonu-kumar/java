## 2. Streams API

### What is a Stream?
A **Stream** in Java is a sequence of elements that supports a pipeline of operations, enabling functional-style processing of data. Streams allow developers to process collections (or other data sources) declaratively, focusing on *what* to do rather than *how* to do it. Streams are not data structures; they don’t store data but provide a way to operate on data lazily.

Streams can be:
- **Sequential**: Processed one element at a time in order.
- **Parallel**: Processed concurrently for improved performance on large datasets.

### Key Characteristics
- **Laziness**: Operations like `filter` or `map` are intermediate and only executed when a terminal operation (e.g., `collect` or `forEach`) is invoked.
- **Immutability**: Streams don’t modify the underlying data source.
- **Single-Use**: A stream can be consumed only once; attempting to reuse it throws an exception.

### Common Stream Operations
| Operation | Type | Description |
|-----------|------|-------------|
| `filter(Predicate)` | Intermediate | Selects elements matching a condition. |
| `map(Function)` | Intermediate | Transforms each element into another form. |
| `sorted()` or `sorted(Comparator)` | Intermediate | Sorts elements (natural or custom order). |
| `collect(Collector)` | Terminal | Gathers results into a collection or other structure. |
| `forEach(Consumer)` | Terminal | Performs an action on each element. |
| `reduce()` | Terminal | Combines elements into a single result (e.g., sum, max). |
| `count()` | Terminal | Returns the number of elements in the stream. |

### Stream Pipeline
A stream pipeline consists of:
1. **Source**: Where the stream originates (e.g., `List.stream()`, `Arrays.stream()`).
2. **Intermediate Operations**: Zero or more operations like `filter`, `map`, or `sorted`.
3. **Terminal Operation**: A single operation (e.g., `collect`, `forEach`) that produces a result or side effect.

### Examples
#### Example 1: Filtering Names Starting with 'A'
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

names.stream()
     .filter(name -> name.startsWith("A"))
     .forEach(System.out::println); // Output: Alice
```
- **Explanation**: The `filter` operation uses a lambda to select names starting with "A". The `forEach` terminal operation prints the results using a method reference.

#### Example 2: Transforming List Elements
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

List<Integer> nameLengths = names.stream()
                                 .map(String::length)
                                 .collect(Collectors.toList());

System.out.println(nameLengths); // Output: [5, 3, 7]
```
- **Explanation**: The `map` operation transforms each string into its length using a method reference. The `collect` operation gathers the results into a `List`.

#### Example 3: Sorting and Collecting
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

List<String> sortedNames = names.stream()
                                .sorted()
                                .collect(Collectors.toList());

System.out.println(sortedNames); // Output: [Alice, Bob, Charlie, David]
```
- **Explanation**: The `sorted` operation sorts the names in natural order, and `collect` gathers them into a new `List`.

#### Example 4: Parallel Stream
For large datasets, parallel streams can improve performance:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

int sum = numbers.parallelStream()
                 .map(n -> n * n)
                 .reduce(0, Integer::sum);

System.out.println(sum); // Output: 55 (1² + 2² + 3² + 4² + 5² = 55)
```
- **Explanation**: The `parallelStream` processes elements concurrently. The `map` squares each number, and `reduce` sums the results.

### Benefits of Streams
- **Declarative Code**: Focus on what to do, not how to do it.
- **Parallel Processing**: Easily switch to parallel streams for performance.
- **Composability**: Chain multiple operations fluently.
- **Reduced Mutability**: Encourages immutable operations, reducing bugs.

### Limitations
- **Learning Curve**: Streams require understanding functional programming concepts.
- **Performance Overhead**: For small datasets, sequential streams may be slower than traditional loops.
- **Debugging**: Stack traces for stream operations can be complex.

## 3. Optional Class

### What is Optional?
`Optional<T>` is a container class introduced in Java 8 to represent a value that may or may not be present. It’s designed to reduce `NullPointerException`s by making the absence of a value explicit, encouraging safer coding practices.

### Key Characteristics
- **Explicit Null Handling**: Forces developers to handle the absence of a value.
- **No Need for Null Checks**: Replaces verbose `if (obj != null)` checks.
- **Functional Style**: Supports operations like `map`, `filter`, and `ifPresent` for functional programming.

### Creating Optional Objects
```java
Optional<String> nonEmpty = Optional.of("Alice");    // Non-null value
Optional<String> empty = Optional.empty();           // Empty optional
Optional<String> nullable = Optional.ofNullable(null); // Handles null
```
- `of(T value)`: Creates an `Optional` with a non-null value; throws `NullPointerException` if the value is null.
- `ofNullable(T value)`: Creates an `Optional` that may be empty if the value is null.
- `empty()`: Creates an empty `Optional`.

### Common Methods
| Method | Description |
|--------|-------------|
| `isPresent()` | Returns `true` if a value is present. |
| `isEmpty()` (Java 11+) | Returns `true` if no value is present. |
| `get()` | Returns the value if present; throws `NoSuchElementException` if empty. |
| `orElse(T other)` | Returns the value if present, else returns `other`. |
| `orElseGet(Supplier)` | Returns the value if present, else invokes the supplier. |
| `ifPresent(Consumer)` | Executes the consumer if a value is present. |
| `map(Function)` | Transforms the value if present, returning a new `Optional`. |
| `filter(Predicate)` | Keeps the value if it matches the predicate, else returns empty. |

### Examples
#### Example 1: Using Optional to Handle Null Safely
```java
public String getName() {
    return null; // Simulating possible null return
}

Optional<String> name = Optional.ofNullable(getName());

name.ifPresent(n -> System.out.println("Name is " + n));

String displayName = name.orElse("Unknown");
System.out.println(displayName); // Output: Unknown
```
- **Explanation**: `ofNullable` handles a potential `null` return. `ifPresent` does nothing if the `Optional` is empty, and `orElse` provides a default value.

#### Example 2: Using `map` with Optional
```java
Optional<String> name = Optional.of("Alice");

Optional<Integer> length = name.map(String::length);

length.ifPresent(len -> System.out.println("Length: " + len)); // Output: Length: 5
```
- **Explanation**: The `map` operation transforms the string into its length, returning an `Optional<Integer>`. `ifPresent` prints the result if present.

#### Example 3: Chaining Optionals
```java
Optional<String> name = Optional.of("Alice");

String result = name.map(String::toUpperCase)
                   .orElse("No Name");
System.out.println(result); // Output: ALICE
```
- **Explanation**: The `map` operation converts the string to uppercase, and `orElse` provides a fallback if the `Optional` were empty.

### Benefits of Optional
- **Null Safety**: Reduces risk of `NullPointerException`.
- **Clear Intent**: Explicitly indicates a value may be absent.
- **Functional Style**: Integrates with lambdas and streams.

### Limitations
- **Not a Replacement for All Nulls**: Overusing `Optional` (e.g., in method parameters) can make code verbose.
- **Serialization**: `Optional` is not serializable, limiting its use in certain contexts.

## Exercises
Below are solutions to the exercises provided, demonstrating practical applications of lambdas, streams, and `Optional`.

### Exercise 1: Sort a List of Strings by Length
**Task**: Use a lambda to sort a list of strings by their length.

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

List<String> sortedByLength = names.stream()
                                  .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                                  .collect(Collectors.toList());

System.out.println(sortedByLength); // Output: [Bob, Alice, David, Charlie]
```
- **Explanation**: The `sorted` operation uses a lambda to compare string lengths. `Integer.compare` ensures proper numerical comparison. The result is collected into a new `List`.

### Exercise 2: Sum of Squares of Even Numbers
**Task**: Use Streams to find the sum of squares of even numbers in a list of integers.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

int sumOfSquares = numbers.stream()
                          .filter(n -> n % 2 == 0)
                          .map(n -> n * n)
                          .reduce(0, Integer::sum);

System.out.println(sumOfSquares); // Output: 56 (2² + 4² + 6² = 4 + 16 + 36 = 56)
```
- **Explanation**: The `filter` selects even numbers, `map` squares them, and `reduce` sums the results using a method reference.

### Exercise 3: Extract First Character of a String
**Task**: Use `Optional` to safely extract the first character of a string that might be null.

```java
String input = null; // Simulating a nullable string

Optional<String> optionalInput = Optional.ofNullable(input);

String firstChar = optionalInput.map(s -> s.substring(0, 1))
                               .orElse("N/A");

System.out.println(firstChar); // Output: N/A
```
- **Explanation**: `ofNullable` handles the `null` input. The `map` operation attempts to extract the first character, and `orElse` provides a fallback if the `Optional` is empty.

## Summary Table
| Feature | Purpose | Example Use |
|---------|---------|-------------|
| **Lambda** | Simplify anonymous functions | `(x) -> x * 2` |
| **Stream** | Process collections functionally | `list.stream().filter(...).map(...)` |
| **Optional** | Handle nulls safely | `Optional.ofNullable(x).orElse("default")` |

## Conclusion
The **Streams API** and **Optional** class, introduced in Java 8, transform how developers process data and handle null values. Streams enable declarative, functional-style data processing with support for parallel execution, while `Optional` promotes safer, more explicit null handling. Combined with lambdas, these features make Java code more concise, readable, and robust. By mastering these tools and applying them in scenarios like the provided exercises, developers can write modern, efficient Java applications.