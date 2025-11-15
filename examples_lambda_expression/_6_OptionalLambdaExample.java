import java.util.*;
import java.util.function.*;

public class _6_OptionalLambdaExample {
    public static void main(String[] args) {
        // Creating Optional objects
        Optional<String> nonEmpty = Optional.of("Hello");
        Optional<String> empty = Optional.empty();
        Optional<String> nullable = Optional.ofNullable(null);
        
        // Basic Optional operations with lambda
        nonEmpty.ifPresent(value -> System.out.println("Value: " + value));
        empty.ifPresent(value -> System.out.println("This won't print"));
        
        // orElse with lambda-like behavior
        String result1 = empty.orElse("Default Value");
        String result2 = empty.orElseGet(() -> "Generated Default");
        
        System.out.println("orElse result: " + result1);
        System.out.println("orElseGet result: " + result2);
        
        // map with Optional
        Optional<Integer> length = nonEmpty.map(String::length);
        length.ifPresent(len -> System.out.println("Length: " + len));
        
        // flatMap with Optional
        Optional<String> upperCase = nonEmpty.flatMap(s -> 
            s.isEmpty() ? Optional.empty() : Optional.of(s.toUpperCase()));
        upperCase.ifPresent(System.out::println);
        
        // filter with Optional
        Optional<String> filtered = nonEmpty.filter(s -> s.startsWith("H"));
        filtered.ifPresent(s -> System.out.println("Starts with H: " + s));
        
        // Practical example with user data
        List<User> users = Arrays.asList(
            new User("alice@email.com", "Alice", 25),
            new User("bob@email.com", "Bob", 30),
            new User(null, "Charlie", 20)
        );
        
        // Find user by email safely
        findUserByEmail(users, "alice@email.com")
            .ifPresentOrElse(
                user -> System.out.println("Found user: " + user.getName()),
                () -> System.out.println("User not found")
            );
        
        // Chain Optional operations
        findUserByEmail(users, "alice@email.com")
            .filter(user -> user.getAge() > 20)
            .map(User::getName)
            .map(String::toUpperCase)
            .ifPresent(name -> System.out.println("Adult user: " + name));
        
        // Handle null email safely
        users.forEach(user -> {
            Optional.ofNullable(user.getEmail())
                .filter(email -> email.contains("@"))
                .ifPresentOrElse(
                    email -> System.out.println("Valid email: " + email),
                    () -> System.out.println("Invalid email for: " + user.getName())
                );
        });
        
        // Optional with exception handling
        parseInteger("123")
            .ifPresentOrElse(
                num -> System.out.println("Parsed number: " + num),
                () -> System.out.println("Failed to parse")
            );
        
        parseInteger("abc")
            .ifPresentOrElse(
                num -> System.out.println("Parsed number: " + num),
                () -> System.out.println("Failed to parse 'abc'")
            );
    }
    
    public static Optional<User> findUserByEmail(List<User> users, String email) {
        return users.stream()
            .filter(user -> Objects.equals(user.getEmail(), email))
            .findFirst();
    }
    
    public static Optional<Integer> parseInteger(String str) {
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}

class User {
    private String email;
    private String name;
    private int age;
    
    public User(String email, String name, int age) {
        this.email = email;
        this.name = name;
        this.age = age;
    }
    
    public String getEmail() { return email; }
    public String getName() { return name; }
    public int getAge() { return age; }
}