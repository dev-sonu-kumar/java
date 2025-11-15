/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates Java 8 Lambda expressions fundamentals:
 * 1. Basic lambda syntax and functional interfaces
 * 2. Method references
 * 3. Built-in functional interfaces
 * 4. Lambda with collections
 */

import java.util.*;
import java.util.function.*;

public class _1_LambdaBasicsExample {
    public static void main(String[] args) {
        System.out.println("=== Java 8 Lambda Expressions ===");
        
        // 1. Basic Lambda Syntax
        System.out.println("\n1. Basic Lambda Syntax:");
        
        // Traditional way
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("Traditional Runnable");
            }
        };
        
        // Lambda way
        Runnable r2 = () -> System.out.println("Lambda Runnable");
        
        r1.run();
        r2.run();
        
        // 2. Functional Interfaces
        System.out.println("\n2. Built-in Functional Interfaces:");
        
        // Predicate<T> - takes T, returns boolean
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        
        // Function<T,R> - takes T, returns R
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Java': " + stringLength.apply("Java"));
        
        // Consumer<T> - takes T, returns void
        Consumer<String> printer = s -> System.out.println("Printing: " + s);
        printer.accept("Hello Lambda");
        
        // Supplier<T> - takes nothing, returns T
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Random value: " + randomValue.get());
        
        // 3. Method References
        System.out.println("\n3. Method References:");
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // Lambda
        names.forEach(name -> System.out.println(name));
        
        // Method reference
        System.out.println("Using method reference:");
        names.forEach(System.out::println);
        
        // 4. Lambda with Collections
        System.out.println("\n4. Lambda with Collections:");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter even numbers
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(System.out::println);
    }
}