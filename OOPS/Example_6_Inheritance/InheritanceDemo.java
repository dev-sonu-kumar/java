package OOPS.Example_6_Inheritance;

public class InheritanceDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();

        dog.name = "Tommy";
        dog.eat(); // Inherited from Animal
        dog.sleep(); // Inherited from Animal
        dog.bark(); // Defined in Dog
    }
}
