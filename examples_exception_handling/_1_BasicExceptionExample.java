public class _1_BasicExceptionExample {
    public static void main(String[] args) {
        // Basic try-catch example
        try {
            int result = 10 / 0; // ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
            System.out.println("Exception message: " + e.getMessage());
        }
        
        // Array index out of bounds
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Element: " + numbers[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
        }
        
        // Null pointer exception
        try {
            String text = null;
            System.out.println("Length: " + text.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Error: Null pointer access!");
        }
        
        // Multiple catch blocks
        try {
            String number = "abc";
            int parsed = Integer.parseInt(number); // NumberFormatException
            int division = parsed / 0;
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format!");
        } catch (ArithmeticException e) {
            System.out.println("Error: Arithmetic problem!");
        }
        
        // Catch multiple exceptions in one block (Java 7+)
        try {
            performRiskyOperation();
        } catch (ArithmeticException | NumberFormatException e) {
            System.out.println("Error: Math or number format issue - " + e.getClass().getSimpleName());
        }
        
        // Finally block - always executes
        try {
            System.out.println("In try block");
            return; // Even with return, finally executes
        } catch (Exception e) {
            System.out.println("In catch block");
        } finally {
            System.out.println("Finally block always executes!");
        }
    }
    
    public static void performRiskyOperation() {
        if (Math.random() > 0.5) {
            throw new ArithmeticException("Random arithmetic error");
        } else {
            throw new NumberFormatException("Random number format error");
        }
    }
}