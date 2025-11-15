import java.util.concurrent.*;
import java.util.logging.*;

public class _6_ThreadExceptionExample {
    private static final Logger logger = Logger.getLogger(_6_ThreadExceptionExample.class.getName());
    
    public static void main(String[] args) {
        System.out.println("=== Thread Exception Handling ===");
        
        // Example 1: Basic thread exception handling
        demonstrateBasicThreadException();
        
        // Example 2: UncaughtExceptionHandler
        demonstrateUncaughtExceptionHandler();
        
        // Example 3: ExecutorService exception handling
        demonstrateExecutorServiceExceptions();
        
        // Example 4: CompletableFuture exception handling
        demonstrateCompletableFutureExceptions();
        
        // Example 5: Thread pool exception handling
        demonstrateThreadPoolExceptions();
        
        // Wait for async operations to complete
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void demonstrateBasicThreadException() {
        System.out.println("\n1. Basic Thread Exception:");
        
        // ❌ Exception in thread is not caught by main thread
        Thread thread1 = new Thread(() -> {
            throw new RuntimeException("Exception in thread1");
        });
        
        try {
            thread1.start();
            thread1.join(); // Wait for thread to complete
        } catch (Exception e) {
            System.out.println("This won't catch the thread exception: " + e.getMessage());
        }
    }
    
    public static void demonstrateUncaughtExceptionHandler() {
        System.out.println("\n2. UncaughtExceptionHandler:");
        
        // ✅ Proper way to handle uncaught exceptions in threads
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2 starting...");
            throw new RuntimeException("Exception in thread2");
        });
        
        thread2.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("✅ Caught exception in thread " + t.getName() + ": " + e.getMessage());
            logger.log(Level.SEVERE, "Uncaught exception in thread: " + t.getName(), e);
        });
        
        thread2.start();
        
        // Set default handler for all threads
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("✅ Default handler - Thread: " + t.getName() + ", Exception: " + e.getMessage());
        });
        
        Thread thread3 = new Thread(() -> {
            throw new RuntimeException("Exception in thread3");
        });
        thread3.start();
    }
    
    public static void demonstrateExecutorServiceExceptions() {
        System.out.println("\n3. ExecutorService Exception Handling:");
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        // ✅ Using submit() and Future to catch exceptions
        Future<?> future1 = executor.submit(() -> {
            System.out.println("Task 1 executing...");
            throw new RuntimeException("Exception in task 1");
        });
        
        try {
            future1.get(); // This will throw ExecutionException
        } catch (ExecutionException e) {
            System.out.println("✅ Caught exception from task 1: " + e.getCause().getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // ✅ Using submit() with Callable that returns result
        Future<String> future2 = executor.submit(() -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Random exception in task 2");
            }
            return "Task 2 completed successfully";
        });
        
        try {
            String result = future2.get(2, TimeUnit.SECONDS);
            System.out.println("✅ Task 2 result: " + result);
        } catch (ExecutionException e) {
            System.out.println("✅ Task 2 failed: " + e.getCause().getMessage());
        } catch (TimeoutException e) {
            System.out.println("✅ Task 2 timed out");
            future2.cancel(true);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        executor.shutdown();
    }
    
    public static void demonstrateCompletableFutureExceptions() {
        System.out.println("\n4. CompletableFuture Exception Handling:");
        
        // ✅ Exception handling with CompletableFuture
        CompletableFuture<String> future = CompletableFuture
            .supplyAsync(() -> {
                if (Math.random() > 0.5) {
                    throw new RuntimeException("Random failure in async operation");
                }
                return "Success result";
            })
            .exceptionally(throwable -> {
                System.out.println("✅ Exception handled: " + throwable.getMessage());
                return "Default result due to exception";
            });
        
        try {
            String result = future.get();
            System.out.println("✅ Final result: " + result);
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        
        // ✅ Chaining with exception handling
        CompletableFuture<String> chainedFuture = CompletableFuture
            .supplyAsync(() -> "Initial value")
            .thenApply(value -> {
                if (value.length() < 20) {
                    throw new RuntimeException("Value too short: " + value);
                }
                return value.toUpperCase();
            })
            .handle((result, throwable) -> {
                if (throwable != null) {
                    System.out.println("✅ Handled exception in chain: " + throwable.getMessage());
                    return "FALLBACK_VALUE";
                }
                return result;
            });
        
        try {
            System.out.println("✅ Chained result: " + chainedFuture.get());
        } catch (Exception e) {
            System.out.println("Chain exception: " + e.getMessage());
        }
    }
    
    public static void demonstrateThreadPoolExceptions() {
        System.out.println("\n5. Thread Pool Exception Handling:");
        
        // ✅ Custom ThreadFactory with exception handling
        ThreadFactory customThreadFactory = new ThreadFactory() {
            private int threadNumber = 1;
            
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, "CustomThread-" + threadNumber++);
                t.setUncaughtExceptionHandler((thread, exception) -> {
                    System.out.println("✅ Custom factory caught exception in " + thread.getName() + ": " + exception.getMessage());
                });
                return t;
            }
        };
        
        ExecutorService customExecutor = Executors.newFixedThreadPool(2, customThreadFactory);
        
        // Submit tasks that will throw exceptions
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            customExecutor.execute(() -> {
                System.out.println("Custom task " + taskId + " starting...");
                if (taskId % 2 == 0) {
                    throw new RuntimeException("Exception in custom task " + taskId);
                }
                System.out.println("Custom task " + taskId + " completed successfully");
            });
        }
        
        customExecutor.shutdown();
        
        // ✅ Monitoring thread pool for exceptions
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        scheduler.scheduleAtFixedRate(() -> {
            try {
                performPeriodicTask();
            } catch (Exception e) {
                System.out.println("✅ Exception in scheduled task: " + e.getMessage());
                // Log but don't let it kill the scheduler
                logger.log(Level.WARNING, "Scheduled task failed", e);
            }
        }, 0, 1, TimeUnit.SECONDS);
        
        // Shutdown scheduler after a short time
        scheduler.schedule(() -> {
            scheduler.shutdown();
            System.out.println("✅ Scheduler shutdown");
        }, 3, TimeUnit.SECONDS);
    }
    
    private static void performPeriodicTask() {
        if (Math.random() > 0.7) {
            throw new RuntimeException("Random failure in periodic task");
        }
        System.out.println("✅ Periodic task executed successfully");
    }
}

// Custom exception for thread operations
class ThreadOperationException extends Exception {
    public ThreadOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Worker class with proper exception handling
class SafeWorker implements Runnable {
    private final String taskName;
    
    public SafeWorker(String taskName) {
        this.taskName = taskName;
    }
    
    @Override
    public void run() {
        try {
            performWork();
        } catch (Exception e) {
            System.out.println("✅ SafeWorker " + taskName + " caught exception: " + e.getMessage());
            // Handle exception appropriately - log, retry, notify, etc.
        }
    }
    
    private void performWork() throws Exception {
        System.out.println("SafeWorker " + taskName + " performing work...");
        if (Math.random() > 0.5) {
            throw new Exception("Work failed for " + taskName);
        }
        System.out.println("SafeWorker " + taskName + " completed successfully");
    }
}