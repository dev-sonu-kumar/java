package examples_collection_map;
import java.util.*;

public class _3_TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        
        // Add elements (automatically sorted by key)
        map.put("Zebra", 26);
        map.put("Apple", 1);
        map.put("Mango", 13);
        map.put("Banana", 2);
        
        System.out.println("Sorted TreeMap: " + map);
        
        // NavigableMap operations
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());
        System.out.println("Lower than Mango: " + map.lowerKey("Mango"));
        System.out.println("Higher than Mango: " + map.higherKey("Mango"));
        
        // Range operations
        System.out.println("Head map (< Mango): " + map.headMap("Mango"));
        System.out.println("Tail map (>= Mango): " + map.tailMap("Mango"));
        System.out.println("Sub map (Banana to Mango): " + map.subMap("Banana", "Mango"));
        
        // Custom comparator TreeMap
        TreeMap<String, Integer> reverseMap = new TreeMap<>(Collections.reverseOrder());
        reverseMap.putAll(map);
        System.out.println("Reverse order: " + reverseMap);
        
        // TreeMap with custom objects
        TreeMap<Person, String> personMap = new TreeMap<>();
        personMap.put(new Person("Alice", 25), "Engineer");
        personMap.put(new Person("Bob", 30), "Manager");
        personMap.put(new Person("Charlie", 20), "Intern");
        
        System.out.println("Person TreeMap: " + personMap);
    }
}

class Person implements Comparable<Person> {
    String name;
    int age;
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }
    
    public String toString() {
        return name + "(" + age + ")";
    }
}