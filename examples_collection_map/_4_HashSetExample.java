package examples_collection_map;
import java.util.*;

public class _4_HashSetExample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        
        // Add elements (no duplicates)
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java"); // Duplicate, won't be added
        
        System.out.println("HashSet: " + set);
        System.out.println("Size: " + set.size());
        
        // Check operations
        System.out.println("Contains Java: " + set.contains("Java"));
        System.out.println("Contains PHP: " + set.contains("PHP"));
        
        // Remove operations
        set.remove("C++");
        System.out.println("After removal: " + set);
        
        // Set operations
        HashSet<String> set2 = new HashSet<>(Arrays.asList("Python", "Go", "Rust"));
        
        // Union
        HashSet<String> union = new HashSet<>(set);
        union.addAll(set2);
        System.out.println("Union: " + union);
        
        // Intersection
        HashSet<String> intersection = new HashSet<>(set);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
        
        // Difference
        HashSet<String> difference = new HashSet<>(set);
        difference.removeAll(set2);
        System.out.println("Difference: " + difference);
        
        // Iteration
        for (String lang : set) {
            System.out.println("Language: " + lang);
        }
        
        // Convert to array
        String[] array = set.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(array));
    }
}