import java.util.*;

public class _1_BasicLambdaExample {
    public static void main(String[] args) {
        // Traditional approach with anonymous class
        Runnable oldWay = new Runnable() {
            public void run() {
                System.out.println("Old way with anonymous class");
            }
        };
        
        // Lambda expression - much cleaner
        Runnable newWay = () -> System.out.println("New way with lambda");
        
        oldWay.run();
        newWay.run();
        
        // Lambda with parameters
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        // Old way
        Collections.sort(names, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        
        // Lambda way
        Collections.sort(names, (a, b) -> a.compareTo(b));
        
        // Even simpler with method reference
        Collections.sort(names, String::compareTo);
        
        System.out.println("Sorted names: " + names);
        
        // Lambda with forEach
        names.forEach(name -> System.out.println("Hello " + name));
        
        // Method reference with forEach
        names.forEach(System.out::println);
    }
}