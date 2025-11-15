package examples_collection_map;
import java.util.*;

public class _2_LinkedHashMapExample {
    public static void main(String[] args) {
        // Maintains insertion order
        LinkedHashMap<String, Integer> insertionOrder = new LinkedHashMap<>();
        insertionOrder.put("First", 1);
        insertionOrder.put("Second", 2);
        insertionOrder.put("Third", 3);
        
        System.out.println("Insertion order: " + insertionOrder);
        
        // Access order LinkedHashMap (LRU cache behavior)
        LinkedHashMap<String, Integer> accessOrder = new LinkedHashMap<>(16, 0.75f, true);
        accessOrder.put("A", 1);
        accessOrder.put("B", 2);
        accessOrder.put("C", 3);
        
        System.out.println("Before access: " + accessOrder);
        accessOrder.get("A"); // Access A, moves to end
        System.out.println("After accessing A: " + accessOrder);
        
        // LRU Cache implementation
        LinkedHashMap<String, String> lruCache = new LinkedHashMap<String, String>(3, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > 3; // Remove oldest when size > 3
            }
        };
        
        lruCache.put("1", "One");
        lruCache.put("2", "Two");
        lruCache.put("3", "Three");
        System.out.println("LRU Cache: " + lruCache);
        
        lruCache.put("4", "Four"); // Removes "1"
        System.out.println("After adding 4th: " + lruCache);
        
        lruCache.get("2"); // Access "2", moves to end
        lruCache.put("5", "Five"); // Removes "3"
        System.out.println("Final LRU: " + lruCache);
    }
}