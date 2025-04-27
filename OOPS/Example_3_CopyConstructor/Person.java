package OOPS.Example_3_CopyConstructor;

// A copy constructor is used to create a new object by copying the values from an existing object.
// Java doesn’t have a built-in copy constructor like C++, but you can create your own.
// The copy constructor takes another object of the same class as a parameter.
// It copies all the fields from that object.
// This is useful when you want to clone objects or make independent copies.

public class Person {
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
