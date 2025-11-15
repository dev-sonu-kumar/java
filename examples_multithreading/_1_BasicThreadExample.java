public class _1_BasicThreadExample {
    public static void main(String[] args) {
        System.out.println("=== Basic Thread Creation ===");
        System.out.println("Main thread: " + Thread.currentThread().getName());
        
        // Method 1: Extending Thread class
        MyThread thread1 = new MyThread("Thread-1");
        thread1.start(); // Don't call run() directly!
        
        // Method 2: Implementing Runnable interface
        MyRunnable runnable = new MyRunnable("Runnable-1");
        Thread thread2 = new Thread(runnable);
        thread2.start();
        
        // Method 3: Anonymous class
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("Anonymous thread: " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        thread3.start();
        
        // Method 4: Lambda expression (Java 8+)
        Thread thread4 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Lambda thread: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread4.start();
        
        // Thread properties
        System.out.println("\n=== Thread Properties ===");
        System.out.println("Thread1 ID: " + thread1.getId());
        System.out.println("Thread1 Name: " + thread1.getName());
        System.out.println("Thread1 Priority: " + thread1.getPriority());
        System.out.println("Thread1 State: " + thread1.getState());
        System.out.println("Thread1 is alive: " + thread1.isAlive());
        System.out.println("Thread1 is daemon: " + thread1.isDaemon());
        
        // Wait for threads to complete
        try {
            thread1.join(); // Wait for thread1 to finish
            thread2.join();
            thread3.join();
            thread4.join();
            System.out.println("All threads completed!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Daemon thread example
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        daemonThread.setDaemon(true); // Set as daemon before start
        daemonThread.start();
        
        System.out.println("Main thread ending...");
        // Daemon thread will automatically terminate when main ends
    }
}

// Method 1: Extending Thread class
class MyThread extends Thread {
    private String threadName;
    
    public MyThread(String name) {
        this.threadName = name;
        setName(name); // Set thread name
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(300); // Pause for 300ms
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted");
                Thread.currentThread().interrupt(); // Restore interrupt status
                return;
            }
        }
        System.out.println(threadName + " finished");
    }
}

// Method 2: Implementing Runnable interface (Preferred)
class MyRunnable implements Runnable {
    private String taskName;
    
    public MyRunnable(String name) {
        this.taskName = name;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + ": " + i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted");
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(taskName + " finished");
    }
}