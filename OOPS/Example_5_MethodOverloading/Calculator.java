package OOPS.Example_5_MethodOverloading;

// Method overloading means multiple methods in the same class with the same name, but different parameters.
// It helps increase code readability and flexibility.

// Rules for Overloading:
// Methods must have the same name.
// Methods must have different parameters:
// Different number of parameters
// Or different types of parameters
// Return type can be same or different, but it doesn't matter for overloading.

public class Calculator {

    // Method 1: Add two integers
    int add(int a, int b) {
        return a + b;
    }

    // Method 2: Add three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method 3: Add two doubles
    double add(double a, double b) {
        return a + b;
    }

    // Method 4: Add string numbers (simulate)
    String add(String a, String b) {
        return a + b;
    }
}
