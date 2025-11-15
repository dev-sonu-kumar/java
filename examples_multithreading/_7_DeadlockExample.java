public class _7_DeadlockExample {
    public static void main(String[] args) {
        System.out.println("=== Deadlock Examples ===");
        
        // Demonstrate deadlock problem
        demonstrateDeadlock();
        
        // Show deadlock prevention
        demonstrateDeadlockPrevention();
        
        // Timeout-based solution
        demonstrateTimeoutSolution();
    }
    
    public static void demonstrateDeadlock() {
        System.out.println("\n1. Deadlock Problem:");
        
        Object lock1 = new Object();
        Object lock2 = new Object();
        
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread1: Acquired lock1");
                
                try {
                    Thread.sleep(100); // Give time for thread2 to acquire lock2
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                System.out.println("Thread1: Waiting for lock2...");
                synchronized (lock2) {
                    System.out.println("Thread1: Acquired lock2");
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread2: Acquired lock2");
                
                try {
                    Thread.sleep(100); // Give time for thread1 to acquire lock1
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                System.out.println("Thread2: Waiting for lock1...");
                synchronized (lock1) {
                    System.out.println("Thread2: Acquired lock1");
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        // Wait for a short time to see deadlock
        try {
            Thread.sleep(2000);
            if (thread1.isAlive() || thread2.isAlive()) {
                System.out.println("DEADLOCK DETECTED! Threads are stuck.");
                thread1.interrupt();
                thread2.interrupt();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void demonstrateDeadlockPrevention() {
        System.out.println("\n2. Deadlock Prevention (Lock Ordering):");
        
        Object lock1 = new Object();
        Object lock2 = new Object();
        
        Thread thread1 = new Thread(() -> {
            // Always acquire locks in same order: lock1 then lock2
            synchronized (lock1) {
                System.out.println("Thread1: Acquired lock1");
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                synchronized (lock2) {
                    System.out.println("Thread1: Acquired lock2");
                    System.out.println("Thread1: Work completed");
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            // Same order: lock1 then lock2 (prevents deadlock)
            synchronized (lock1) {
                System.out.println("Thread2: Acquired lock1");
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                synchronized (lock2) {
                    System.out.println("Thread2: Acquired lock2");
                    System.out.println("Thread2: Work completed");
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
            System.out.println("Both threads completed successfully - No deadlock!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void demonstrateTimeoutSolution() {
        System.out.println("\n3. Timeout-based Solution:");
        
        BankAccount account1 = new BankAccount("ACC001", 1000);
        BankAccount account2 = new BankAccount("ACC002", 1500);
        
        // Transfer from account1 to account2
        Thread transfer1 = new Thread(() -> {
            account1.transferTo(account2, 200, "Transfer1");
        });
        
        // Transfer from account2 to account1 (potential deadlock)
        Thread transfer2 = new Thread(() -> {
            account2.transferTo(account1, 300, "Transfer2");
        });
        
        transfer1.start();
        transfer2.start();
        
        try {
            transfer1.join();
            transfer2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Final balances:");
        System.out.println("Account1: " + account1.getBalance());
        System.out.println("Account2: " + account2.getBalance());
    }
}

// Bank account with deadlock-prone transfer method
class BankAccount {
    private final String accountId;
    private double balance;
    private final Object lock = new Object();
    
    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    
    public void transferTo(BankAccount target, double amount, String transferId) {
        // Use account ID ordering to prevent deadlock
        BankAccount firstLock = this.accountId.compareTo(target.accountId) < 0 ? this : target;
        BankAccount secondLock = this.accountId.compareTo(target.accountId) < 0 ? target : this;
        
        synchronized (firstLock.lock) {
            System.out.println(transferId + ": Acquired first lock (" + firstLock.accountId + ")");
            
            try {
                Thread.sleep(100); // Simulate processing time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            
            synchronized (secondLock.lock) {
                System.out.println(transferId + ": Acquired second lock (" + secondLock.accountId + ")");
                
                if (this.balance >= amount) {
                    this.balance -= amount;
                    target.balance += amount;
                    System.out.println(transferId + ": Transferred " + amount + 
                                     " from " + this.accountId + " to " + target.accountId);
                } else {
                    System.out.println(transferId + ": Insufficient funds in " + this.accountId);
                }
            }
        }
    }
    
    public synchronized double getBalance() {
        return balance;
    }
    
    public String getAccountId() {
        return accountId;
    }
}

// Dining philosophers problem (classic deadlock scenario)
class DiningPhilosophers {
    private final Object[] forks;
    private final int numberOfPhilosophers;
    
    public DiningPhilosophers(int numberOfPhilosophers) {
        this.numberOfPhilosophers = numberOfPhilosophers;
        this.forks = new Object[numberOfPhilosophers];
        
        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks[i] = new Object();
        }
    }
    
    public void startDining() {
        Thread[] philosophers = new Thread[numberOfPhilosophers];
        
        for (int i = 0; i < numberOfPhilosophers; i++) {
            final int philosopherId = i;
            philosophers[i] = new Thread(() -> {
                try {
                    while (true) {
                        think(philosopherId);
                        eat(philosopherId);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            philosophers[i].start();
        }
    }
    
    private void think(int philosopherId) throws InterruptedException {
        System.out.println("Philosopher " + philosopherId + " is thinking");
        Thread.sleep(1000);
    }
    
    private void eat(int philosopherId) throws InterruptedException {
        int leftFork = philosopherId;
        int rightFork = (philosopherId + 1) % numberOfPhilosophers;
        
        // Deadlock prevention: always acquire lower-numbered fork first
        int firstFork = Math.min(leftFork, rightFork);
        int secondFork = Math.max(leftFork, rightFork);
        
        synchronized (forks[firstFork]) {
            System.out.println("Philosopher " + philosopherId + " picked up fork " + firstFork);
            
            synchronized (forks[secondFork]) {
                System.out.println("Philosopher " + philosopherId + " picked up fork " + secondFork);
                System.out.println("Philosopher " + philosopherId + " is eating");
                Thread.sleep(1000);
                System.out.println("Philosopher " + philosopherId + " finished eating");
            }
        }
    }
}

// Deadlock detection utility
class DeadlockDetector {
    public static void detectDeadlock() {
        java.lang.management.ThreadMXBean threadBean = 
            java.lang.management.ManagementFactory.getThreadMXBean();
        
        long[] deadlockedThreads = threadBean.findDeadlockedThreads();
        
        if (deadlockedThreads != null) {
            java.lang.management.ThreadInfo[] threadInfos = 
                threadBean.getThreadInfo(deadlockedThreads);
            
            System.out.println("DEADLOCK DETECTED!");
            for (java.lang.management.ThreadInfo threadInfo : threadInfos) {
                System.out.println("Thread: " + threadInfo.getThreadName() + 
                                 " is blocked on: " + threadInfo.getLockName());
            }
        } else {
            System.out.println("No deadlock detected");
        }
    }
}