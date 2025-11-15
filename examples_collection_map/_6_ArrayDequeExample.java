package examples_collection_map;
import java.util.*;

public class _6_ArrayDequeExample {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        
        // Add elements at both ends
        deque.addFirst("Second");
        deque.addLast("Third");
        deque.addFirst("First");
        deque.addLast("Fourth");
        
        System.out.println("Deque: " + deque);
        
        // Peek operations (don't remove)
        System.out.println("Peek first: " + deque.peekFirst());
        System.out.println("Peek last: " + deque.peekLast());
        
        // Remove operations
        System.out.println("Remove first: " + deque.removeFirst());
        System.out.println("Remove last: " + deque.removeLast());
        System.out.println("After removal: " + deque);
        
        // Use as Stack (LIFO)
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Stack: " + stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        
        // Use as Queue (FIFO)
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        
        System.out.println("Queue: " + queue);
        System.out.println("Poll: " + queue.poll());
        System.out.println("Remaining: " + queue);
        
        // Iteration
        ArrayDeque<String> colors = new ArrayDeque<>(Arrays.asList("Red", "Green", "Blue"));
        
        // Forward iteration
        Iterator<String> iterator = colors.iterator();
        while (iterator.hasNext()) {
            System.out.println("Forward: " + iterator.next());
        }
        
        // Reverse iteration
        Iterator<String> descendingIterator = colors.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println("Reverse: " + descendingIterator.next());
        }
    }
}