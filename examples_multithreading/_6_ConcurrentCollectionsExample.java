import java.util.concurrent.*;
import java.util.*;

public class _6_ConcurrentCollectionsExample {
    public static void main(String[] args) {
        System.out.println("=== Concurrent Collections Examples ===");
        
        // Thread-safe collections
        demonstrateConcurrentHashMap();
        demonstrateCopyOnWriteArrayList();
        demonstrateBlockingQueue();
        demonstrateConcurrentLinkedQueue();
        
        // Synchronizers
        demonstrateCountDownLatch();
        demonstrateCyclicBarrier();
        demonstrateSemaphore();
    }
    
    public static void demonstrateConcurrentHashMap() {
        System.out.println("\n1. ConcurrentHashMap:");
        
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Multiple threads updating the map
        for (int i = 1; i <= 3; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 1; j <= 5; j++) {
                    String key = "key" + j;
                    
                    // Atomic operations
                    map.putIfAbsent(key, 0);
                    map.compute(key, (k, v) -> v + threadId);
                    
                    System.out.println("Thread-" + threadId + " updated " + key + 
                                     " to " + map.get(key));
                }
            });
        }
        
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Final map: " + map);
    }
    
    public static void demonstrateCopyOnWriteArrayList() {
        System.out.println("\n2. CopyOnWriteArrayList:");
        
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        // Writer thread
        executor.submit(() -> {
            for (int i = 1; i <= 5; i++) {
                list.add("Item-" + i);
                System.out.println("Added: Item-" + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        // Reader thread
        executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Reading list: " + list);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void demonstrateBlockingQueue() {
        System.out.println("\n3. BlockingQueue (Producer-Consumer):");
        
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        
        // Producer
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    String item = "Product-" + i;
                    queue.put(item); // Blocks if queue is full
                    System.out.println("Produced: " + item + " (Queue size: " + queue.size() + ")");
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Consumer
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    String item = queue.take(); // Blocks if queue is empty
                    System.out.println("Consumed: " + item + " (Queue size: " + queue.size() + ")");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        producer.start();
        consumer.start();
        
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void demonstrateConcurrentLinkedQueue() {
        System.out.println("\n4. ConcurrentLinkedQueue:");
        
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Multiple producers
        for (int i = 1; i <= 2; i++) {
            final int producerId = i;
            executor.submit(() -> {
                for (int j = 1; j <= 3; j++) {
                    int item = producerId * 10 + j;
                    queue.offer(item);
                    System.out.println("Producer-" + producerId + " added: " + item);
                }
            });
        }
        
        // Consumer
        executor.submit(() -> {
            try {
                Thread.sleep(100); // Let producers add some items
                
                Integer item;
                while ((item = queue.poll()) != null) {
                    System.out.println("Consumed: " + item);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void demonstrateCountDownLatch() {
        System.out.println("\n5. CountDownLatch:");
        
        int numberOfTasks = 3;
        CountDownLatch latch = new CountDownLatch(numberOfTasks);
        
        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);
        
        // Submit tasks
        for (int i = 1; i <= numberOfTasks; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    System.out.println("Task-" + taskId + " starting...");
                    Thread.sleep(1000 + taskId * 500); // Different completion times
                    System.out.println("Task-" + taskId + " completed");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown(); // Decrement latch count
                }
            });
        }
        
        // Wait for all tasks to complete
        try {
            System.out.println("Waiting for all tasks to complete...");
            latch.await(); // Blocks until count reaches 0
            System.out.println("All tasks completed!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        executor.shutdown();
    }
    
    public static void demonstrateCyclicBarrier() {
        System.out.println("\n6. CyclicBarrier:");
        
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> {
            System.out.println("*** All threads reached barrier - continuing ***");
        });
        
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        
        for (int i = 1; i <= numberOfThreads; i++) {
            final int threadId = i;
            executor.submit(() -> {
                try {
                    System.out.println("Thread-" + threadId + " working on phase 1...");
                    Thread.sleep(1000 + threadId * 300);
                    System.out.println("Thread-" + threadId + " finished phase 1");
                    
                    barrier.await(); // Wait for all threads
                    
                    System.out.println("Thread-" + threadId + " working on phase 2...");
                    Thread.sleep(500);
                    System.out.println("Thread-" + threadId + " finished phase 2");
                    
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void demonstrateSemaphore() {
        System.out.println("\n7. Semaphore (Resource Pool):");
        
        Semaphore semaphore = new Semaphore(2); // Only 2 permits available
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        // Multiple threads trying to access limited resource
        for (int i = 1; i <= 5; i++) {
            final int threadId = i;
            executor.submit(() -> {
                try {
                    System.out.println("Thread-" + threadId + " waiting for permit...");
                    semaphore.acquire(); // Acquire permit
                    
                    System.out.println("Thread-" + threadId + " acquired permit, using resource");
                    Thread.sleep(2000); // Use resource
                    
                    System.out.println("Thread-" + threadId + " releasing permit");
                    
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release(); // Always release permit
                }
            });
        }
        
        executor.shutdown();
        try {
            executor.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Available permits: " + semaphore.availablePermits());
    }
}