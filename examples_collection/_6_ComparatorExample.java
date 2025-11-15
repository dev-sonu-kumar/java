package examples_collection;

import java.util.*;

class LengthComparator implements Comparator<String> {
    public int compare(String a, String b) {
        return Integer.compare(a.length(), b.length());
    }
}

public class _6_ComparatorExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        
        // Natural order
        Collections.sort(names);
        System.out.println("Sorted: " + names);
        
        // Reverse order
        names.sort(Comparator.reverseOrder());
        System.out.println("Reverse: " + names);
        
        // By length
        names.sort(Comparator.comparing(String::length));
        System.out.println("By length: " + names);
        
        // Lambda expressions
        names.sort((a, b) -> a.compareTo(b));
        System.out.println("Lambda sort: " + names);
        
        names.sort((a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("Lambda by length: " + names);
        
        names.sort((a, b) -> b.compareTo(a));
        System.out.println("Lambda reverse: " + names);
        
        // Custom Comparator class
        names.sort(new LengthComparator());
        System.out.println("Custom class: " + names);
    }
}
