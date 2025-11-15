package examples_collection_map;
import java.util.*;

public class _1_HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // Put key-value pairs
        map.put("Java", 25);
        map.put("Python", 30);
        map.put("C++", 20);
        map.put("JavaScript", 15);
        
        System.out.println("HashMap: " + map);
        
        // Get values
        System.out.println("Java: " + map.get("Java"));
        System.out.println("PHP: " + map.get("PHP")); // null
        System.out.println("PHP with default: " + map.getOrDefault("PHP", 0));
        
        // Check operations
        System.out.println("Contains Java: " + map.containsKey("Java"));
        System.out.println("Contains value 30: " + map.containsValue(30));
        
        // Update value
        map.put("Java", 35); // Updates existing
        map.putIfAbsent("Go", 10); // Only if key doesn't exist
        
        // Remove operations
        map.remove("C++");
        map.remove("Python", 30); // Remove only if key-value matches
        
        // Iteration
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        
        // Java 8 operations
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        map.compute("Java", (k, v) -> v + 5);
        map.merge("Rust", 12, Integer::sum);
        
        System.out.println("Final map: " + map);
    }
}