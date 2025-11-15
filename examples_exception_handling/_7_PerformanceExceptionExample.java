import java.util.*;
import java.util.concurrent.*;

public class _7_PerformanceExceptionExample {
    public static void main(String[] args) {
        System.out.println("=== Exception Performance Analysis ===");
        
        // Performance comparison: exceptions vs return codes
        compareExceptionVsReturnCode();
        
        // Exception creation cost
        measureExceptionCreationCost();
        
        // Stack trace cost
        measureStackTraceCost();
        
        // Exception caching for performance
        demonstrateExceptionCaching();
        
        // Validation strategies
        compareValidationStrategies();
    }
    
    public static void compareExceptionVsReturnCode() {
        System.out.println("\n1. Exception vs Return Code Performance:");
        
        int iterations = 100000;
        
        // Measure exception-based approach
        long startTime = System.nanoTime();
        int exceptionSuccesses = 0;
        for (int i = 0; i < iterations; i++) {
            try {
                divideWithException(100, i % 10 == 0 ? 0 : 2);
                exceptionSuccesses++;
            } catch (ArithmeticException e) {
                // Handle exception
            }
        }
        long exceptionTime = System.nanoTime() - startTime;
        
        // Measure return code approach
        startTime = System.nanoTime();
        int returnCodeSuccesses = 0;
        for (int i = 0; i < iterations; i++) {
            Result result = divideWithReturnCode(100, i % 10 == 0 ? 0 : 2);
            if (result.isSuccess()) {
                returnCodeSuccesses++;
            }
        }
        long returnCodeTime = System.nanoTime() - startTime;
        
        System.out.println("Exception approach: " + (exceptionTime / 1_000_000) + "ms (" + exceptionSuccesses + " successes)");
        System.out.println("Return code approach: " + (returnCodeTime / 1_000_000) + "ms (" + returnCodeSuccesses + " successes)");
        System.out.println("Performance ratio: " + (double) exceptionTime / returnCodeTime + "x");
    }
    
    public static void measureExceptionCreationCost() {
        System.out.println("\n2. Exception Creation Cost:");
        
        int iterations = 10000;
        
        // Measure exception creation with stack trace
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            Exception e = new RuntimeException("Test exception " + i);
        }
        long withStackTrace = System.nanoTime() - startTime;
        
        // Measure exception creation without stack trace
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            Exception e = new FastException("Test exception " + i);
        }
        long withoutStackTrace = System.nanoTime() - startTime;
        
        System.out.println("With stack trace: " + (withStackTrace / 1_000_000) + "ms");
        System.out.println("Without stack trace: " + (withoutStackTrace / 1_000_000) + "ms");
        System.out.println("Stack trace overhead: " + (double) withStackTrace / withoutStackTrace + "x");
    }
    
    public static void measureStackTraceCost() {
        System.out.println("\n3. Stack Trace Cost:");
        
        int iterations = 1000;
        
        // Deep call stack
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            try {
                deepMethod1();
            } catch (Exception e) {
                // Exception with deep stack trace
            }
        }
        long deepStackTime = System.nanoTime() - startTime;
        
        // Shallow call stack
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            try {
                throw new RuntimeException("Shallow exception");
            } catch (Exception e) {
                // Exception with shallow stack trace
            }
        }
        long shallowStackTime = System.nanoTime() - startTime;
        
        System.out.println("Deep stack trace: " + (deepStackTime / 1_000_000) + "ms");
        System.out.println("Shallow stack trace: " + (shallowStackTime / 1_000_000) + "ms");
        System.out.println("Deep stack overhead: " + (double) deepStackTime / shallowStackTime + "x");
    }
    
    public static void demonstrateExceptionCaching() {
        System.out.println("\n4. Exception Caching for Performance:");
        
        int iterations = 50000;
        
        // Without caching - create new exception each time
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            try {
                validateWithNewException(i % 2 == 0 ? null : "valid");
            } catch (ValidationException e) {
                // Handle validation error
            }
        }
        long noCacheTime = System.nanoTime() - startTime;
        
        // With caching - reuse exception instances
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            try {
                validateWithCachedException(i % 2 == 0 ? null : "valid");
            } catch (ValidationException e) {
                // Handle validation error
            }
        }
        long cacheTime = System.nanoTime() - startTime;
        
        System.out.println("Without caching: " + (noCacheTime / 1_000_000) + "ms");
        System.out.println("With caching: " + (cacheTime / 1_000_000) + "ms");
        System.out.println("Caching improvement: " + (double) noCacheTime / cacheTime + "x");
    }
    
    public static void compareValidationStrategies() {
        System.out.println("\n5. Validation Strategy Performance:");
        
        int iterations = 100000;
        String[] testData = {"valid@email.com", "invalid", "another@valid.com", "bad-email", "test@domain.org"};
        
        // Exception-based validation
        long startTime = System.nanoTime();
        int validEmails1 = 0;
        for (int i = 0; i < iterations; i++) {
            try {
                validateEmailWithException(testData[i % testData.length]);
                validEmails1++;
            } catch (InvalidEmailException e) {
                // Invalid email
            }
        }
        long exceptionValidationTime = System.nanoTime() - startTime;
        
        // Boolean-based validation
        startTime = System.nanoTime();
        int validEmails2 = 0;
        for (int i = 0; i < iterations; i++) {
            if (validateEmailWithBoolean(testData[i % testData.length])) {
                validEmails2++;
            }
        }
        long booleanValidationTime = System.nanoTime() - startTime;
        
        // Optional-based validation
        startTime = System.nanoTime();
        int validEmails3 = 0;
        for (int i = 0; i < iterations; i++) {
            if (validateEmailWithOptional(testData[i % testData.length]).isPresent()) {
                validEmails3++;
            }
        }
        long optionalValidationTime = System.nanoTime() - startTime;
        
        System.out.println("Exception validation: " + (exceptionValidationTime / 1_000_000) + "ms (" + validEmails1 + " valid)");
        System.out.println("Boolean validation: " + (booleanValidationTime / 1_000_000) + "ms (" + validEmails2 + " valid)");
        System.out.println("Optional validation: " + (optionalValidationTime / 1_000_000) + "ms (" + validEmails3 + " valid)");
    }
    
    // Helper methods
    public static int divideWithException(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
    
    public static Result divideWithReturnCode(int a, int b) {
        if (b == 0) {
            return new Result(false, 0, "Division by zero");
        }
        return new Result(true, a / b, null);
    }
    
    public static void deepMethod1() {
        deepMethod2();
    }
    
    public static void deepMethod2() {
        deepMethod3();
    }
    
    public static void deepMethod3() {
        deepMethod4();
    }
    
    public static void deepMethod4() {
        deepMethod5();
    }
    
    public static void deepMethod5() {
        throw new RuntimeException("Deep exception");
    }
    
    public static void validateWithNewException(String value) throws ValidationException {
        if (value == null) {
            throw new ValidationException("Value cannot be null");
        }
    }
    
    // Cached exceptions for better performance
    private static final ValidationException CACHED_NULL_EXCEPTION = new ValidationException("Value cannot be null");
    
    public static void validateWithCachedException(String value) throws ValidationException {
        if (value == null) {
            throw CACHED_NULL_EXCEPTION;
        }
    }
    
    public static void validateEmailWithException(String email) throws InvalidEmailException {
        if (!email.contains("@") || !email.contains(".")) {
            throw new InvalidEmailException("Invalid email format");
        }
    }
    
    public static boolean validateEmailWithBoolean(String email) {
        return email.contains("@") && email.contains(".");
    }
    
    public static Optional<String> validateEmailWithOptional(String email) {
        if (email.contains("@") && email.contains(".")) {
            return Optional.of(email);
        }
        return Optional.empty();
    }
}

// Result class for return code pattern
class Result {
    private final boolean success;
    private final int value;
    private final String errorMessage;
    
    public Result(boolean success, int value, String errorMessage) {
        this.success = success;
        this.value = value;
        this.errorMessage = errorMessage;
    }
    
    public boolean isSuccess() { return success; }
    public int getValue() { return value; }
    public String getErrorMessage() { return errorMessage; }
}

// Fast exception without stack trace
class FastException extends RuntimeException {
    public FastException(String message) {
        super(message);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this; // Don't fill in stack trace for better performance
    }
}

// Custom exceptions
class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}