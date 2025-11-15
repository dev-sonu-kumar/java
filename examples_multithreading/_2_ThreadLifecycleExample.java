public class _2_ThreadLifecycleExample {
    public static void main(String[] args) {
        System.out.println("=== Thread Lifecycle States ===");
        
        // Create thread (NEW state)
        LifecycleThread thread = new LifecycleThread();
        System.out.println("1. After creation: " + thread.getState()); // NEW
        
        // Start thread (RUNNABLE state)
        thread.start();
        System.out.println("2. After start(): " + thread.getState()); // RUNNABLE
        
        // Monitor thread states
        Thread monitor = new Thread(() -> {
            try {
                Thread.sleep(100);
                System.out.println("3. During sleep: " + thread.getState()); // TIMED_WAITING
                
                Thread.sleep(2000);
                System.out.println("4. During wait: " + thread.getState()); // WAITING
                
                // Interrupt the thread
                thread.interrupt();
                Thread.sleep(100);
                System.out.println("5. After interrupt: " + thread.getState()); // TERMINATED
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        monitor.start();
        
        // Wait for threads to complete
        try {
            thread.join();
            monitor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("6. Final state: " + thread.getState()); // TERMINATED
        
        // Demonstrate thread interruption
        demonstrateInterruption();
        
        // Demonstrate thread priorities
        demonstratePriorities();
    }
    
    public static void demonstrateInterruption() {
        System.out.println("\n=== Thread Interruption ===");
        
        Thread worker = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    // Check for interruption
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Worker thread interrupted at iteration " + i);
                        return;
                    }
                    
                    System.out.println("Working... " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("Worker thread interrupted during sleep");
                Thread.currentThread().interrupt(); // Restore interrupt status
            }
        });
        
        worker.start();
        
        // Interrupt after 2 seconds
        try {
            Thread.sleep(2000);
            worker.interrupt();
            worker.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void demonstratePriorities() {
        System.out.println("\n=== Thread Priorities ===");
        
        Thread lowPriority = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Low priority: " + i);
                Thread.yield(); // Hint to scheduler
            }
        });
        
        Thread highPriority = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("High priority: " + i);
                Thread.yield();
            }
        });
        
        // Set priorities
        lowPriority.setPriority(Thread.MIN_PRIORITY);   // 1
        highPriority.setPriority(Thread.MAX_PRIORITY);  // 10
        
        System.out.println("Low priority: " + lowPriority.getPriority());
        System.out.println("High priority: " + highPriority.getPriority());
        
        lowPriority.start();
        highPriority.start();
        
        try {
            lowPriority.join();
            highPriority.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class LifecycleThread extends Thread {
    private final Object lock = new Object();
    
    @Override
    public void run() {
        try {
            // TIMED_WAITING state
            System.out.println("Thread going to sleep...");
            Thread.sleep(1000);
            
            // WAITING state
            synchronized (lock) {
                System.out.println("Thread going to wait...");
                lock.wait(); // Will wait until interrupted
            }
            
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Thread finishing...");
    }
}

// Thread state demonstration
class StateMonitor {
    public static void printThreadState(Thread thread, String description) {
        System.out.println(description + ": " + thread.getState() + 
                          " (Alive: " + thread.isAlive() + ")");
    }
}