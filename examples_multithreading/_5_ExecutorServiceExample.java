import java.util.concurrent.*;
import java.util.*;

public class _5_ExecutorServiceExample {
    public static void main(String[] args) {
        System.out.println("=== ExecutorService Examples ===");
        
        // Different types of thread pools
        demonstrateFixedThreadPool();
        demonstrateCachedThreadPool();
        demonstrateSingleThreadExecutor();
        demonstrateScheduledExecutor();
        
        // Callable and Future
        demonstrateCallableAndFuture();
        
        // CompletionService
        demonstrateCompletionService();
    }
    
    public static void demonstrateFixedThreadPool() {
        System.out.println("\n1. Fixed Thread Pool:");
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Submit multiple tasks
        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " started by " + 
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " completed");
            });
        }
        
        shutdownExecutor(executor);
    }
    
    public static void demonstrateCachedThreadPool() {
        System.out.println("\n2. Cached Thread Pool:");
        
        ExecutorService executor = Executors.newCachedThreadPool();
        
        // Submit tasks with varying delays
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Cached task " + taskId + " by " + 
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            
            // Add delay between submissions
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        shutdownExecutor(executor);
    }
    
    public static void demonstrateSingleThreadExecutor() {
        System.out.println("\n3. Single Thread Executor:");
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        // All tasks will execute sequentially
        for (int i = 1; i <= 4; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Sequential task " + taskId + " by " + 
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        shutdownExecutor(executor);
    }
    
    public static void demonstrateScheduledExecutor() {
        System.out.println("\n4. Scheduled Executor:");
        
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        
        // Schedule one-time task
        scheduler.schedule(() -> {
            System.out.println("One-time scheduled task executed");
        }, 1, TimeUnit.SECONDS);
        
        // Schedule repeating task
        ScheduledFuture<?> repeatingTask = scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Repeating task: " + new Date());
        }, 0, 500, TimeUnit.MILLISECONDS);
        
        // Cancel repeating task after 3 seconds
        scheduler.schedule(() -> {
            repeatingTask.cancel(false);
            System.out.println("Repeating task cancelled");
        }, 3, TimeUnit.SECONDS);
        
        // Shutdown after 4 seconds
        scheduler.schedule(() -> {
            scheduler.shutdown();
        }, 4, TimeUnit.SECONDS);
        
        try {
            scheduler.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void demonstrateCallableAndFuture() {
        System.out.println("\n5. Callable and Future:");
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Submit Callable tasks that return values
        List<Future<Integer>> futures = new ArrayList<>();
        
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            Future<Integer> future = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println("Calculating square of " + taskId);
                    Thread.sleep(1000);
                    return taskId * taskId;
                }
            });
            futures.add(future);
        }
        
        // Collect results
        for (int i = 0; i < futures.size(); i++) {
            try {
                Integer result = futures.get(i).get(); // Blocking call
                System.out.println("Result " + (i + 1) + ": " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Task failed: " + e.getMessage());
            }
        }
        
        shutdownExecutor(executor);
    }
    
    public static void demonstrateCompletionService() {
        System.out.println("\n6. CompletionService:");
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);
        
        // Submit tasks with different execution times
        String[] tasks = {"Fast task", "Medium task", "Slow task"};
        int[] delays = {500, 1000, 1500};
        
        for (int i = 0; i < tasks.length; i++) {
            final String taskName = tasks[i];
            final int delay = delays[i];
            
            completionService.submit(() -> {
                try {
                    Thread.sleep(delay);
                    return taskName + " completed";
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return taskName + " interrupted";
                }
            });
        }
        
        // Process results as they complete (not in submission order)
        for (int i = 0; i < tasks.length; i++) {
            try {
                Future<String> future = completionService.take(); // Blocks until result available
                String result = future.get();
                System.out.println("Completed: " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        shutdownExecutor(executor);
    }
    
    private static void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

// Custom task class
class NumberProcessor implements Callable<Integer> {
    private final int number;
    
    public NumberProcessor(int number) {
        this.number = number;
    }
    
    @Override
    public Integer call() throws Exception {
        System.out.println("Processing number: " + number);
        
        // Simulate complex calculation
        Thread.sleep(500);
        
        // Return factorial
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        
        System.out.println("Factorial of " + number + " = " + result);
        return result;
    }
}

// Task with exception handling
class RiskyTask implements Callable<String> {
    private final int taskId;
    
    public RiskyTask(int taskId) {
        this.taskId = taskId;
    }
    
    @Override
    public String call() throws Exception {
        if (taskId % 3 == 0) {
            throw new RuntimeException("Task " + taskId + " failed!");
        }
        
        Thread.sleep(1000);
        return "Task " + taskId + " successful";
    }
}