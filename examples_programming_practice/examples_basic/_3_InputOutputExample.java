/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates basic input/output operations and data type handling:
 * 1. Reading different data types from user
 * 2. Type conversions and parsing
 * 3. Formatted output
 * 4. Input validation
 * 5. Calculator with user input
 */

import java.util.Scanner;

public class _3_InputOutputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Input/Output & Data Types Demo ===");
        
        // 1. Basic Input Types
        System.out.println("\n1. Reading Different Data Types:");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        System.out.print("Enter your height (in meters): ");
        double height = scanner.nextDouble();
        
        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = scanner.nextBoolean();
        
        // 2. Formatted Output
        System.out.println("\n2. Formatted Output:");
        System.out.printf("Name: %s%n", name);
        System.out.printf("Age: %d years%n", age);
        System.out.printf("Height: %.2f meters%n", height);
        System.out.printf("Student Status: %s%n", isStudent ? "Yes" : "No");
        
        // 3. Type Conversions
        System.out.println("\n3. Type Conversions:");
        String ageStr = String.valueOf(age);
        int heightCm = (int)(height * 100);
        System.out.println("Age as String: " + ageStr);
        System.out.println("Height in cm: " + heightCm);
        
        // 4. Simple Calculator
        scanner.nextLine(); // Clear buffer
        System.out.println("\n4. Simple Calculator:");
        System.out.print("Enter first number: ");
        double num1 = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.nextLine().charAt(0);
        
        System.out.print("Enter second number: ");
        double num2 = Double.parseDouble(scanner.nextLine());
        
        double result = calculate(num1, operator, num2);
        System.out.printf("Result: %.2f %c %.2f = %.2f%n", num1, operator, num2, result);
        
        // 5. Input Validation Example
        System.out.println("\n5. Input Validation:");
        int validNumber = getValidNumber(scanner, "Enter a number between 1-100: ", 1, 100);
        System.out.println("You entered: " + validNumber);
        
        scanner.close();
    }
    
    // Calculator method
    public static double calculate(double a, char op, double b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return b != 0 ? a / b : Double.NaN;
            default: return Double.NaN;
        }
    }
    
    // Input validation method
    public static int getValidNumber(Scanner scanner, String prompt, int min, int max) {
        int number;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! " + prompt);
                scanner.next();
            }
            number = scanner.nextInt();
            if (number < min || number > max) {
                System.out.println("Number must be between " + min + " and " + max);
            }
        } while (number < min || number > max);
        return number;
    }
}