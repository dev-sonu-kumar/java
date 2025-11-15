/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates Java 8 Stream API:
 * 1. Stream creation and basic operations
 * 2. Intermediate operations (filter, map, sorted)
 * 3. Terminal operations (collect, reduce, forEach)
 * 4. Parallel streams
 */

import java.util.*;
import java.util.stream.*;

public class _2_StreamAPIExample {
    public static void main(String[] args) {
        System.out.println("=== Java 8 Stream API ===");
        
        // 1. Stream Creation
        System.out.println("\n1. Stream Creation:");
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<String> names = Stream.of("Alice", "Bob", "Charlie", "David");
        
        // 2. Filter and Map
        System.out.println("\n2. Filter and Map Operations:");
        
        List<Integer> evenSquares = numbers.stream()
                                          .filter(n -> n % 2 == 0)
                                          .map(n -> n * n)
                                          .collect(Collectors.toList());
        
        System.out.println("Even squares: " + evenSquares);
        
        // 3. Sorting and Limiting
        System.out.println("\n3. Sorting and Limiting:");
        
        List<String> sortedNames = Stream.of("Charlie", "Alice", "Bob", "David")
                                        .sorted()
                                        .limit(3)
                                        .collect(Collectors.toList());
        
        System.out.println("First 3 sorted names: " + sortedNames);
        
        // 4. Reduce Operations
        System.out.println("\n4. Reduce Operations:");
        
        int sum = numbers.stream()
                        .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        
        Optional<Integer> max = numbers.stream()
                                      .max(Integer::compareTo);
        System.out.println("Max: " + max.orElse(0));
        
        // 5. Collectors
        System.out.println("\n5. Collectors:");
        
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                                                        .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        
        System.out.println("Even numbers: " + partitioned.get(true));
        System.out.println("Odd numbers: " + partitioned.get(false));
        
        // 6. Parallel Streams
        System.out.println("\n6. Parallel Streams:");
        
        long parallelSum = numbers.parallelStream()
                                 .mapToLong(Integer::longValue)
                                 .sum();
        
        System.out.println("Parallel sum: " + parallelSum);
    }
}