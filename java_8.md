```markdown
# Java 8 Complete Study Guide for Professionals

This guide summarizes all essential concepts, code patterns, and practical commentary from Java 8. Use it for interview prep, real-world projects, or deep revision—no need to watch video lectures again.

---

## 1. Introduction to Java 8

Java 8 delivers:
- **Concise syntax**: Fewer lines, clear structure.
- **Functional programming**: First-class functions, easy data flow.
- **Parallelism**: Natively exploit multicore processors.

**Key features:**
- Lambda Expressions
- Functional Interfaces
- Stream API
- Date/Time API (`java.time`)
- Default & Static Methods in interfaces
- Method & Constructor References
- Optional Class
- Base64 utilities

---

## 2. Lambda Expressions

**Definition:** Anonymous, inline functions without a name, modifier, or return type.

**Syntax**
```
(parameters) -> expression
```
**Examples**
```
() -> System.out.println("No params")
x -> x * x
(a, b) -> a + b
```

**Comparison**
```
// Pre-Java 8
Runnable runner = new Runnable() {
    public void run() { System.out.println("Thread running"); }
};

// Java 8
Runnable runner = () -> System.out.println("Thread running");
```

**Interview Pro Tips**
- Lambdas remove boilerplate; focus on business logic.
- Best used with functional interfaces.

---

## 3. Functional Interfaces

**Definition:** Interface with **exactly one** abstract method (SAM: Single Abstract Method).

**Example**
```
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}
```
**Usage**
```
MathOperation add = (a, b) -> a + b;
int result = add.operate(5, 3); // 8
```

**Key built-ins**
| Interface        | Method              | Use-case            |
| ---------------  | ------------------ | ------------------- |
| Predicate<T>     | boolean test(T)    | Filtering           |
| Function<T,R>    | R apply(T)         | Data Transformation |
| Consumer<T>      | void accept(T)     | Perform Action      |
| Supplier<T>      | T get()            | Generate Value      |

**Interview Pro Tips**
- Use `@FunctionalInterface` to make intent clear.
- Only one abstract method: default/static don’t count.

---

## 4. Default Methods

Let interfaces provide method implementations.

**Example**
```
interface Vehicle {
    default void start() { System.out.println("Vehicle starting"); }
}
class Car implements Vehicle {}
```

**Conflict Resolution (Multiple Inheritance)**
When two interfaces provide same default method, override and specify which one:
```
A.super.methodName();
```

**Interview Pro Tips**
- Enables backward-compatible API evolution.
- Resolve diamond problem by explicit overrides.

---

## 5. Static Methods in Interfaces

Static belongs to interface—not to instances.

**Example**
```
interface Utils {
    static int doubleIt(int x) { return x * 2; }
}
int y = Utils.doubleIt(5); // 10
```

**Interview Pro Tips**
- Cannot override static methods.
- Called via interface name.

---

## 6. Method & Constructor References

Shortcuts to use existing methods as lambdas.

**Syntax**
- `Class::staticMethod`
- `instance::instanceMethod`
- `Class::instanceMethod` (for arbitrary objects)
- `Class::new` (constructor reference)

**Example**
```
List<String> names = Arrays.asList("Tom", "Jerry", "Spike");
names.forEach(System.out::println);
```

**Interview Pro Tips**
- Use for clarity and brevity where lambda would only call an existing method.

---

## 7. Stream API

Functional-style operations on collections.

**Common operations**
```
List<Integer> nums = Arrays.asList(1,2,3,4,5);

// Filter, map, forEach
nums.stream()
    .filter(n -> n % 2 == 0)
    .map(n -> n * n)
    .forEach(System.out::println);
```

**Terminal vs Intermediate**
- **Intermediate:** `filter`, `map`, `sorted`
- **Terminal:** `forEach`, `collect`, `reduce`

**Parallel Streams**
```
nums.parallelStream().forEach(System.out::println);
```

**Reduce Example**
```
int sum = nums.stream().reduce(0, (a, b) -> a + b); // 15
```

**Interview Pro Tips**
- Streams are lazy—no operation executes until terminal function (`forEach`, `collect`, etc.)
- Improves readability and maintainability for data processing.

---

## 8. Date and Time API (`java.time`)

Modern, immutable, and thread-safe classes for date-time handling.

**Key Classes**
| Purpose    | Class              |
| ---------- | ------------------ |
| Date       | `LocalDate`        |
| Time       | `LocalTime`        |
| Date/Time  | `LocalDateTime`    |
| TimeZone   | `ZonedDateTime`    |
| Differences| `Period`, `Duration`|

**Examples**
```
LocalDate today = LocalDate.now();
LocalTime now = LocalTime.now();
LocalDateTime dt = LocalDateTime.now();

Period age = Period.between(LocalDate.of(1990, 1, 1), today);
System.out.println("Years: " + age.getYears());
```

**Interview Pro Tips**
- Use `java.time` for all new code; never `java.util.Date`
- All classes are immutable.

---

## 9. Optional Class

Wraps a value that may be absent (to avoid `NullPointerException`).

**Example**
```
Optional<String> name = Optional.ofNullable(getUserName()); // getUserName might return null
name.ifPresent(n -> System.out.println(n));
String display = name.orElse("Guest");
```

**Key methods**
- `isPresent()`
- `get()`
- `orElse()`
- `ifPresent()`

**Interview Pro Tips**
- Use to declare “maybe value” in APIs, not in every local variable.

---

## 10. Base64 Utilities

Encoding and decoding without external libraries.

**Example**
```
import java.util.Base64;
String raw = "mypassword";
String enc = Base64.getEncoder().encodeToString(raw.getBytes());
byte[] dec = Base64.getDecoder().decode(enc);
System.out.println(new String(dec)); // "mypassword"
```

**Modes:** Basic, URL, MIME

---

## 11. Real-world Pattern Example

```
import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    int age;
    double salary;
    Employee(String n, int a, double s) { name=n; age=a; salary=s;}
    public String toString() { return name + " (" + salary + ")"; }
}

public class Main {
    public static void main(String[] args){
        List<Employee> list = Arrays.asList(
            new Employee("Ali",29,70000),
            new Employee("Ravi",32,65000),
            new Employee("Sara",28,85000)
        );

        list.stream()
            .filter(e -> e.salary > 70000)
            .map(e -> e.name)
            .forEach(System.out::println); // Sara
    }
}
```

---

## 12. Interview and Project Insights

- **Why Java 8 matters:** Clean and expressive code, promotes functional thinking, enables efficient parallel data methods, and modernizes APIs.
- **Functional interfaces:** Learn built-in ones, and how to create your own.
- **Streams:** For mass data filtering, mapping, and reduction.
- **Default/static methods:** Enable backward-compatible API changes.

**Sample Interview Questions**
- What is a functional interface and why is it important for lambdas?
- How do you resolve default method conflicts in multiple inheritance?
- Difference between `map()` and `flatMap()` in streams?
- How does `Optional` help avoid pitfalls of null values?
- How would you migrate old `Date` code to the new API?

---

## Mnemonics & Summary Table

| Feature         | In One Line                | Interview Mnemonic |
|-----------------|---------------------------|---------------------|
| Lambda          | Anonymous function         | "L for Lambda"      |
| Functional Interface | One abstract method     | "F for Functional"  |
| Stream API      | Sequence operations       | "S for Stream"      |
| Date/Time API   | Modern time handling      | "D for Date"        |

---

*For professional prep: Practice code, read method signatures, and be ready to explain concepts and differences in simple terms to the interviewer.*
```

```markdown


# Java 8 Interview Q&A 


## 1. What is a Functional Interface?  
**Answer:**  
A functional interface is an interface with exactly one abstract method (SAM—Single Abstract Method).  
Lambdas or method references can be assigned to functional interfaces.  
You can mark them with the `@FunctionalInterface` annotation, which signals intent and instructs the compiler to error if more than one abstract method exists.

*Example:*
```
@FunctionalInterface
interface Processor {
    void process(String input);
}
```
---

## 2. How do Lambda Expressions work with Functional Interfaces?  
**Answer:**  
Lambdas can only be used where a functional interface is expected.  
The Java compiler automatically matches the lambda signature to the abstract method in the functional interface.

*Example:*
```
Processor print = s -> System.out.println(s);
print.process("Hello Lambda!");
```
---

## 3. What is the purpose of default and static methods in interfaces?  
**Answer:**  
- **Default methods** allow interfaces to provide method implementations, supporting backward-compatible API evolution.
- **Static methods** let interfaces offer utility operations related to the interface, accessible via the interface name.

*Example:*
```
interface Shape {
    default void draw() {
        System.out.println("Drawing shape");
    }
    static void describe() {
        System.out.println("This is a shape interface");
    }
}
```
---

## 4. Explain the Stream API and advantages over traditional looping.  
**Answer:**  
Streams enable declarative, functional-style operations on collections such as filtering, mapping, and reduction.  
They support lazy evaluation, can be parallelized, and make code more readable and maintainable.

*Traditional loop:*
```
for (String s : list) {
    if (s.startsWith("A")) result.add(s.toUpperCase());
}
```
*With Stream API:*
```
list.stream()
    .filter(s -> s.startsWith("A"))
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

---

## 5. Describe the `Optional` class and how it avoids null pointer exceptions.  
**Answer:**  
`Optional` is a container object that may or may not contain a non-null value.  
It makes code cleaner by forcing developers to explicitly deal with absence/presence of values, reducing runtime `NullPointerException`s and promoting safer coding patterns.

*Example:*
```
Optional<String> user = Optional.ofNullable(findUser());
String result = user.orElse("default");
```

---

## 6. How can you resolve a default method conflict in multiple inheritance from interfaces?  
**Answer:**  
When a class implements multiple interfaces that have the same default method signature, you must explicitly override the method and specify which interface’s default you want.

*Example:*
```
interface A { default void hello() { System.out.println("A"); } }
interface B { default void hello() { System.out.println("B"); } }
class C implements A, B {
    @Override
    public void hello() {
        A.super.hello(); // or B.super.hello();
    }
}
```
---

## 7. What is a method reference and how is it different from a lambda?  
**Answer:**  
A method reference is a shorthand for a lambda that merely calls an existing method.  
Syntax: `Class::method` or `object::instanceMethod`  
It improves readability when the lambda only calls a single method.

*Example:*
```
list.forEach(System.out::println);
```
Equivalent to:
```
list.forEach(item -> System.out.println(item));
```
---

## 8. Can you show how to use a parallel stream for performance, and what are the caveats?  
**Answer:**  
Parallel streams use multiple threads for processing, improving performance for large data sets.  
However, beware of race conditions with mutable shared states and non-deterministic output order.

*Example:*
```
list.parallelStream().forEach(System.out::println);
```
**Caveat:**  
- Don’t mutate shared variables inside parallel streams.
- Sometimes overhead outweighs benefits for small collections.

---

## 9. How do you migrate legacy date/time code to Java 8's `java.time` API?  
**Answer:**  
Java 8 introduced immutable, thread-safe types (`LocalDate`, `LocalDateTime`, `Instant`, etc.), replacing confusing legacy classes (`Date`, `Calendar`).  
For migration, use conversion methods and prefer new types in all new code.

*Example migration:*
```
Date legacyDate = new Date();
Instant instant = legacyDate.toInstant();
LocalDate newDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
```
---

## 10. What is the difference between `map()` and `flatMap()` in Streams?  
**Answer:**  
- `map()` transforms each stream element to another value (normal 1-to-1 mapping).
- `flatMap()` transforms each element to a new stream and flattens nested structures into a single stream.

*Example:*
```
Stream<List<String>> names = Stream.of(Arrays.asList("Tom", "Jerry"), Arrays.asList("Spike"));
Stream<String> flat = names.flatMap(Collection::stream); // Single stream of all names
```
---

*Pro Interview Tips:*  
- Always explain use cases and performance/multi-threading implications for Java 8 features.
- Reference real bugs solved by lambdas/optionals/streams in your team projects.
- Be ready to whiteboard code and discuss best practices or “gotchas” for code quality and maintainability.

```

```markdown
# Java 8 Interview Q&A (Backend & API Design, 5–6 Years Experience)

Advanced questions, explanations, and coding examples for backend-focused roles.

---

## 1. How would you implement a RESTful API endpoint using Java 8 features?

**Answer:**  
Use lambda expressions for business logic, streams for data processing, and Optionals for null safety.

*Example (Spring Boot controller):*
```
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getUsers(@RequestParam Optional<String> startsWith) {
        Stream<User> stream = userService.findAll().stream();
        if (startsWith.isPresent()) {
            stream = stream.filter(u -> u.getName().startsWith(startsWith.get()));
        }
        return stream
            .map(user -> new UserDto(user.getName(), user.getEmail()))
            .collect(Collectors.toList());
    }
}
```
---

## 2. How does Java 8 improve DTO (Data Transfer Object) mapping in APIs?

**Answer:**  
Streams and lambdas make bulk DTO conversion simple, readable, and efficient.

*Example:*
```
List<UserDto> dtos = users.stream()
    .map(u -> new UserDto(u.getName(), u.getEmail()))
    .collect(Collectors.toList());
```

**Pro Tip:**  
Combine with method references for clarity:
```
users.stream()
     .map(UserDto::fromEntity)
     .collect(Collectors.toList());
```
---

## 3. How do you handle optional query parameters or null responses in an API?

**Answer:**  
Use `Optional` to avoid null checks, and express “absent” values in method results and endpoint responses.

*Example (service layer):*
```
public Optional<User> findById(Long id) {
    return userRepo.findById(id);
}

// In controller:
@GetMapping("/{id}")
public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
    return userService.findById(id)
        .map(user -> ResponseEntity.ok(UserDto.fromEntity(user)))
        .orElseGet(() -> ResponseEntity.notFound().build());
}
```
---

## 4. How would you safely process large collections or paginated API data using Java 8?

**Answer:**  
Use streams for declarative bulk processing and parallel streams for large sets, ensuring thread safety and chunk-wise processing.

*Example:*
```
// Stream for processing large collections
users.stream()
    .skip(page * pageSize)
    .limit(pageSize)
    .filter(User::isActive)
    .forEach(u -> processUser(u));

// Parallel for CPU-intensive tasks
users.parallelStream()
    .forEach(u -> u.computeScore());
```
**Caveat:** Avoid shared mutable state!

---

## 5. How can you build a filter pipeline for user search endpoints using Streams?

**Answer:**
Compose predicates and build a pipeline based on incoming criteria.

*Example:*
```
public List<User> search(String name, Integer minAge, Boolean isAdmin) {
    Stream<User> stream = userRepo.findAll().stream();
    if (name != null) stream = stream.filter(u -> u.getName().contains(name));
    if (minAge != null) stream = stream.filter(u -> u.getAge() >= minAge);
    if (isAdmin != null) stream = stream.filter(u -> u.isAdmin() == isAdmin);
    return stream.collect(Collectors.toList());
}
```
---

## 6. How do method references help with API business logic?

**Answer:**
They simplify code, e.g., when transforming DTOs, filtering, or logging.

*Example:*
```
users.stream()
    .map(UserDto::fromEntity)
    .forEach(System.out::println);
```
---

## 7. What’s the best way to ensure backwards compatibility of your public API in Java 8?

**Answer:**  
Use default methods in interfaces for API versioning, so new behaviors can be added smoothly.

*Example:*
```
public interface PaymentProcessor {
    void process(Payment payment);
    default void validate(Payment payment) {
        // Default validation logic, can be overridden
    }
}
```

---

## 8. Explain how Java 8 date/time API supports time zone handling in distributed backends.

**Answer:**
Use ZonedDateTime for time zone computations, distributing and storing timestamps as `Instant` or with explicit zones.

*Example:*
```
ZonedDateTime scheduled = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Kolkata"));
String isoString = scheduled.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);

Instant timestamp = scheduled.toInstant(); // Suitable for DB storage
```
---

## 9. What is the difference between map and flatMap for combining API payloads?

**Answer:**
`map()` returns a stream of collections; `flatMap()` flattens nested collections, critical for one-to-many or parent-child DTO mapping.

*Example:*
```
List<Order> orders = ...;
List<Item> result = orders.stream()
    .flatMap(order -> order.getItems().stream())
    .collect(Collectors.toList());
```
---
## 10. Challenge: Write a method to aggregate order amounts for each user using Streams.

**Answer:**
```
Map<User, Double> totals = orders.stream()
    .collect(Collectors.groupingBy(Order::getUser, Collectors.summingDouble(Order::getAmount)));
```
---

**Pro Interview Hints:**
- Always mention thread safety for parallel APIs (avoid mutable state!).
- Discuss error handling using Optional and functional pipelines.
- Show awareness of API design patterns, versioning, and endpoint evolution with default methods.
```

