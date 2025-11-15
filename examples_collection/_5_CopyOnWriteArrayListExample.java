package examples_collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class _5_CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        
        // Add elements
        list.add("Java");
        list.add("Python");
        list.add("C++");
        
        System.out.println("List: " + list);
        
        // Thread-safe iteration (no ConcurrentModificationException)
        for (String item : list) {
            System.out.println("Reading: " + item);
            if (item.equals("Python")) {
                list.add("JavaScript"); // Safe to modify during iteration
            }
        }
        
        System.out.println("After modification: " + list);
        
        // Basic operations
        System.out.println("Size: " + list.size());
        System.out.println("Contains Java: " + list.contains("Java"));
        System.out.println("Index of C++: " + list.indexOf("C++"));
        
        // Remove elements
        list.remove("Python");
        list.remove(0);
        System.out.println("After removal: " + list);
        
        // Convert to array
        String[] array = list.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(array));
        
        // Clear
        list.clear();
        System.out.println("Empty: " + list.isEmpty());
        
        // Demonstrate thread safety
        demonstrateThreadSafety();
    }
    
    static void demonstrateThreadSafety() {
        CopyOnWriteArrayList<Integer> threadSafeList = new CopyOnWriteArrayList<>();
        
        // Add initial elements
        for (int i = 0; i < 5; i++) {
            threadSafeList.add(i);
        }
        
        System.out.println("Thread-safe operations: " + threadSafeList);
        
        // Safe concurrent access (no synchronization needed)
        threadSafeList.forEach(System.out::println);
    }
}