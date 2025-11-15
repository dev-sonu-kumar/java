/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates conditional logic and control flow:
 * 1. If-else statements and nested conditions
 * 2. Switch statements with different cases
 * 3. Ternary operator usage
 * 4. Grade calculator system
 * 5. Menu-driven program structure
 */

import java.util.Scanner;

public class _4_ConditionalLogicExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Conditional Logic & Control Flow ===");
        
        // 1. Basic If-Else
        System.out.println("\n1. Age Category Checker:");
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        String category = getAgeCategory(age);
        System.out.println("You are: " + category);
        
        // 2. Nested Conditions - Grade Calculator
        System.out.println("\n2. Grade Calculator:");
        System.out.print("Enter your marks (0-100): ");
        int marks = scanner.nextInt();
        
        char grade = calculateGrade(marks);
        String performance = getPerformance(grade);
        System.out.println("Grade: " + grade + " (" + performance + ")");
        
        // 3. Switch Statement - Day of Week
        System.out.println("\n3. Day of Week:");
        System.out.print("Enter day number (1-7): ");
        int dayNum = scanner.nextInt();
        
        String dayName = getDayName(dayNum);
        String dayType = getDayType(dayNum);
        System.out.println("Day: " + dayName + " (" + dayType + ")");
        
        // 4. Multiple Conditions - Number Properties
        System.out.println("\n4. Number Properties:");
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        analyzeNumber(number);
        
        // 5. Menu-Driven Program
        System.out.println("\n5. Simple Calculator Menu:");
        runCalculatorMenu(scanner);
        
        scanner.close();
    }
    
    // Age category using if-else
    public static String getAgeCategory(int age) {
        if (age < 0) {
            return "Invalid age";
        } else if (age <= 12) {
            return "Child";
        } else if (age <= 19) {
            return "Teenager";
        } else if (age <= 59) {
            return "Adult";
        } else {
            return "Senior";
        }
    }
    
    // Grade calculation with nested conditions
    public static char calculateGrade(int marks) {
        if (marks < 0 || marks > 100) {
            return 'X'; // Invalid
        } else if (marks >= 90) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    
    // Performance using ternary operator
    public static String getPerformance(char grade) {
        return (grade == 'A') ? "Excellent" :
               (grade == 'B') ? "Good" :
               (grade == 'C') ? "Average" :
               (grade == 'D') ? "Below Average" :
               (grade == 'F') ? "Fail" : "Invalid";
    }
    
    // Switch statement for day names
    public static String getDayName(int day) {
        switch (day) {
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
            case 7: return "Sunday";
            default: return "Invalid Day";
        }
    }
    
    // Switch with grouped cases
    public static String getDayType(int day) {
        switch (day) {
            case 1: case 2: case 3: case 4: case 5:
                return "Weekday";
            case 6: case 7:
                return "Weekend";
            default:
                return "Invalid";
        }
    }
    
    // Multiple condition analysis
    public static void analyzeNumber(int num) {
        System.out.println("Analysis of " + num + ":");
        
        // Sign check
        if (num > 0) {
            System.out.println("- Positive number");
        } else if (num < 0) {
            System.out.println("- Negative number");
        } else {
            System.out.println("- Zero");
        }
        
        // Even/Odd check
        if (num != 0) {
            System.out.println("- " + (num % 2 == 0 ? "Even" : "Odd"));
        }
        
        // Range check
        if (num >= 1 && num <= 10) {
            System.out.println("- Single digit");
        } else if (num >= 11 && num <= 99) {
            System.out.println("- Two digits");
        } else if (num >= 100 && num <= 999) {
            System.out.println("- Three digits");
        }
        
        // Special numbers
        if (num > 0 && isPerfectSquare(num)) {
            System.out.println("- Perfect square");
        }
    }
    
    // Helper method for perfect square
    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
    
    // Menu-driven calculator
    public static void runCalculatorMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nCalculator Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                double a = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double b = scanner.nextDouble();
                
                double result = 0;
                String operation = "";
                
                switch (choice) {
                    case 1:
                        result = a + b;
                        operation = "Addition";
                        break;
                    case 2:
                        result = a - b;
                        operation = "Subtraction";
                        break;
                    case 3:
                        result = a * b;
                        operation = "Multiplication";
                        break;
                    case 4:
                        if (b != 0) {
                            result = a / b;
                            operation = "Division";
                        } else {
                            System.out.println("Error: Division by zero!");
                            continue;
                        }
                        break;
                }
                
                System.out.printf("%s Result: %.2f%n", operation, result);
            } else if (choice != 0) {
                System.out.println("Invalid choice! Please try again.");
            }
            
        } while (choice != 0);
        
        System.out.println("Calculator closed. Goodbye!");
    }
}