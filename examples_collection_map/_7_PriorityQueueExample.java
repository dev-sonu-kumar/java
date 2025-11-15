package examples_collection_map;
import java.util.*;

public class _7_PriorityQueueExample {
    public static void main(String[] args) {
        // Min heap (default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(Arrays.asList(30, 10, 50, 20, 40));
        
        System.out.println("Min Heap: " + minHeap);
        System.out.println("Peek (min): " + minHeap.peek());
        
        // Poll elements (always gets minimum)
        while (!minHeap.isEmpty()) {
            System.out.println("Poll: " + minHeap.poll());
        }
        
        // Max heap (custom comparator)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.asList(30, 10, 50, 20, 40));
        
        System.out.println("Max Heap: " + maxHeap);
        System.out.println("Peek (max): " + maxHeap.peek());
        
        // Priority queue with custom objects
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.add(new Task("Low priority task", 3));
        taskQueue.add(new Task("High priority task", 1));
        taskQueue.add(new Task("Medium priority task", 2));
        
        System.out.println("Task Queue:");
        while (!taskQueue.isEmpty()) {
            System.out.println("Processing: " + taskQueue.poll());
        }
        
        // Custom comparator for complex sorting
        PriorityQueue<String> stringQueue = new PriorityQueue<>((a, b) -> {
            // Sort by length first, then alphabetically
            int lengthCompare = Integer.compare(a.length(), b.length());
            return lengthCompare != 0 ? lengthCompare : a.compareTo(b);
        });
        
        stringQueue.addAll(Arrays.asList("Java", "C", "Python", "Go", "JavaScript"));
        
        System.out.println("String Queue (by length then alphabetically):");
        while (!stringQueue.isEmpty()) {
            System.out.println(stringQueue.poll());
        }
    }
}

class Task implements Comparable<Task> {
    String name;
    int priority; // Lower number = higher priority
    
    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
    
    public String toString() {
        return name + " (priority: " + priority + ")";
    }
}