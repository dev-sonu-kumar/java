import java.util.*;
import java.util.function.*;

public class _5_CollectionLambdaExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date", "elderberry"));
        
        // forEach with lambda
        System.out.println("All fruits:");
        fruits.forEach(fruit -> System.out.println("- " + fruit));
        
        // removeIf with lambda
        fruits.removeIf(fruit -> fruit.length() < 5);
        System.out.println("Fruits with 5+ characters: " + fruits);
        
        // replaceAll with lambda
        fruits.replaceAll(fruit -> fruit.toUpperCase());
        System.out.println("Uppercase fruits: " + fruits);
        
        // sort with lambda
        fruits.sort((a, b) -> b.compareTo(a)); // Reverse order
        System.out.println("Reverse sorted: " + fruits);
        
        // Map operations with lambda
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("apples", 10);
        inventory.put("bananas", 5);
        inventory.put("cherries", 15);
        
        // forEach on map
        inventory.forEach((fruit, count) -> 
            System.out.println(fruit + ": " + count + " items"));
        
        // compute with lambda
        inventory.compute("apples", (fruit, count) -> count + 5);
        System.out.println("After adding apples: " + inventory.get("apples"));
        
        // computeIfAbsent with lambda
        inventory.computeIfAbsent("oranges", fruit -> 20);
        System.out.println("Inventory after adding oranges: " + inventory);
        
        // merge with lambda
        inventory.merge("bananas", 10, (oldVal, newVal) -> oldVal + newVal);
        System.out.println("Bananas after merge: " + inventory.get("bananas"));
        
        // Custom operations with lambda
        List<Product> products = Arrays.asList(
            new Product("Laptop", 999.99, "Electronics"),
            new Product("Book", 19.99, "Education"),
            new Product("Phone", 699.99, "Electronics"),
            new Product("Pen", 2.99, "Office")
        );
        
        // Custom filter and action
        processProducts(products, 
            product -> product.getPrice() > 50,  // Filter
            product -> System.out.println("Expensive: " + product.getName()) // Action
        );
        
        // Custom transformation
        List<String> productNames = transformList(products, Product::getName);
        System.out.println("Product names: " + productNames);
        
        // Custom reduction
        double totalValue = products.stream()
            .mapToDouble(Product::getPrice)
            .reduce(0.0, (sum, price) -> sum + price);
        
        System.out.println("Total inventory value: $" + totalValue);
    }
    
    // Generic method using lambda
    public static <T> void processProducts(List<T> list, Predicate<T> filter, Consumer<T> action) {
        for (T item : list) {
            if (filter.test(item)) {
                action.accept(item);
            }
        }
    }
    
    // Generic transformation method
    public static <T, R> List<R> transformList(List<T> list, Function<T, R> transformer) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(transformer.apply(item));
        }
        return result;
    }
}

class Product {
    private String name;
    private double price;
    private String category;
    
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
}