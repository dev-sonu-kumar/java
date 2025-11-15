import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class _8_AdvancedLambdaExample {
    public static void main(String[] args) {
        // Higher-order functions
        System.out.println("=== Higher-Order Functions ===");
        
        Function<Integer, Function<Integer, Integer>> adder = x -> y -> x + y;
        Function<Integer, Integer> add5 = adder.apply(5);
        System.out.println("5 + 3 = " + add5.apply(3));
        
        // Function composition
        Function<String, String> addPrefix = s -> "Mr. " + s;
        Function<String, String> addSuffix = s -> s + " Jr.";
        Function<String, String> fullTitle = addPrefix.andThen(addSuffix);
        
        System.out.println("Composed: " + fullTitle.apply("John"));
        
        // Currying example
        Function<Double, Function<Double, Function<Double, Double>>> calculateBMI = 
            weight -> height -> age -> {
                double bmi = weight / (height * height);
                return age > 65 ? bmi * 0.9 : bmi; // Age adjustment
            };
        
        double bmi = calculateBMI.apply(70.0).apply(1.75).apply(30.0);
        System.out.println("BMI: " + bmi);
        
        // Memoization with lambda
        System.out.println("\n=== Memoization ===");
        
        Function<Integer, Integer> fibonacci = memoize(n -> {
            if (n <= 1) return n;
            return fibonacci.apply(n - 1) + fibonacci.apply(n - 2);
        });
        
        System.out.println("Fibonacci(10): " + fibonacci.apply(10));
        
        // Custom collectors
        System.out.println("\n=== Custom Collectors ===");
        
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        
        // Custom collector to join with custom logic
        String result = words.stream()
            .collect(Collector.of(
                StringBuilder::new,                    // Supplier
                (sb, s) -> sb.append(s.toUpperCase()).append("-"), // Accumulator
                (sb1, sb2) -> sb1.append(sb2),       // Combiner
                sb -> sb.length() > 0 ? sb.substring(0, sb.length()-1) : "" // Finisher
            ));
        
        System.out.println("Custom joined: " + result);
        
        // Lazy evaluation with Supplier
        System.out.println("\n=== Lazy Evaluation ===");
        
        Supplier<String> expensiveOperation = () -> {
            System.out.println("Performing expensive operation...");
            return "Expensive Result";
        };
        
        // Only executed when needed
        if (Math.random() > 0.5) {
            System.out.println("Result: " + expensiveOperation.get());
        } else {
            System.out.println("Skipped expensive operation");
        }
        
        // Recursive lambda with Y combinator pattern
        System.out.println("\n=== Recursive Lambda ===");
        
        Function<Function<Integer, Integer>, Function<Integer, Integer>> factorialY = 
            f -> n -> n <= 1 ? 1 : n * f.apply(f).apply(n - 1);
        
        Function<Integer, Integer> factorial = factorialY.apply(factorialY);
        System.out.println("Factorial(5): " + factorial.apply(5));
        
        // Event handling with lambda
        System.out.println("\n=== Event System ===");
        
        EventSystem eventSystem = new EventSystem();
        
        // Register event handlers
        eventSystem.on("user.login", event -> 
            System.out.println("User logged in: " + event.getData()));
        
        eventSystem.on("user.logout", event -> 
            System.out.println("User logged out: " + event.getData()));
        
        // Trigger events
        eventSystem.emit("user.login", "alice@example.com");
        eventSystem.emit("user.logout", "alice@example.com");
        
        // Fluent API with lambda
        System.out.println("\n=== Fluent API ===");
        
        QueryBuilder query = new QueryBuilder()
            .select("name", "age")
            .from("users")
            .where(field -> field.equals("age").greaterThan(18))
            .orderBy("name")
            .limit(10);
        
        System.out.println("Generated query: " + query.build());
        
        // Validation chain
        System.out.println("\n=== Validation Chain ===");
        
        Validator<String> emailValidator = Validator.<String>of()
            .validate(s -> s != null, "Email cannot be null")
            .validate(s -> s.contains("@"), "Email must contain @")
            .validate(s -> s.length() > 5, "Email too short");
        
        ValidationResult result1 = emailValidator.test("user@example.com");
        ValidationResult result2 = emailValidator.test("invalid");
        
        System.out.println("Valid email: " + result1.isValid());
        System.out.println("Invalid email: " + result2.isValid() + " - " + result2.getErrors());
    }
    
    // Memoization utility
    public static <T, R> Function<T, R> memoize(Function<T, R> function) {
        Map<T, R> cache = new ConcurrentHashMap<>();
        return input -> cache.computeIfAbsent(input, function);
    }
}

// Event system implementation
class EventSystem {
    private Map<String, List<Consumer<Event>>> handlers = new HashMap<>();
    
    public void on(String eventType, Consumer<Event> handler) {
        handlers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(handler);
    }
    
    public void emit(String eventType, Object data) {
        handlers.getOrDefault(eventType, Collections.emptyList())
                .forEach(handler -> handler.accept(new Event(eventType, data)));
    }
}

class Event {
    private String type;
    private Object data;
    
    public Event(String type, Object data) {
        this.type = type;
        this.data = data;
    }
    
    public String getType() { return type; }
    public Object getData() { return data; }
}

// Fluent query builder
class QueryBuilder {
    private StringBuilder query = new StringBuilder();
    
    public QueryBuilder select(String... fields) {
        query.append("SELECT ").append(String.join(", ", fields));
        return this;
    }
    
    public QueryBuilder from(String table) {
        query.append(" FROM ").append(table);
        return this;
    }
    
    public QueryBuilder where(Function<FieldBuilder, FieldBuilder> condition) {
        FieldBuilder field = new FieldBuilder();
        condition.apply(field);
        query.append(" WHERE ").append(field.build());
        return this;
    }
    
    public QueryBuilder orderBy(String field) {
        query.append(" ORDER BY ").append(field);
        return this;
    }
    
    public QueryBuilder limit(int count) {
        query.append(" LIMIT ").append(count);
        return this;
    }
    
    public String build() {
        return query.toString();
    }
}

class FieldBuilder {
    private StringBuilder condition = new StringBuilder();
    
    public FieldBuilder equals(String field) {
        condition.append(field).append(" = ");
        return this;
    }
    
    public FieldBuilder greaterThan(Object value) {
        condition.append(value);
        return this;
    }
    
    public String build() {
        return condition.toString();
    }
}

// Validation framework
class Validator<T> {
    private List<ValidationRule<T>> rules = new ArrayList<>();
    
    public static <T> Validator<T> of() {
        return new Validator<>();
    }
    
    public Validator<T> validate(Predicate<T> condition, String errorMessage) {
        rules.add(new ValidationRule<>(condition, errorMessage));
        return this;
    }
    
    public ValidationResult test(T value) {
        List<String> errors = rules.stream()
            .filter(rule -> !rule.getCondition().test(value))
            .map(ValidationRule::getErrorMessage)
            .collect(Collectors.toList());
        
        return new ValidationResult(errors.isEmpty(), errors);
    }
}

class ValidationRule<T> {
    private Predicate<T> condition;
    private String errorMessage;
    
    public ValidationRule(Predicate<T> condition, String errorMessage) {
        this.condition = condition;
        this.errorMessage = errorMessage;
    }
    
    public Predicate<T> getCondition() { return condition; }
    public String getErrorMessage() { return errorMessage; }
}

class ValidationResult {
    private boolean valid;
    private List<String> errors;
    
    public ValidationResult(boolean valid, List<String> errors) {
        this.valid = valid;
        this.errors = errors;
    }
    
    public boolean isValid() { return valid; }
    public List<String> getErrors() { return errors; }
}