package examples_collection;

import java.util.*;

public class _3_VectorExample {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        
        // Add elements
        vector.add("Java");
        vector.add("Python");
        vector.addElement("C++");
        vector.insertElementAt("JavaScript", 1);
        
        System.out.println("Vector: " + vector);
        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.capacity());
        
        // Access elements
        System.out.println("First: " + vector.firstElement());
        System.out.println("Last: " + vector.lastElement());
        System.out.println("At index 2: " + vector.elementAt(2));
        
        // Check and search
        System.out.println("Contains Java: " + vector.contains("Java"));
        System.out.println("Index of Python: " + vector.indexOf("Python"));
        
        // Remove elements
        vector.removeElement("C++");
        vector.removeElementAt(0);
        System.out.println("After removal: " + vector);
        
        // Synchronized access (Vector is thread-safe)
        synchronized(vector) {
            for(String item : vector) {
                System.out.println("Item: " + item);
            }
        }
        
        // Clear and check
        vector.clear();
        System.out.println("Empty: " + vector.isEmpty());
    }
}