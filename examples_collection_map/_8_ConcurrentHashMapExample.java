package examples_collection_map;
import java.util.*;
import java.util.concurrent.*;

public class _8_ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        
        // Basic operations (thread-safe)
        map.put("Java", 25);
        map.put("Python", 30);
        map.put("C++", 20);
        
        System.out.println("ConcurrentHashMap: " + map);
        
        // Atomic operations
        map.putIfAbsent("Go", 15);
        map.replace("Java", 25, 35); // Replace only if current value matches
        map.compute("Python", (k, v) -> v + 5);
        map.merge("Rust", 10, Integer::sum);
        
        // Bulk operations (Java 8)
        map.forEach(1, (k, v) -> System.out.println(k + " = " + v));
        
        Integer sum = map.reduceValues(1, Integer::sum);
        System.out.println("Sum of all values: " + sum);
        
        // Search operations
        String result = map.search(1, (k, v) -> v > 30 ? k : null);
        System.out.println("First key with value > 30: " + result);
        
        // Thread-safe iteration
        demonstrateThreadSafety(map);
        
        System.out.println("Final map: " + map);
    }
    
    static void demonstrateThreadSafety(ConcurrentHashMap<String, Integer> map) {
        // Safe to iterate while other threads modify
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Reading: " + entry.getKey());
            // Safe to modify during iteration
            map.putIfAbsent("NewKey" + entry.getValue(), entry.getValue());
        }
    }
}