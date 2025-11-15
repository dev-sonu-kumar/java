import java.util.*;
import java.util.stream.*;

public class _4_StreamLambdaExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter even numbers and double them
        List<Integer> result = numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * 2)
            .collect(Collectors.toList());
        
        System.out.println("Even numbers doubled: " + result);
        
        // Find sum of squares of odd numbers
        int sumOfSquares = numbers.stream()
            .filter(n -> n % 2 != 0)
            .mapToInt(n -> n * n)
            .sum();
        
        System.out.println("Sum of squares of odd numbers: " + sumOfSquares);
        
        // Working with strings
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        
        // Filter words longer than 5 characters and convert to uppercase
        words.stream()
             .filter(word -> word.length() > 5)
             .map(String::toUpperCase)
             .forEach(System.out::println);
        
        // Group words by length
        Map<Integer, List<String>> wordsByLength = words.stream()
            .collect(Collectors.groupingBy(String::length));
        
        System.out.println("Words grouped by length: " + wordsByLength);
        
        // Working with custom objects
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 50000, "IT"),
            new Employee("Bob", 60000, "Finance"),
            new Employee("Charlie", 55000, "IT"),
            new Employee("David", 70000, "Finance"),
            new Employee("Eve", 45000, "HR")
        );
        
        // Find average salary by department
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));
        
        System.out.println("Average salary by department: " + avgSalaryByDept);
        
        // Find highest paid employee
        Optional<Employee> highestPaid = employees.stream()
            .max(Comparator.comparing(Employee::getSalary));
        
        highestPaid.ifPresent(emp -> 
            System.out.println("Highest paid: " + emp.getName() + " - $" + emp.getSalary()));
        
        // Parallel stream for performance
        long count = numbers.parallelStream()
            .filter(n -> n > 5)
            .count();
        
        System.out.println("Numbers greater than 5: " + count);
    }
}

class Employee {
    private String name;
    private double salary;
    private String department;
    
    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
}