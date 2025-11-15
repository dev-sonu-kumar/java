import java.io.*;
import java.util.*;
import java.util.logging.*;

public class _5_BestPracticesExample {
    private static final Logger logger = Logger.getLogger(_5_BestPracticesExample.class.getName());
    
    public static void main(String[] args) {
        System.out.println("=== Exception Handling Best Practices ===");
        
        // Best Practice 1: Specific exception handling
        demonstrateSpecificExceptions();
        
        // Best Practice 2: Proper resource management
        demonstrateResourceManagement();
        
        // Best Practice 3: Meaningful error messages
        demonstrateMeaningfulMessages();
        
        // Best Practice 4: Logging exceptions
        demonstrateLogging();
        
        // Best Practice 5: Exception recovery
        demonstrateRecovery();
        
        // Best Practice 6: Validation and early failure
        demonstrateValidation();
    }
    
    // ✅ Good: Catch specific exceptions
    public static void demonstrateSpecificExceptions() {
        System.out.println("\n1. Specific Exception Handling:");
        
        try {
            processUserInput("invalid-number");
        } catch (NumberFormatException e) {
            System.out.println("✅ Specific: Invalid number format - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Specific: Invalid argument - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✅ Fallback: Unexpected error - " + e.getMessage());
        }
        
        // ❌ Bad: Catching generic Exception
        try {
            processUserInput("invalid");
        } catch (Exception e) {
            System.out.println("❌ Generic: Something went wrong - " + e.getMessage());
        }
    }
    
    // ✅ Good: Proper resource management with try-with-resources
    public static void demonstrateResourceManagement() {
        System.out.println("\n2. Resource Management:");
        
        // ✅ Good: Automatic resource management
        try (FileInputStream fis = new FileInputStream("config.properties");
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            
            System.out.println("✅ Resources will be automatically closed");
            
        } catch (IOException e) {
            System.out.println("✅ File operation failed: " + e.getMessage());
        }
        
        // ✅ Good: Custom resource management
        try (DatabaseManager db = new DatabaseManager()) {
            db.executeQuery("SELECT * FROM users");
        } catch (Exception e) {
            System.out.println("✅ Database operation handled: " + e.getMessage());
        }
    }
    
    // ✅ Good: Meaningful error messages with context
    public static void demonstrateMeaningfulMessages() {
        System.out.println("\n3. Meaningful Error Messages:");
        
        try {
            validateUserAge(-5, "John Doe");
        } catch (ValidationException e) {
            System.out.println("✅ Detailed error: " + e.getMessage());
            System.out.println("   Field: " + e.getFieldName());
            System.out.println("   Value: " + e.getFieldValue());
        }
    }
    
    // ✅ Good: Proper logging
    public static void demonstrateLogging() {
        System.out.println("\n4. Exception Logging:");
        
        try {
            riskyOperation();
        } catch (Exception e) {
            // ✅ Log with appropriate level and context
            logger.log(Level.SEVERE, "Operation failed for user session", e);
            System.out.println("✅ Exception logged with full context");
            
            // ❌ Bad: Just printing stack trace
            // e.printStackTrace(); // Don't do this in production
        }
    }
    
    // ✅ Good: Exception recovery and graceful degradation
    public static void demonstrateRecovery() {
        System.out.println("\n5. Exception Recovery:");
        
        String result = getConfigValueWithFallback("database.url");
        System.out.println("✅ Config value (with fallback): " + result);
        
        List<String> data = loadDataWithRetry("user-data", 3);
        System.out.println("✅ Data loaded with retry: " + data.size() + " items");
    }
    
    // ✅ Good: Input validation and fail-fast
    public static void demonstrateValidation() {
        System.out.println("\n6. Input Validation:");
        
        try {
            User user = createUser(null, "john@email.com", 25);
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Validation failed early: " + e.getMessage());
        }
    }
    
    // Helper methods
    public static void processUserInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        
        int number = Integer.parseInt(input); // Can throw NumberFormatException
        System.out.println("Processed number: " + number);
    }
    
    public static void validateUserAge(int age, String userName) throws ValidationException {
        if (age < 0 || age > 150) {
            throw new ValidationException(
                String.format("Invalid age %d for user '%s'. Age must be between 0 and 150.", age, userName),
                "age",
                String.valueOf(age)
            );
        }
    }
    
    public static void riskyOperation() throws Exception {
        throw new RuntimeException("Simulated operation failure");
    }
    
    public static String getConfigValueWithFallback(String key) {
        try {
            return loadConfigValue(key);
        } catch (ConfigurationException e) {
            logger.log(Level.WARNING, "Failed to load config for key: " + key + ", using default", e);
            return getDefaultValue(key);
        }
    }
    
    public static String loadConfigValue(String key) throws ConfigurationException {
        throw new ConfigurationException("Configuration file not found");
    }
    
    public static String getDefaultValue(String key) {
        return "jdbc:h2:mem:testdb"; // Default database URL
    }
    
    public static List<String> loadDataWithRetry(String source, int maxRetries) {
        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                return loadData(source);
            } catch (DataLoadException e) {
                if (attempt == maxRetries) {
                    logger.log(Level.SEVERE, "Failed to load data after " + maxRetries + " attempts", e);
                    return Collections.emptyList(); // Return empty list as fallback
                }
                
                logger.log(Level.WARNING, "Data load attempt " + attempt + " failed, retrying...", e);
                
                try {
                    Thread.sleep(1000 * attempt); // Exponential backoff
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    return Collections.emptyList();
                }
            }
        }
        return Collections.emptyList();
    }
    
    public static List<String> loadData(String source) throws DataLoadException {
        if (Math.random() > 0.7) {
            return Arrays.asList("data1", "data2", "data3");
        }
        throw new DataLoadException("Network timeout while loading data from: " + source);
    }
    
    public static User createUser(String name, String email, int age) {
        // ✅ Validate inputs early
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Valid email is required");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        
        return new User(name, email, age);
    }
}

// Custom exceptions
class ValidationException extends Exception {
    private String fieldName;
    private String fieldValue;
    
    public ValidationException(String message, String fieldName, String fieldValue) {
        super(message);
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    
    public String getFieldName() { return fieldName; }
    public String getFieldValue() { return fieldValue; }
}

class ConfigurationException extends Exception {
    public ConfigurationException(String message) {
        super(message);
    }
}

class DataLoadException extends Exception {
    public DataLoadException(String message) {
        super(message);
    }
}

// Resource management classes
class DatabaseManager implements AutoCloseable {
    public DatabaseManager() {
        System.out.println("Database connection opened");
    }
    
    public void executeQuery(String query) {
        System.out.println("Executing: " + query);
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("Database connection closed");
    }
}

class User {
    private String name;
    private String email;
    private int age;
    
    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}