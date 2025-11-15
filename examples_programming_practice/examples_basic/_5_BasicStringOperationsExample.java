/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates basic string operations and character manipulation:
 * 1. String creation and basic methods
 * 2. Character manipulation and ASCII values
 * 3. String comparison and searching
 * 4. String formatting and case conversion
 * 5. Basic string algorithms (palindrome, reverse)
 */

public class _5_BasicStringOperationsExample {
    public static void main(String[] args) {
        System.out.println("=== Basic String Operations ===");
        
        // 1. String Creation and Basic Methods
        System.out.println("\n1. String Basics:");
        String str1 = "Hello World";
        String str2 = new String("Java Programming");
        
        System.out.println("String 1: " + str1);
        System.out.println("Length: " + str1.length());
        System.out.println("Character at index 6: " + str1.charAt(6));
        System.out.println("Substring (0,5): " + str1.substring(0, 5));
        
        // 2. Character Manipulation
        System.out.println("\n2. Character Operations:");
        String text = "Programming";
        System.out.println("Original: " + text);
        
        // Character analysis
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            System.out.printf("'%c' -> ASCII: %d, Uppercase: %c, Lowercase: %c%n", 
                            ch, (int)ch, Character.toUpperCase(ch), Character.toLowerCase(ch));
        }
        
        // 3. String Comparison
        System.out.println("\n3. String Comparison:");
        String name1 = "Alice";
        String name2 = "alice";
        String name3 = "Alice";
        
        System.out.println("name1.equals(name2): " + name1.equals(name2));
        System.out.println("name1.equalsIgnoreCase(name2): " + name1.equalsIgnoreCase(name2));
        System.out.println("name1.equals(name3): " + name1.equals(name3));
        System.out.println("name1.compareTo(name2): " + name1.compareTo(name2));
        
        // 4. String Searching and Manipulation
        System.out.println("\n4. String Searching:");
        String sentence = "Java is powerful and Java is popular";
        System.out.println("Original: " + sentence);
        System.out.println("Contains 'Java': " + sentence.contains("Java"));
        System.out.println("First occurrence of 'Java': " + sentence.indexOf("Java"));
        System.out.println("Last occurrence of 'Java': " + sentence.lastIndexOf("Java"));
        System.out.println("Starts with 'Java': " + sentence.startsWith("Java"));
        System.out.println("Ends with 'popular': " + sentence.endsWith("popular"));
        
        // 5. String Formatting and Case Conversion
        System.out.println("\n5. String Formatting:");
        String original = "  Hello Java World  ";
        System.out.println("Original: '" + original + "'");
        System.out.println("Trimmed: '" + original.trim() + "'");
        System.out.println("Uppercase: " + original.trim().toUpperCase());
        System.out.println("Lowercase: " + original.trim().toLowerCase());
        System.out.println("Replace 'Java' with 'Python': " + original.trim().replace("Java", "Python"));
        
        // 6. String Algorithms
        System.out.println("\n6. String Algorithms:");
        
        // Palindrome check
        String[] testWords = {"radar", "hello", "level", "java", "madam"};
        System.out.println("Palindrome Check:");
        for (String word : testWords) {
            System.out.println(word + " -> " + (isPalindrome(word) ? "Palindrome" : "Not Palindrome"));
        }
        
        // String reversal
        System.out.println("\nString Reversal:");
        String toReverse = "Programming";
        System.out.println("Original: " + toReverse);
        System.out.println("Reversed: " + reverseString(toReverse));
        
        // Character frequency
        System.out.println("\nCharacter Frequency:");
        String word = "programming";
        System.out.println("Word: " + word);
        printCharacterFrequency(word);
        
        // 7. String Building
        System.out.println("\n7. String Building:");
        StringBuilder sb = new StringBuilder();
        sb.append("Java");
        sb.append(" is");
        sb.append(" awesome!");
        System.out.println("StringBuilder result: " + sb.toString());
        
        // Insert and delete operations
        sb.insert(4, " Programming");
        System.out.println("After insert: " + sb.toString());
        sb.delete(4, 16);
        System.out.println("After delete: " + sb.toString());
    }
    
    // Check if string is palindrome
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // Reverse a string
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
    
    // Print character frequency
    public static void printCharacterFrequency(String str) {
        int[] frequency = new int[256]; // ASCII characters
        
        // Count frequency
        for (int i = 0; i < str.length(); i++) {
            frequency[str.charAt(i)]++;
        }
        
        // Print frequency
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                System.out.println("'" + (char)i + "' appears " + frequency[i] + " time(s)");
            }
        }
    }
}