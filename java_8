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
Let me know if you want further customization (sections, quiz, flashcards, etc.) for your GitHub README!
