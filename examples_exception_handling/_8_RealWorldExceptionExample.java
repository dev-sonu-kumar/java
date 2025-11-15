import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class _8_RealWorldExceptionExample {
    private static final Logger logger = Logger.getLogger(_8_RealWorldExceptionExample.class.getName());
    
    public static void main(String[] args) {
        System.out.println("=== Real-World Exception Scenarios ===");
        
        // Web service client with retry logic
        WebServiceClient client = new WebServiceClient();
        client.callServiceWithRetry("https://api.example.com/users");
        
        // File processing with recovery
        FileProcessor processor = new FileProcessor();
        processor.processFilesWithRecovery(Arrays.asList("file1.txt", "file2.txt", "file3.txt"));
        
        // Database operations with transaction handling
        DatabaseService dbService = new DatabaseService();
        dbService.performTransactionWithRollback();
        
        // Configuration management
        ConfigurationManager config = new ConfigurationManager();
        config.loadConfigurationSafely();
        
        // Batch processing with error handling
        BatchProcessor batchProcessor = new BatchProcessor();
        batchProcessor.processBatch(Arrays.asList("item1", "item2", "item3", "item4", "item5"));
    }
}

// Web service client with comprehensive error handling
class WebServiceClient {
    private static final Logger logger = Logger.getLogger(WebServiceClient.class.getName());
    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY_MS = 1000;
    
    public String callServiceWithRetry(String url) {
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                return callService(url);
                
            } catch (ConnectException e) {
                logger.log(Level.WARNING, "Connection failed on attempt " + attempt + ": " + e.getMessage());
                if (attempt == MAX_RETRIES) {
                    throw new ServiceUnavailableException("Service unavailable after " + MAX_RETRIES + " attempts", e);
                }
                
            } catch (SocketTimeoutException e) {
                logger.log(Level.WARNING, "Timeout on attempt " + attempt + ": " + e.getMessage());
                if (attempt == MAX_RETRIES) {
                    throw new ServiceTimeoutException("Service timeout after " + MAX_RETRIES + " attempts", e);
                }
                
            } catch (IOException e) {
                logger.log(Level.SEVERE, "IO error on attempt " + attempt, e);
                throw new ServiceException("Service call failed due to IO error", e);
                
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Unexpected error on attempt " + attempt, e);
                throw new ServiceException("Unexpected service error", e);
            }
            
            // Wait before retry with exponential backoff
            try {
                Thread.sleep(RETRY_DELAY_MS * attempt);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                throw new ServiceException("Service call interrupted", ie);
            }
        }
        
        throw new ServiceException("Should not reach here");
    }
    
    private String callService(String url) throws IOException {
        // Simulate various failure scenarios
        double random = Math.random();
        
        if (random < 0.3) {
            throw new ConnectException("Connection refused");
        } else if (random < 0.5) {
            throw new SocketTimeoutException("Read timeout");
        } else if (random < 0.6) {
            throw new IOException("Network error");
        }
        
        System.out.println("✅ Service call successful: " + url);
        return "Success response";
    }
}

// File processor with error recovery
class FileProcessor {
    private static final Logger logger = Logger.getLogger(FileProcessor.class.getName());
    
    public void processFilesWithRecovery(List<String> filenames) {
        System.out.println("\n=== File Processing with Recovery ===");
        
        List<String> failedFiles = new ArrayList<>();
        List<String> processedFiles = new ArrayList<>();
        
        for (String filename : filenames) {
            try {
                processFile(filename);
                processedFiles.add(filename);
                System.out.println("✅ Processed: " + filename);
                
            } catch (FileNotFoundException e) {
                logger.log(Level.WARNING, "File not found: " + filename, e);
                failedFiles.add(filename);
                
                // Try to create missing file
                try {
                    createMissingFile(filename);
                    processFile(filename);
                    processedFiles.add(filename);
                    System.out.println("✅ Recovered and processed: " + filename);
                } catch (Exception recoveryException) {
                    logger.log(Level.SEVERE, "Recovery failed for: " + filename, recoveryException);
                }
                
            } catch (SecurityException e) {
                logger.log(Level.SEVERE, "Security error processing: " + filename, e);
                failedFiles.add(filename);
                
            } catch (IOException e) {
                logger.log(Level.WARNING, "IO error processing: " + filename, e);
                
                // Try alternative processing method
                try {
                    processFileAlternative(filename);
                    processedFiles.add(filename);
                    System.out.println("✅ Alternative processing successful: " + filename);
                } catch (Exception altException) {
                    logger.log(Level.SEVERE, "Alternative processing failed: " + filename, altException);
                    failedFiles.add(filename);
                }
            }
        }
        
        // Report results
        System.out.println("Processing complete - Success: " + processedFiles.size() + ", Failed: " + failedFiles.size());
        if (!failedFiles.isEmpty()) {
            System.out.println("Failed files: " + failedFiles);
        }
    }
    
    private void processFile(String filename) throws IOException {
        if (filename.contains("file2")) {
            throw new FileNotFoundException("File not found: " + filename);
        }
        if (filename.contains("file3")) {
            throw new SecurityException("Access denied: " + filename);
        }
        // Simulate successful processing
    }
    
    private void createMissingFile(String filename) throws IOException {
        System.out.println("Creating missing file: " + filename);
        // Simulate file creation
    }
    
    private void processFileAlternative(String filename) throws IOException {
        System.out.println("Using alternative processing for: " + filename);
        // Simulate alternative processing
    }
}

// Database service with transaction management
class DatabaseService {
    private static final Logger logger = Logger.getLogger(DatabaseService.class.getName());
    
    public void performTransactionWithRollback() {
        System.out.println("\n=== Database Transaction with Rollback ===");
        
        DatabaseTransaction transaction = null;
        try {
            transaction = beginTransaction();
            
            // Perform multiple operations
            insertUser("John Doe", "john@example.com");
            updateUserProfile("john@example.com", "Senior Developer");
            insertAuditLog("User created: john@example.com");
            
            // Simulate random failure
            if (Math.random() > 0.7) {
                throw new DatabaseException("Simulated database constraint violation");
            }
            
            transaction.commit();
            System.out.println("✅ Transaction committed successfully");
            
        } catch (DatabaseException e) {
            logger.log(Level.SEVERE, "Database operation failed", e);
            
            if (transaction != null) {
                try {
                    transaction.rollback();
                    System.out.println("✅ Transaction rolled back successfully");
                } catch (DatabaseException rollbackException) {
                    logger.log(Level.SEVERE, "Rollback failed", rollbackException);
                    // This is a critical error - might need manual intervention
                    throw new CriticalSystemException("Transaction rollback failed", rollbackException);
                }
            }
            
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error in transaction", e);
            
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (DatabaseException rollbackException) {
                    logger.log(Level.SEVERE, "Rollback failed after unexpected error", rollbackException);
                }
            }
            throw new SystemException("Transaction failed due to unexpected error", e);
            
        } finally {
            if (transaction != null) {
                try {
                    transaction.close();
                } catch (Exception e) {
                    logger.log(Level.WARNING, "Error closing transaction", e);
                }
            }
        }
    }
    
    private DatabaseTransaction beginTransaction() throws DatabaseException {
        System.out.println("Beginning database transaction");
        return new DatabaseTransaction();
    }
    
    private void insertUser(String name, String email) throws DatabaseException {
        System.out.println("Inserting user: " + name);
    }
    
    private void updateUserProfile(String email, String title) throws DatabaseException {
        System.out.println("Updating profile for: " + email);
    }
    
    private void insertAuditLog(String message) throws DatabaseException {
        System.out.println("Audit log: " + message);
    }
}

// Configuration manager with fallback strategies
class ConfigurationManager {
    private static final Logger logger = Logger.getLogger(ConfigurationManager.class.getName());
    
    public Properties loadConfigurationSafely() {
        System.out.println("\n=== Configuration Loading with Fallbacks ===");
        
        Properties config = new Properties();
        
        // Try primary configuration source
        try {
            config = loadFromFile("config.properties");
            System.out.println("✅ Loaded configuration from primary file");
            return config;
            
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "Primary config file not found", e);
            
            // Try backup configuration
            try {
                config = loadFromFile("config.backup.properties");
                System.out.println("✅ Loaded configuration from backup file");
                return config;
                
            } catch (FileNotFoundException backupException) {
                logger.log(Level.WARNING, "Backup config file not found", backupException);
                
                // Try environment variables
                try {
                    config = loadFromEnvironment();
                    System.out.println("✅ Loaded configuration from environment variables");
                    return config;
                    
                } catch (ConfigurationException envException) {
                    logger.log(Level.WARNING, "Environment configuration incomplete", envException);
                    
                    // Use default configuration
                    config = getDefaultConfiguration();
                    System.out.println("✅ Using default configuration");
                    return config;
                }
            }
            
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading configuration file", e);
            throw new ConfigurationException("Failed to load configuration", e);
        }
    }
    
    private Properties loadFromFile(String filename) throws IOException {
        if (filename.contains("backup") && Math.random() > 0.5) {
            throw new FileNotFoundException("Backup file not available");
        }
        if (!filename.contains("backup") && Math.random() > 0.3) {
            throw new FileNotFoundException("Primary file not available");
        }
        
        Properties props = new Properties();
        props.setProperty("database.url", "jdbc:mysql://localhost:3306/app");
        props.setProperty("api.timeout", "5000");
        return props;
    }
    
    private Properties loadFromEnvironment() throws ConfigurationException {
        Properties props = new Properties();
        
        String dbUrl = System.getenv("DATABASE_URL");
        String apiTimeout = System.getenv("API_TIMEOUT");
        
        if (dbUrl == null || apiTimeout == null) {
            throw new ConfigurationException("Required environment variables not set");
        }
        
        props.setProperty("database.url", dbUrl);
        props.setProperty("api.timeout", apiTimeout);
        return props;
    }
    
    private Properties getDefaultConfiguration() {
        Properties props = new Properties();
        props.setProperty("database.url", "jdbc:h2:mem:testdb");
        props.setProperty("api.timeout", "3000");
        return props;
    }
}

// Batch processor with error isolation
class BatchProcessor {
    private static final Logger logger = Logger.getLogger(BatchProcessor.class.getName());
    
    public BatchResult processBatch(List<String> items) {
        System.out.println("\n=== Batch Processing with Error Isolation ===");
        
        List<String> successfulItems = new ArrayList<>();
        List<BatchError> errors = new ArrayList<>();
        
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            
            try {
                processItem(item);
                successfulItems.add(item);
                System.out.println("✅ Processed item: " + item);
                
            } catch (ValidationException e) {
                logger.log(Level.WARNING, "Validation error for item: " + item, e);
                errors.add(new BatchError(i, item, "Validation failed", e));
                
            } catch (ProcessingException e) {
                logger.log(Level.SEVERE, "Processing error for item: " + item, e);
                errors.add(new BatchError(i, item, "Processing failed", e));
                
                // For critical errors, decide whether to continue or stop
                if (e.isCritical()) {
                    logger.log(Level.SEVERE, "Critical error encountered, stopping batch processing");
                    break;
                }
                
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Unexpected error for item: " + item, e);
                errors.add(new BatchError(i, item, "Unexpected error", e));
            }
        }
        
        BatchResult result = new BatchResult(successfulItems, errors);
        System.out.println("Batch processing complete - Success: " + result.getSuccessCount() + 
                          ", Errors: " + result.getErrorCount());
        
        return result;
    }
    
    private void processItem(String item) throws ValidationException, ProcessingException {
        // Simulate various processing scenarios
        if (item.contains("item2")) {
            throw new ValidationException("Invalid item format: " + item);
        }
        if (item.contains("item4")) {
            throw new ProcessingException("Processing failed for: " + item, true); // Critical error
        }
        if (item.contains("item5")) {
            throw new ProcessingException("Temporary processing issue: " + item, false); // Non-critical
        }
        
        // Simulate successful processing
        Thread.yield(); // Simulate some work
    }
}

// Supporting classes and exceptions
class ServiceUnavailableException extends RuntimeException {
    public ServiceUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}

class ServiceTimeoutException extends RuntimeException {
    public ServiceTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }
}

class ServiceException extends RuntimeException {
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ServiceException(String message) {
        super(message);
    }
}

class DatabaseException extends Exception {
    public DatabaseException(String message) {
        super(message);
    }
}

class CriticalSystemException extends RuntimeException {
    public CriticalSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}

class SystemException extends RuntimeException {
    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}

class ConfigurationException extends RuntimeException {
    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ConfigurationException(String message) {
        super(message);
    }
}

class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

class ProcessingException extends Exception {
    private final boolean critical;
    
    public ProcessingException(String message, boolean critical) {
        super(message);
        this.critical = critical;
    }
    
    public boolean isCritical() {
        return critical;
    }
}

class DatabaseTransaction implements AutoCloseable {
    public void commit() throws DatabaseException {
        System.out.println("Committing transaction");
    }
    
    public void rollback() throws DatabaseException {
        System.out.println("Rolling back transaction");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("Closing transaction");
    }
}

class BatchError {
    private final int index;
    private final String item;
    private final String errorMessage;
    private final Exception exception;
    
    public BatchError(int index, String item, String errorMessage, Exception exception) {
        this.index = index;
        this.item = item;
        this.errorMessage = errorMessage;
        this.exception = exception;
    }
    
    // Getters
    public int getIndex() { return index; }
    public String getItem() { return item; }
    public String getErrorMessage() { return errorMessage; }
    public Exception getException() { return exception; }
}

class BatchResult {
    private final List<String> successfulItems;
    private final List<BatchError> errors;
    
    public BatchResult(List<String> successfulItems, List<BatchError> errors) {
        this.successfulItems = new ArrayList<>(successfulItems);
        this.errors = new ArrayList<>(errors);
    }
    
    public int getSuccessCount() { return successfulItems.size(); }
    public int getErrorCount() { return errors.size(); }
    public List<String> getSuccessfulItems() { return new ArrayList<>(successfulItems); }
    public List<BatchError> getErrors() { return new ArrayList<>(errors); }
}