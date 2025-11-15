package examples_collection;

import java.util.*;

public class _2_LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        
        // Add elements
        list.add("Java");
        list.add("Python");
        list.addFirst("C++");
        list.addLast("JavaScript");
        
        System.out.println("List: " + list);
        
        // Access elements
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("At index 1: " + list.get(1));
        
        // Remove elements
        list.removeFirst();
        list.removeLast();
        System.out.println("After removal: " + list);
        
        // Use as Stack (LIFO)
        list.push("Go");
        list.push("Rust");
        System.out.println("Stack operations: " + list);
        System.out.println("Pop: " + list.pop());
        
        // Use as Queue (FIFO)
        list.offer("Swift");
        System.out.println("Queue operations: " + list);
        System.out.println("Poll: " + list.poll());
        
        System.out.println("Final list: " + list);
    }
}