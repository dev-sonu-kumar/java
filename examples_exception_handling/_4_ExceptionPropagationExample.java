import java.io.*;

public class _4_ExceptionPropagationExample {
    public static void main(String[] args) {
        System.out.println("=== Exception Propagation Examples ===");
        
        // Example 1: Unchecked exception propagation
        try {
            method1();
        } catch (RuntimeException e) {
            System.out.println("Caught in main: " + e.getMessage());
            printStackTrace(e);
        }
        
        // Example 2: Checked exception propagation
        try {
            processFile("data.txt");
        } catch (IOException e) {
            System.out.println("File processing failed: " + e.getMessage());
        }
        
        // Example 3: Exception handling at different levels
        try {
            businessLogic();
        } catch (BusinessException e) {
            System.out.println("Business logic failed: " + e.getMessage());
            System.out.println("Error code: " + e.getErrorCode());
        }
        
        // Example 4: Exception transformation
        try {
            dataAccessLayer();
        } catch (DataAccessException e) {
            System.out.println("Data access failed: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Root cause: " + e.getCause().getClass().getSimpleName());
            }
        }
    }
    
    // Unchecked exception propagation chain
    public static void method1() {
        method2();
    }
    
    public static void method2() {
        method3();
    }
    
    public static void method3() {
        throw new RuntimeException("Error occurred in method3");
    }
    
    // Checked exception propagation
    public static void processFile(String filename) throws IOException {
        readFileContent(filename);
    }
    
    public static void readFileContent(String filename) throws IOException {
        validateFile(filename);
    }
    
    public static void validateFile(String filename) throws IOException {
        if (!filename.endsWith(".txt")) {
            throw new IOException("Only .txt files are supported");
        }
        // Simulate file not found
        throw new FileNotFoundException("File not found: " + filename);
    }
    
    // Business layer exception handling
    public static void businessLogic() throws BusinessException {
        try {
            serviceLayer();
        } catch (ServiceException e) {
            // Transform service exception to business exception
            throw new BusinessException("Business operation failed", "BUS001", e);
        }
    }
    
    public static void serviceLayer() throws ServiceException {
        try {
            databaseOperation();
        } catch (RuntimeException e) {
            // Wrap runtime exception in service exception
            throw new ServiceException("Service layer error", e);
        }
    }
    
    public static void databaseOperation() {
        // Simulate database error
        throw new RuntimeException("Database connection failed");
    }
    
    // Data access layer with exception transformation
    public static void dataAccessLayer() throws DataAccessException {
        try {
            performDatabaseQuery();
        } catch (SQLException e) {
            throw new DataAccessException("Database query failed", e);
        } catch (ConnectionException e) {
            throw new DataAccessException("Database connection error", e);
        }
    }
    
    public static void performDatabaseQuery() throws SQLException, ConnectionException {
        if (Math.random() > 0.5) {
            throw new SQLException("SQL syntax error in query");
        } else {
            throw new ConnectionException("Cannot connect to database server");
        }
    }
    
    // Utility method to print stack trace
    public static void printStackTrace(Exception e) {
        System.out.println("Stack trace:");
        StackTraceElement[] elements = e.getStackTrace();
        for (int i = 0; i < Math.min(3, elements.length); i++) {
            System.out.println("  at " + elements[i]);
        }
    }
}

// Custom business exception
class BusinessException extends Exception {
    private String errorCode;
    
    public BusinessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public BusinessException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
    
    public String getErrorCode() { return errorCode; }
}

// Service layer exception
class ServiceException extends Exception {
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Data access exception
class DataAccessException extends Exception {
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Database-related exceptions
class SQLException extends Exception {
    public SQLException(String message) {
        super(message);
    }
}

class ConnectionException extends Exception {
    public ConnectionException(String message) {
        super(message);
    }
}