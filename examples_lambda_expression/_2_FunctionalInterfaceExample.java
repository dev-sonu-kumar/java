import java.util.function.*;

public class _2_FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Predicate - takes input, returns boolean
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 5 even? " + isEven.test(5));
        
        // Function - takes input, returns output
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
        
        // Consumer - takes input, returns nothing
        Consumer<String> printer = s -> System.out.println("Processing: " + s);
        printer.accept("Lambda");
        
        // Supplier - takes nothing, returns output
        Supplier<Double> randomNumber = () -> Math.random();
        System.out.println("Random number: " + randomNumber.get());
        
        // BiFunction - takes two inputs, returns output
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("5 + 3 = " + add.apply(5, 3));
        
        // Custom functional interface
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> a / b;
        
        System.out.println("4 * 3 = " + multiply.calculate(4, 3));
        System.out.println("8 / 2 = " + divide.calculate(8, 2));
        
        // Chaining functions
        Function<String, String> addExclamation = s -> s + "!";
        Function<String, String> makeUpperCase = s -> s.toUpperCase();
        
        Function<String, String> combined = addExclamation.andThen(makeUpperCase);
        System.out.println(combined.apply("hello")); // HELLO!
    }
}

@FunctionalInterface
interface Calculator {
    double calculate(double a, double b);
}