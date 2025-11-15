package examples_oops.Example_1_Class;

// A class is like a blueprint — it defines the structure (variables) and behavior (methods) of objects.

// An object is an instance of a class. It uses the blueprint defined by the class to hold its own data and behavior.

public class Car {

    // Fields (properties)
    String color;
    String model;
    int year;

    // Method (behavior)
    void startEngine() {
        System.out.println(model + " engine started.");
    }

    void showDetails() {
        System.out.println("Model: " + model + ", Color: " + color + ", Year: " + year);
    }
}
