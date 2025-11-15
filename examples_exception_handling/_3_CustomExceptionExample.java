public class _3_CustomExceptionExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC001", 1000.0);
        
        try {
            account.withdraw(500.0);
            System.out.println("Withdrawal successful. Balance: " + account.getBalance());
            
            account.withdraw(600.0); // This will throw InsufficientFundsException
            
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
            System.out.println("Available balance: " + e.getAvailableBalance());
            System.out.println("Attempted amount: " + e.getAttemptedAmount());
        } catch (InvalidAccountException e) {
            System.out.println("Account error: " + e.getMessage());
        }
        
        // Age validation example
        try {
            Person person = new Person("John", -5); // Invalid age
        } catch (InvalidAgeException e) {
            System.out.println("Person creation failed: " + e.getMessage());
            System.out.println("Provided age: " + e.getProvidedAge());
        }
        
        // Email validation example
        try {
            User user = new User("john", "invalid-email"); // Invalid email
        } catch (InvalidEmailException e) {
            System.out.println("User creation failed: " + e.getMessage());
            System.out.println("Provided email: " + e.getProvidedEmail());
        }
        
        // Chained exceptions
        try {
            processOrder("ORDER123");
        } catch (OrderProcessingException e) {
            System.out.println("Order processing failed: " + e.getMessage());
            System.out.println("Root cause: " + e.getCause().getMessage());
        }
    }
    
    public static void processOrder(String orderId) throws OrderProcessingException {
        try {
            // Simulate payment processing that fails
            processPayment(orderId);
        } catch (PaymentException e) {
            // Wrap the original exception with more context
            throw new OrderProcessingException("Failed to process order: " + orderId, e);
        }
    }
    
    public static void processPayment(String orderId) throws PaymentException {
        // Simulate payment failure
        throw new PaymentException("Credit card declined for order: " + orderId);
    }
}

// Custom checked exception for insufficient funds
class InsufficientFundsException extends Exception {
    private double availableBalance;
    private double attemptedAmount;
    
    public InsufficientFundsException(String message, double availableBalance, double attemptedAmount) {
        super(message);
        this.availableBalance = availableBalance;
        this.attemptedAmount = attemptedAmount;
    }
    
    public double getAvailableBalance() { return availableBalance; }
    public double getAttemptedAmount() { return attemptedAmount; }
}

// Custom unchecked exception for invalid account
class InvalidAccountException extends RuntimeException {
    public InvalidAccountException(String message) {
        super(message);
    }
}

// Custom exception for age validation
class InvalidAgeException extends Exception {
    private int providedAge;
    
    public InvalidAgeException(String message, int providedAge) {
        super(message);
        this.providedAge = providedAge;
    }
    
    public int getProvidedAge() { return providedAge; }
}

// Custom exception for email validation
class InvalidEmailException extends Exception {
    private String providedEmail;
    
    public InvalidEmailException(String message, String providedEmail) {
        super(message);
        this.providedEmail = providedEmail;
    }
    
    public String getProvidedEmail() { return providedEmail; }
}

// Exception for order processing
class OrderProcessingException extends Exception {
    public OrderProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Exception for payment processing
class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}

// Bank account class
class BankAccount {
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountNumber, double initialBalance) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new InvalidAccountException("Account number cannot be null or empty");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds for withdrawal", 
                balance, 
                amount
            );
        }
        balance -= amount;
    }
    
    public double getBalance() { return balance; }
}

// Person class with age validation
class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Age must be between 0 and 150", age);
        }
        this.name = name;
        this.age = age;
    }
}

// User class with email validation
class User {
    private String username;
    private String email;
    
    public User(String username, String email) throws InvalidEmailException {
        if (!email.contains("@") || !email.contains(".")) {
            throw new InvalidEmailException("Invalid email format", email);
        }
        this.username = username;
        this.email = email;
    }
}