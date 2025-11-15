package examples_oops.Example_5_MethodOverloading;

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Add 2 ints: " + calc.add(5, 10)); // 15
        System.out.println("Add 3 ints: " + calc.add(1, 2, 3)); // 6
        System.out.println("Add 2 doubles: " + calc.add(2.5, 3.5)); // 6.0
        System.out.println("Add strings: " + calc.add("Hello ", "Java")); // Hello Java
    }
}
