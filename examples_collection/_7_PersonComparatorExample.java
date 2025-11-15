package examples_collection;

import java.util.*;

class Person {
    String name;
    int age;
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String toString() {
        return name + "(" + age + ")";
    }
}

class AgeComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.age, p2.age);
    }
}

public class _7_PersonComparatorExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 20)
        );
        
        // Sort by age using custom comparator class
        people.sort(new AgeComparator());
        System.out.println("By age: " + people);
        
        // Sort by name using lambda
        people.sort((p1, p2) -> p1.name.compareTo(p2.name));
        System.out.println("By name: " + people);
        
        // Sort by age using Comparator.comparing
        people.sort(Comparator.comparing(p -> p.age));
        System.out.println("By age (method ref): " + people);
    }
}