import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Create ArrayList
        ArrayList<String> list = new ArrayList<>();
        
        // Add elements
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add(1, "JavaScript"); // Insert at index
        
        // Access elements
        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("Size: " + list.size());
        
        // Check if contains
        System.out.println("Contains Java: " + list.contains("Java"));
        
        // Update element
        list.set(2, "Go");
        
        // Remove elements
        list.remove("Python");
        list.remove(0); // Remove by index
        
        // Iterate
        for(String lang : list) {
            System.out.println(lang);
        }
        
        // Check if empty
        System.out.println("Is empty: " + list.isEmpty());
        
        // Clear all
        list.clear();
        System.out.println("After clear, size: " + list.size());
    }
}