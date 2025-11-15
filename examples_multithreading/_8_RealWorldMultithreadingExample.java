import java.util.concurrent.*;
import java.util.*;
import java.util.concurrent.atomic.*;

public class _8_RealWorldMultithreadingExample {
    public static void main(String[] args) {
        System.out.println("=== Real-World Multithreading Scenarios ===");
        
        // Web server simulation
        demonstrateWebServer();
        
        // Batch processing system
        demonstrateBatchProcessing();
        
        // Producer-consumer with multiple producers/consumers
        demonstrateMultiProducerConsumer();
        
        // Cache with concurrent access
        demonstrateConcurrentCache();
    }
    
    public static void demonstrateWebServer() {
        System.out.println("\n1. Web Server Simulation:");
        
        WebServer server = new WebServer(5); // 5 worker threads
        
        // Simulate incoming requests
        for (int i = 1; i <= 10; i++) {
            final int requestId = i;
            new Thread(() -> {
                server.handleRequest("Request-" + requestId);
            }).start();
            
            try {
                Thread.sleep(100); // Requests arrive every 100ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // Shutdown server after processing
        try {
            Thread.sleep(5000);
            server.shutdown();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void demonstrateBatchProcessing() {
        System.out.println("\n2. Batch Processing System:");
        
        BatchProcessor processor = new BatchProcessor(3);
        
        // Create batch of items to process
        List<String> items = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            items.add("Item-" + i);
        }
        
        processor.processBatch(items);
        processor.shutdown();
    }
    
    public static void demonstrateMultiProducerConsumer() {
        System.out.println("\n3. Multi-Producer-Consumer:");
        
        BlockingQueue<Task> taskQueue = new LinkedBlockingQueue<>(10);
        ExecutorService executor = Executors.newFixedThreadPool(6);
        
        // Multiple producers
        for (int i = 1; i <= 3; i++) {
            final int producerId = i;
            executor.submit(() -> {
                try {
                    for (int j = 1; j <= 5; j++) {
                        Task task = new Task("P" + producerId + "-T" + j, j * 100);
                        taskQueue.put(task);
                        System.out.println("Producer-" + producerId + " created: " + task.getId());
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        // Multiple consumers
        for (int i = 1; i <= 3; i++) {
            final int consumerId = i;
            executor.submit(() -> {
                try {
                    while (true) {
                        Task task = taskQueue.take();
                        System.out.println("Consumer-" + consumerId + " processing: " + task.getId());
                        Thread.sleep(task.getProcessingTime());
                        System.out.println("Consumer-" + consumerId + " completed: " + task.getId());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        // Shutdown after some time
        try {
            Thread.sleep(8000);
            executor.shutdownNow();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void demonstrateConcurrentCache() {
        System.out.println("\n4. Concurrent Cache:");
        
        ConcurrentCache<String, String> cache = new ConcurrentCache<>(100);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        // Multiple threads accessing cache
        for (int i = 1; i <= 5; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 1; j <= 10; j++) {
                    String key = "key" + (j % 5); // Some key overlap
                    String value = cache.get(key);
                    
                    if (value == null) {
                        value = "value-" + threadId + "-" + j;
                        cache.put(key, value);
                        System.out.println("Thread-" + threadId + " cached: " + key + " = " + value);
                    } else {
                        System.out.println("Thread-" + threadId + " found cached: " + key + " = " + value);
                    }
                    
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
        
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Cache statistics: " + cache.getStatistics());
    }
}

// Web server with thread pool
class WebServer {
    private final ExecutorService threadPool;
    private final AtomicInteger requestCounter = new AtomicInteger(0);
    
    public WebServer(int poolSize) {
        this.threadPool = Executors.newFixedThreadPool(poolSize);
    }
    
    public void handleRequest(String requestId) {
        threadPool.submit(() -> {
            try {
                int requestNumber = requestCounter.incrementAndGet();
                System.out.println("Processing " + requestId + " (#" + requestNumber + 
                                 ") on " + Thread.currentThread().getName());
                
                // Simulate request processing
                Thread.sleep(1000 + (int)(Math.random() * 1000));
                
                System.out.println("Completed " + requestId + " (#" + requestNumber + ")");
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
    
    public void shutdown() {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(5, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("Web server shutdown complete");
    }
}

// Batch processor with work distribution
class BatchProcessor {
    private final ExecutorService executor;
    private final int numberOfWorkers;
    
    public BatchProcessor(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
        this.executor = Executors.newFixedThreadPool(numberOfWorkers);
    }
    
    public void processBatch(List<String> items) {
        int batchSize = (items.size() + numberOfWorkers - 1) / numberOfWorkers;
        List<Future<Integer>> futures = new ArrayList<>();
        
        for (int i = 0; i < numberOfWorkers; i++) {
            int start = i * batchSize;
            int end = Math.min(start + batchSize, items.size());
            
            if (start < items.size()) {
                List<String> batch = items.subList(start, end);
                final int workerId = i + 1;
                
                Future<Integer> future = executor.submit(() -> {
                    int processed = 0;
                    for (String item : batch) {
                        try {
                            System.out.println("Worker-" + workerId + " processing: " + item);
                            Thread.sleep(300); // Simulate processing
                            processed++;
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                    }
                    System.out.println("Worker-" + workerId + " completed " + processed + " items");
                    return processed;
                });
                
                futures.add(future);
            }
        }
        
        // Collect results
        int totalProcessed = 0;
        for (Future<Integer> future : futures) {
            try {
                totalProcessed += future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error in batch processing: " + e.getMessage());
            }
        }
        
        System.out.println("Batch processing complete. Total processed: " + totalProcessed);
    }
    
    public void shutdown() {
        executor.shutdown();
    }
}

// Task class for producer-consumer
class Task {
    private final String id;
    private final long processingTime;
    
    public Task(String id, long processingTime) {
        this.id = id;
        this.processingTime = processingTime;
    }
    
    public String getId() { return id; }
    public long getProcessingTime() { return processingTime; }
}

// Thread-safe cache with statistics
class ConcurrentCache<K, V> {
    private final ConcurrentHashMap<K, V> cache;
    private final AtomicLong hits = new AtomicLong(0);
    private final AtomicLong misses = new AtomicLong(0);
    private final int maxSize;
    
    public ConcurrentCache(int maxSize) {
        this.maxSize = maxSize;
        this.cache = new ConcurrentHashMap<>();
    }
    
    public V get(K key) {
        V value = cache.get(key);
        if (value != null) {
            hits.incrementAndGet();
        } else {
            misses.incrementAndGet();
        }
        return value;
    }
    
    public void put(K key, V value) {
        if (cache.size() >= maxSize) {
            // Simple eviction: remove a random entry
            K randomKey = cache.keys().nextElement();
            cache.remove(randomKey);
        }
        cache.put(key, value);
    }
    
    public String getStatistics() {
        long totalRequests = hits.get() + misses.get();
        double hitRate = totalRequests > 0 ? (double) hits.get() / totalRequests * 100 : 0;
        
        return String.format("Size: %d, Hits: %d, Misses: %d, Hit Rate: %.2f%%", 
                           cache.size(), hits.get(), misses.get(), hitRate);
    }
}

// Connection pool simulation
class ConnectionPool {
    private final BlockingQueue<Connection> pool;
    private final AtomicInteger activeConnections = new AtomicInteger(0);
    private final int maxConnections;
    
    public ConnectionPool(int maxConnections) {
        this.maxConnections = maxConnections;
        this.pool = new LinkedBlockingQueue<>();
        
        // Initialize pool with connections
        for (int i = 0; i < maxConnections; i++) {
            pool.offer(new Connection("Connection-" + (i + 1)));
        }
    }
    
    public Connection getConnection() throws InterruptedException {
        Connection conn = pool.take(); // Blocks if no connections available
        activeConnections.incrementAndGet();
        return conn;
    }
    
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            pool.offer(connection);
            activeConnections.decrementAndGet();
        }
    }
    
    public int getActiveConnections() {
        return activeConnections.get();
    }
    
    public int getAvailableConnections() {
        return pool.size();
    }
}

class Connection {
    private final String id;
    
    public Connection(String id) {
        this.id = id;
    }
    
    public String getId() { return id; }
    
    public void execute(String query) {
        System.out.println(id + " executing: " + query);
    }
}