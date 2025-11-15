/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates various pattern printing techniques:
 * 1. Right triangle star pattern
 * 2. Inverted triangle pattern
 * 3. Pyramid pattern
 * 4. Diamond pattern
 * 5. Number patterns
 * 6. Floyd's triangle
 */

public class _2_PatternPrintingExample {
    public static void main(String[] args) {
        System.out.println("=== Pattern Printing Examples ===");
        
        int rows = 5;
        
        // 1. Right Triangle
        System.out.println("\n1. Right Triangle Pattern:");
        printRightTriangle(rows);
        
        // 2. Inverted Triangle
        System.out.println("\n2. Inverted Triangle Pattern:");
        printInvertedTriangle(rows);
        
        // 3. Pyramid
        System.out.println("\n3. Pyramid Pattern:");
        printPyramid(rows);
        
        // 4. Diamond
        System.out.println("\n4. Diamond Pattern:");
        printDiamond(rows);
        
        // 5. Number Pattern
        System.out.println("\n5. Number Pattern:");
        printNumberPattern(rows);
        
        // 6. Floyd's Triangle
        System.out.println("\n6. Floyd's Triangle:");
        printFloydsTriangle(rows);
    }
    
    // Right triangle pattern
    public static void printRightTriangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    // Inverted triangle pattern
    public static void printInvertedTriangle(int rows) {
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    // Pyramid pattern
    public static void printPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    // Diamond pattern
    public static void printDiamond(int rows) {
        // Upper half (including middle)
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Lower half
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    // Number pattern
    public static void printNumberPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
    // Floyd's triangle
    public static void printFloydsTriangle(int rows) {
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}