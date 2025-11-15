package examples_collection_map;
import java.util.*;

public class _5_TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        
        // Add elements (automatically sorted)
        set.add(50);
        set.add(20);
        set.add(80);
        set.add(10);
        set.add(30);
        
        System.out.println("Sorted TreeSet: " + set);
        
        // NavigableSet operations
        System.out.println("First: " + set.first());
        System.out.println("Last: " + set.last());
        System.out.println("Lower than 30: " + set.lower(30));
        System.out.println("Higher than 30: " + set.higher(30));
        System.out.println("Floor of 25: " + set.floor(25));
        System.out.println("Ceiling of 25: " + set.ceiling(25));
        
        // Range operations
        System.out.println("Head set (< 50): " + set.headSet(50));
        System.out.println("Tail set (>= 50): " + set.tailSet(50));
        System.out.println("Sub set (20 to 80): " + set.subSet(20, 80));
        
        // Poll operations
        System.out.println("Poll first: " + set.pollFirst());
        System.out.println("Poll last: " + set.pollLast());
        System.out.println("After polling: " + set);
        
        // Custom comparator TreeSet
        TreeSet<String> stringSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        stringSet.addAll(Arrays.asList("apple", "Banana", "cherry", "DATE"));
        System.out.println("Case insensitive: " + stringSet);
        
        // TreeSet with custom objects
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));
        
        System.out.println("Students by grade: " + students);
    }
}

class Student implements Comparable<Student> {
    String name;
    int grade;
    
    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    
    public int compareTo(Student other) {
        return Integer.compare(other.grade, this.grade); // Descending order
    }
    
    public String toString() {
        return name + "(" + grade + ")";
    }
}