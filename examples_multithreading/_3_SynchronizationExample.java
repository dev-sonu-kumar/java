public class _3_SynchronizationExample {
    public static void main(String[] args) {
        System.out.println("=== Synchronization Examples ===");
        
        // Problem: Race condition without synchronization
        demonstrateRaceCondition();
        
        // Solution 1: Synchronized methods
        demonstrateSynchronizedMethods();
        
        // Solution 2: Synchronized blocks
        demonstrateSynchronizedBlocks();
        
        // Solution 3: Static synchronization
        demonstrateStaticSynchronization();
    }
    
    public static void demonstrateRaceCondition() {
        System.out.println("\n1. Race Condition Problem:");
        
        UnsafeCounter counter = new UnsafeCounter();
        
        // Create multiple threads that increment counter
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
        }
        
        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }
        
        // Wait for all threads to complete
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Expected: 5000, Actual: " + counter.getCount());
        System.out.println("Race condition occurred: " + (counter.getCount() != 5000));
    }
    
    public static void demonstrateSynchronizedMethods() {
        System.out.println("\n2. Synchronized Methods Solution:");
        
        SafeCounter counter = new SafeCounter();
        
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
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
        
        System.out.println("Expected: 5000, Actual: " + counter.getCount());
        System.out.println("Synchronization successful: " + (counter.getCount() == 5000));
    }
    
    public static void demonstrateSynchronizedBlocks() {
        System.out.println("\n3. Synchronized Blocks:");
        
        BankAccount account = new BankAccount(1000);
        
        // Multiple threads trying to withdraw money
        Thread[] withdrawThreads = new Thread[3];
        for (int i = 0; i < withdrawThreads.length; i++) {
            final int threadId = i + 1;
            withdrawThreads[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    account.withdraw(50, "Thread-" + threadId);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }
        
        // One thread depositing money
        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.deposit(100, "DepositThread");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        // Start all threads
        for (Thread thread : withdrawThreads) {
            thread.start();
        }
        depositThread.start();
        
        // Wait for completion
        try {
            for (Thread thread : withdrawThreads) {
                thread.join();
            }
            depositThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Final balance: " + account.getBalance());
    }
    
    public static void demonstrateStaticSynchronization() {
        System.out.println("\n4. Static Synchronization:");
        
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            final int threadId = i + 1;
            threads[i] = new Thread(() -> {
                StaticCounter.increment("Thread-" + threadId);
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
        
        System.out.println("Static counter final value: " + StaticCounter.getCount());
    }
}

// Unsafe counter - demonstrates race condition
class UnsafeCounter {
    private int count = 0;
    
    public void increment() {
        count++; // Not atomic - can cause race condition
    }
    
    public int getCount() {
        return count;
    }
}

// Safe counter using synchronized methods
class SafeCounter {
    private int count = 0;
    
    public synchronized void increment() {
        count++; // Synchronized - thread-safe
    }
    
    public synchronized int getCount() {
        return count;
    }
}

// Bank account with synchronized blocks
class BankAccount {
    private double balance;
    private final Object lock = new Object();
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount, String threadName) {
        synchronized (lock) {
            if (balance >= amount) {
                System.out.println(threadName + " withdrawing " + amount);
                
                // Simulate processing time
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                balance -= amount;
                System.out.println(threadName + " withdrew " + amount + 
                                 ", balance: " + balance);
            } else {
                System.out.println(threadName + " insufficient funds for " + amount);
            }
        }
    }
    
    public void deposit(double amount, String threadName) {
        synchronized (lock) {
            System.out.println(threadName + " depositing " + amount);
            balance += amount;
            System.out.println(threadName + " deposited " + amount + 
                             ", balance: " + balance);
        }
    }
    
    public synchronized double getBalance() {
        return balance;
    }
}

// Static synchronization example
class StaticCounter {
    private static int count = 0;
    
    public static synchronized void increment(String threadName) {
        for (int i = 0; i < 5; i++) {
            count++;
            System.out.println(threadName + " incremented to: " + count);
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static synchronized int getCount() {
        return count;
    }
}