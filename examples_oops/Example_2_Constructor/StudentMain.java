package examples_oops.Example_2_Constructor;

public class StudentMain {
    public static void main(String[] args) {
        // Using default constructor
        Student s1 = new Student();
        s1.showInfo();

        // Using parameterized constructor
        Student s2 = new Student("Amit", 20);
        s2.showInfo();

        Student s3 = new Student("Neha", 22);
        s3.showInfo();
    }
}
