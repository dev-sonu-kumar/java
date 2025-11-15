/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates Java 8 Optional class:
 * 1. Optional creation and basic usage
 * 2. Avoiding null pointer exceptions
 * 3. Optional methods (isPresent, orElse, map, filter)
 * 4. Chaining operations with Optional
 */

import java.util.*;

public class _3_OptionalExample {
    public static void main(String[] args) {
        System.out.println("=== Java 8 Optional ===");
        
        // 1. Optional Creation
        System.out.println("\n1. Optional Creation:");
        
        Optional<String> empty = Optional.empty();
        Optional<String> nonEmpty = Optional.of("Hello");
        Optional<String> nullable = Optional.ofNullable(null);
        
        System.out.println("Empty: " + empty);
        System.out.println("Non-empty: " + nonEmpty);
        System.out.println("Nullable: " + nullable);
        
        // 2. Checking Presence
        System.out.println("\n2. Checking Presence:");
        
        if (nonEmpty.isPresent()) {
            System.out.println("Value: " + nonEmpty.get());
        }
        
        // Better way
        nonEmpty.ifPresent(value -> System.out.println("Better way: " + value));
        
        // 3. Default Values
        System.out.println("\n3. Default Values:");
        
        String value1 = empty.orElse("Default Value");
        String value2 = empty.orElseGet(() -> "Generated Default");
        
        System.out.println("OrElse: " + value1);
        System.out.println("OrElseGet: " + value2);
        
        // 4. Transforming Values
        System.out.println("\n4. Transforming Values:");
        
        Optional<Integer> length = nonEmpty.map(String::length);
        System.out.println("Length: " + length.orElse(0));
        
        // 5. Filtering
        System.out.println("\n5. Filtering:");
        
        Optional<String> filtered = nonEmpty.filter(s -> s.length() > 3);
        System.out.println("Filtered (length > 3): " + filtered.orElse("Too short"));
        
        // 6. Chaining Operations
        System.out.println("\n6. Chaining Operations:");
        
        Optional<String> result = Optional.of("  Java Programming  ")
                                         .map(String::trim)
                                         .filter(s -> s.contains("Java"))
                                         .map(String::toUpperCase);
        
        result.ifPresent(System.out::println);
        
        // 7. Real-world Example
        System.out.println("\n7. Real-world Example:");
        
        User user = new User("Alice", "alice@example.com");
        String email = getUserEmail(user)
                      .map(String::toLowerCase)
                      .orElse("No email provided");
        
        System.out.println("User email: " + email);
    }
    
    // Helper method returning Optional
    public static Optional<String> getUserEmail(User user) {
        return user != null ? Optional.ofNullable(user.getEmail()) : Optional.empty();
    }
    
    // Simple User class
    static class User {
        private String name;
        private String email;
        
        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
        
        public String getName() { return name; }
        public String getEmail() { return email; }
    }
}