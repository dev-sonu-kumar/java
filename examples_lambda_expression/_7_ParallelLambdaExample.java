import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class _7_ParallelLambdaExample {
    public static void main(String[] args) {
        // Large dataset for parallel processing
        List<Integer> largeList = IntStream.rangeClosed(1, 1000000)
            .boxed()
            .collect(Collectors.toList());
        
        // Sequential vs Parallel comparison
        System.out.println("=== Performance Comparison ===");
        
        // Sequential processing
        long startTime = System.currentTimeMillis();
        long sequentialSum = largeList.stream()
            .filter(n -> n % 2 == 0)
            .mapToLong(n -> n * n)
            .sum();
        long sequentialTime = System.currentTimeMillis() - startTime;
        
        // Parallel processing
        startTime = System.currentTimeMillis();
        long parallelSum = largeList.parallelStream()
            .filter(n -> n % 2 == 0)
            .mapToLong(n -> n * n)
            .sum();
        long parallelTime = System.currentTimeMillis() - startTime;
        
        System.out.println("Sequential sum: " + sequentialSum + " (Time: " + sequentialTime + "ms)");
        System.out.println("Parallel sum: " + parallelSum + " (Time: " + parallelTime + "ms)");
        System.out.println("Speedup: " + (double)sequentialTime / parallelTime + "x");
        
        // Parallel operations with custom objects
        List<Task> tasks = IntStream.range(1, 1001)
            .mapToObj(i -> new Task("Task-" + i, i))
            .collect(Collectors.toList());
        
        // Process tasks in parallel
        System.out.println("\n=== Parallel Task Processing ===");
        
        Map<String, List<Task>> tasksByPriority = tasks.parallelStream()
            .filter(task -> task.getPriority() > 500)
            .collect(Collectors.groupingBy(task -> 
                task.getPriority() > 800 ? "HIGH" : "MEDIUM"));
        
        tasksByPriority.forEach((priority, taskList) -> 
            System.out.println(priority + " priority tasks: " + taskList.size()));
        
        // Parallel reduction with custom combiner
        System.out.println("\n=== Custom Parallel Reduction ===");
        
        TaskSummary summary = tasks.parallelStream()
            .reduce(
                new TaskSummary(), // Identity
                (acc, task) -> {   // Accumulator
                    acc.addTask(task);
                    return acc;
                },
                (acc1, acc2) -> {  // Combiner (for parallel processing)
                    acc1.merge(acc2);
                    return acc1;
                }
            );
        
        System.out.println("Total tasks: " + summary.getCount());
        System.out.println("Average priority: " + summary.getAveragePriority());
        
        // CompletableFuture with lambda
        System.out.println("\n=== Async Processing with CompletableFuture ===");
        
        CompletableFuture<String> future1 = CompletableFuture
            .supplyAsync(() -> processData("Dataset1"))
            .thenApply(result -> "Processed: " + result);
        
        CompletableFuture<String> future2 = CompletableFuture
            .supplyAsync(() -> processData("Dataset2"))
            .thenApply(result -> "Processed: " + result);
        
        // Combine results
        CompletableFuture<String> combined = future1.thenCombine(future2, 
            (result1, result2) -> result1 + " & " + result2);
        
        try {
            System.out.println("Combined result: " + combined.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Parallel forEach with side effects (be careful!)
        System.out.println("\n=== Parallel forEach (with caution) ===");
        
        // Thread-safe collection for parallel operations
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        
        tasks.parallelStream()
             .filter(task -> task.getPriority() > 900)
             .forEach(task -> {
                 String category = "HIGH-" + (task.getPriority() / 100);
                 concurrentMap.merge(category, 1, Integer::sum);
             });
        
        concurrentMap.forEach((category, count) -> 
            System.out.println(category + ": " + count + " tasks"));
    }
    
    private static String processData(String dataset) {
        try {
            Thread.sleep(1000); // Simulate processing time
            return dataset + " processed";
        } catch (InterruptedException e) {
            return dataset + " failed";
        }
    }
}

class Task {
    private String name;
    private int priority;
    
    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    
    public String getName() { return name; }
    public int getPriority() { return priority; }
}

class TaskSummary {
    private int count = 0;
    private long totalPriority = 0;
    
    public void addTask(Task task) {
        count++;
        totalPriority += task.getPriority();
    }
    
    public void merge(TaskSummary other) {
        this.count += other.count;
        this.totalPriority += other.totalPriority;
    }
    
    public int getCount() { return count; }
    public double getAveragePriority() { 
        return count > 0 ? (double) totalPriority / count : 0; 
    }
}