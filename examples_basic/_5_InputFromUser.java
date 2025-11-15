package examples_basic;

import java.util.Scanner;

public class _5_InputFromUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // nextLine() Full line of text
        // next() Single word
        // nextInt() Integer
        // nextDouble() Decimal number
        // nextBoolean() true/false

        System.out.print("Enter Your Name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter Your Age: ");
        int userAge = scanner.nextInt();

        scanner.close();
        System.out.println("Welcome " + userName + " " + "your age is : " + userAge);
    }
}
