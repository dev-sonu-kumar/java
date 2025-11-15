/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates basic number operations including:
 * 1. Check if a number is even or odd
 * 2. Find factorial of a number
 * 3. Check if a number is prime
 * 4. Generate Fibonacci series
 * 5. Find GCD and LCM of two numbers
 */

public class _1_NumberOperationsExample {
    public static void main(String[] args) {
        System.out.println("=== Basic Number Operations ===");
        
        // Test numbers
        int num1 = 12, num2 = 18, n = 10;
        
        // 1. Even or Odd
        System.out.println("\n1. Even/Odd Check:");
        System.out.println(num1 + " is " + (isEven(num1) ? "Even" : "Odd"));
        System.out.println(num2 + " is " + (isEven(num2) ? "Even" : "Odd"));
        
        // 2. Factorial
        System.out.println("\n2. Factorial:");
        System.out.println("Factorial of 5 = " + factorial(5));
        System.out.println("Factorial of 0 = " + factorial(0));
        
        // 3. Prime Check
        System.out.println("\n3. Prime Check:");
        for (int i = 2; i <= 20; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // 4. Fibonacci Series
        System.out.println("\n4. Fibonacci Series (first " + n + " numbers):");
        printFibonacci(n);
        
        // 5. GCD and LCM
        System.out.println("\n5. GCD and LCM:");
        int gcd = findGCD(num1, num2);
        int lcm = findLCM(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + " = " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " = " + lcm);
    }
    
    // Check if number is even
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
    
    // Calculate factorial
    public static long factorial(int n) {
        if (n <= 1) return 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    // Check if number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    // Print Fibonacci series
    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println();
    }
    
    // Find GCD using Euclidean algorithm
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Find LCM using GCD
    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }
}