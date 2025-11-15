package examples_oops.Example_4_This;

// this refers to the current object.

// It's used to differentiate between instance variables and parameters when they have the same name.

// It can also be used to call another constructor from within a constructor.

public class Student {
    String name;
    int age;

    // Constructor
    Student(String name, int age) {
        this.name = name; // 'this.name' refers to the instance variable
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Here, this.name refers to the class variable, while name (on the right side)
// is the constructor parameter.