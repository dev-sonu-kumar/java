import java.util.*;
import java.util.function.*;

public class _3_MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");
        
        // 1. Static method reference
        // Lambda: x -> Integer.parseInt(x)
        Function<String, Integer> parser = Integer::parseInt;
        System.out.println("Parsed: " + parser.apply("123"));
        
        // 2. Instance method reference on particular object
        String prefix = "Hello ";
        // Lambda: s -> prefix.concat(s)
        Function<String, String> greeter = prefix::concat;
        System.out.println(greeter.apply("World"));
        
        // 3. Instance method reference on arbitrary object
        // Lambda: s -> s.toUpperCase()
        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
        
        // 4. Constructor reference
        // Lambda: () -> new ArrayList<>()
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> newList = listSupplier.get();
        
        // Lambda: size -> new ArrayList<>(size)
        Function<Integer, List<String>> listWithSize = ArrayList::new;
        List<String> sizedList = listWithSize.apply(10);
        
        // 5. Array constructor reference
        // Lambda: size -> new String[size]
        Function<Integer, String[]> arrayCreator = String[]::new;
        String[] array = arrayCreator.apply(5);
        
        // Practical examples
        List<Person> people = Arrays.asList(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 20)
        );
        
        // Method reference for sorting
        people.sort(Comparator.comparing(Person::getAge));
        System.out.println("Sorted by age: " + people);
        
        // Method reference for filtering and mapping
        people.stream()
              .filter(p -> p.getAge() > 22)
              .map(Person::getName)
              .forEach(System.out::println);
    }
}

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    
    public String toString() {
        return name + "(" + age + ")";
    }
}