package examples_collection;

import java.util.*;

public class _4_StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        
        // Push elements (LIFO - Last In First Out)
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        
        System.out.println("Stack: " + stack);
        
        // Peek (view top without removing)
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack after peek: " + stack);
        
        // Pop elements (remove from top)
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack after pops: " + stack);
        
        // Check if empty
        System.out.println("Is empty: " + stack.empty());
        
        // Search element (returns position from top, 1-based)
        stack.push("Apple");
        stack.push("Banana");
        System.out.println("Stack: " + stack);
        System.out.println("Position of 'First': " + stack.search("First"));
        System.out.println("Position of 'Apple': " + stack.search("Apple"));
        
        // Clear all
        while (!stack.empty()) {
            System.out.println("Removing: " + stack.pop());
        }
        
        System.out.println("Final stack empty: " + stack.empty());
    }
}