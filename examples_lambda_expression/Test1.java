package examples_lambda_expression;

public class Test1 {
    public static void main(String[] args) {
        Person obj1 = new Person("John", 20);
        obj1.setName("sonu");
        obj1.sayHello();
        obj1.showAge();
        boolean valid = Person.isValidAge(25);
        System.out.println(valid); // true

        Person.counter++; // Increment the static counter
        System.out.println(Person.counter); // Print the static counter



        Person obj2 = new Person("stev john", 30);
        obj2.sayHello();
        obj2.showAge();

        Person.counter++; // Increment the static counter
        System.out.println(Person.counter); // Print the static counter
    }
}
