package OOPS.Example_2_Constructor;

// Constructor Rules:
// Constructor name = class name.
// No return type (not even void).
// Java provides a default constructor automatically if you don’t write any.
// Constructor overloading – Multiple constructors with different parameters.

public class Student {
    String name;
    int age;

    // Default constructor
    Student() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized constructor
    Student(String studentName, int studentAge) {
        name = studentName;
        age = studentAge;
    }

    // Method to display data
    void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
