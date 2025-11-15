package examples_oops.Example_3_CopyConstructor;

public class CopyConstructorDemo {
    public static void main(String[] args) {
        // Original object
        Person p1 = new Person("Ravi", 25);

        // Copy of p1 using copy constructor
        Person p2 = new Person(p1);

        // Display both
        p1.display();
        p2.display();
    }
}
