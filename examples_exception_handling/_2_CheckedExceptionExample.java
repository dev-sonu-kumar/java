import java.io.*;
import java.sql.*;

public class _2_CheckedExceptionExample {
    public static void main(String[] args) {
        // File operations - IOException (checked)
        try {
            readFile("nonexistent.txt");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
        
        // Method that declares checked exception
        try {
            connectToDatabase();
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        
        // Multiple checked exceptions
        try {
            processData("data.txt");
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        }
        
        // Try-with-resources (Java 7+) - automatic resource management
        try (FileReader reader = new FileReader("example.txt");
             BufferedReader buffered = new BufferedReader(reader)) {
            
            String line = buffered.readLine();
            System.out.println("First line: " + line);
            
        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }
        // Resources automatically closed, even if exception occurs
        
        // Custom resource with try-with-resources
        try (DatabaseConnection conn = new DatabaseConnection()) {
            conn.executeQuery("SELECT * FROM users");
        } catch (Exception e) {
            System.out.println("Database operation error: " + e.getMessage());
        }
    }
    
    // Method that throws checked exception - must be declared
    public static void readFile(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        // This will throw FileNotFoundException (subclass of IOException)
        reader.close();
    }
    
    // Method with multiple checked exceptions
    public static void connectToDatabase() throws SQLException {
        // Simulate database connection failure
        throw new SQLException("Connection failed: Database server not available");
    }
    
    // Method that can throw multiple types of exceptions
    public static void processData(String filename) throws IOException, SQLException {
        // File processing
        if (filename.endsWith(".txt")) {
            throw new IOException("Cannot process text files");
        }
        
        // Database operation
        if (filename.contains("user")) {
            throw new SQLException("User data access denied");
        }
        
        System.out.println("Data processed successfully");
    }
}

// Custom resource class implementing AutoCloseable
class DatabaseConnection implements AutoCloseable {
    public DatabaseConnection() {
        System.out.println("Database connection opened");
    }
    
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("Database connection closed");
        // Simulate cleanup that might throw exception
        if (Math.random() > 0.8) {
            throw new SQLException("Error closing connection");
        }
    }
}