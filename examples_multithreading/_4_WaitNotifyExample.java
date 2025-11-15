public class _4_WaitNotifyExample {
    public static void main(String[] args) {
        System.out.println("=== Wait-Notify Communication ===");
        
        // Producer-Consumer pattern
        demonstrateProducerConsumer();
        
        // Wait-Notify with conditions
        demonstrateConditionalWaitNotify();
        
        // NotifyAll example
        demonstrateNotifyAll();
    }
    
    public static void demonstrateProducerConsumer() {
        System.out.println("\n1. Producer-Consumer Pattern:");
        
        SharedBuffer buffer = new SharedBuffer(5);
        
        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.consume();
                    Thread.sleep(150);
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
    
    public static void demonstrateConditionalWaitNotify() {
        System.out.println("\n2. Conditional Wait-Notify:");
        
        TaskQueue taskQueue = new TaskQueue();
        
        // Worker threads
        Thread worker1 = new Thread(() -> taskQueue.processTask("Worker-1"));
        Thread worker2 = new Thread(() -> taskQueue.processTask("Worker-2"));
        
        // Task submitter
        Thread submitter = new Thread(() -> {
            try {
                Thread.sleep(1000);
                taskQueue.submitTask("Task-1");
                
                Thread.sleep(1000);
                taskQueue.submitTask("Task-2");
                
                Thread.sleep(1000);
                taskQueue.submitTask("Task-3");
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        worker1.start();
        worker2.start();
        submitter.start();
        
        try {
            submitter.join();
            Thread.sleep(2000); // Let workers finish
            worker1.interrupt();
            worker2.interrupt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void demonstrateNotifyAll() {
        System.out.println("\n3. NotifyAll Example:");
        
        Barrier barrier = new Barrier(3);
        
        // Create multiple threads that wait at barrier
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i + 1;
            threads[i] = new Thread(() -> {
                try {
                    System.out.println("Thread-" + threadId + " working...");
                    Thread.sleep(1000 + threadId * 500); // Different work times
                    
                    barrier.await("Thread-" + threadId);
                    
                    System.out.println("Thread-" + threadId + " continuing after barrier");
                    
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        for (Thread thread : threads) {
            thread.start();
        }
        
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Producer-Consumer with bounded buffer
class SharedBuffer {
    private final int[] buffer;
    private int count = 0;
    private int in = 0;
    private int out = 0;
    private final int capacity;
    
    public SharedBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
    }
    
    public synchronized void produce(int item) throws InterruptedException {
        // Wait while buffer is full
        while (count == capacity) {
            System.out.println("Buffer full, producer waiting...");
            wait();
        }
        
        // Produce item
        buffer[in] = item;
        in = (in + 1) % capacity;
        count++;
        
        System.out.println("Produced: " + item + " (Buffer size: " + count + ")");
        
        // Notify waiting consumers
        notifyAll();
    }
    
    public synchronized int consume() throws InterruptedException {
        // Wait while buffer is empty
        while (count == 0) {
            System.out.println("Buffer empty, consumer waiting...");
            wait();
        }
        
        // Consume item
        int item = buffer[out];
        out = (out + 1) % capacity;
        count--;
        
        System.out.println("Consumed: " + item + " (Buffer size: " + count + ")");
        
        // Notify waiting producers
        notifyAll();
        
        return item;
    }
}

// Task queue with wait-notify
class TaskQueue {
    private String currentTask = null;
    private boolean taskAvailable = false;
    
    public synchronized void submitTask(String task) {
        currentTask = task;
        taskAvailable = true;
        System.out.println("Task submitted: " + task);
        notify(); // Wake up one waiting worker
    }
    
    public synchronized void processTask(String workerName) {
        try {
            while (true) {
                // Wait for task
                while (!taskAvailable) {
                    System.out.println(workerName + " waiting for task...");
                    wait();
                }
                
                // Process task
                String task = currentTask;
                taskAvailable = false;
                
                System.out.println(workerName + " processing: " + task);
                Thread.sleep(500); // Simulate work
                System.out.println(workerName + " completed: " + task);
            }
        } catch (InterruptedException e) {
            System.out.println(workerName + " interrupted");
            Thread.currentThread().interrupt();
        }
    }
}

// Barrier synchronization with notifyAll
class Barrier {
    private final int totalThreads;
    private int waitingThreads = 0;
    
    public Barrier(int totalThreads) {
        this.totalThreads = totalThreads;
    }
    
    public synchronized void await(String threadName) throws InterruptedException {
        waitingThreads++;
        System.out.println(threadName + " reached barrier (" + 
                          waitingThreads + "/" + totalThreads + ")");
        
        if (waitingThreads == totalThreads) {
            // All threads reached barrier
            System.out.println("All threads reached barrier - releasing all!");
            notifyAll(); // Wake up all waiting threads
        } else {
            // Wait for other threads
            while (waitingThreads < totalThreads) {
                wait();
            }
        }
    }
}