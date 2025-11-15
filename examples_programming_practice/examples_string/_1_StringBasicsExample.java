/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates fundamental string operations:
 * 1. String creation and basic methods
 * 2. String comparison techniques
 * 3. String manipulation (substring, replace, etc.)
 * 4. Character counting and frequency analysis
 * 5. Palindrome checking
 * 6. String reversal techniques
 */

public class _1_StringBasicsExample {
    public static void main(String[] args) {
        System.out.println("=== String Basics Operations ===");
        
        // Test strings
        String str1 = "Hello World";
        String str2 = "Java Programming";
        String str3 = "madam";
        String str4 = "Hello World";
        
        // 1. Basic string methods
        System.out.println("\n1. Basic String Methods:");
        demonstrateBasicMethods(str1);
        
        // 2. String comparison
        System.out.println("\n2. String Comparison:");
        demonstrateStringComparison(str1, str4);
        
        // 3. String manipulation
        System.out.println("\n3. String Manipulation:");
        demonstrateStringManipulation(str2);
        
        // 4. Character counting
        System.out.println("\n4. Character Counting:");
        countCharacters(str1);
        
        // 5. Palindrome check
        System.out.println("\n5. Palindrome Check:");
        System.out.println("'" + str3 + "' is palindrome: " + isPalindrome(str3));
        System.out.println("'" + str1 + "' is palindrome: " + isPalindrome(str1));
        
        // 6. String reversal
        System.out.println("\n6. String Reversal:");
        System.out.println("Original: " + str1);
        System.out.println("Reversed: " + reverseString(str1));
    }
    
    // Demonstrate basic string methods
    public static void demonstrateBasicMethods(String str) {
        System.out.println("String: '" + str + "'");
        System.out.println("Length: " + str.length());
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("First character: " + str.charAt(0));
        System.out.println("Last character: " + str.charAt(str.length() - 1));
        System.out.println("Contains 'World': " + str.contains("World"));
        System.out.println("Starts with 'Hello': " + str.startsWith("Hello"));
        System.out.println("Ends with 'World': " + str.endsWith("World"));
    }
    
    // Demonstrate string comparison methods
    public static void demonstrateStringComparison(String str1, String str2) {
        System.out.println("String 1: '" + str1 + "'");
        System.out.println("String 2: '" + str2 + "'");
        System.out.println("equals(): " + str1.equals(str2));
        System.out.println("equalsIgnoreCase(): " + str1.equalsIgnoreCase(str2));
        System.out.println("compareTo(): " + str1.compareTo(str2));
        System.out.println("== operator: " + (str1 == str2));
        
        // String pool demonstration
        String str3 = "Hello World";
        System.out.println("String pool (==): " + (str1 == str3));
    }
    
    // Demonstrate string manipulation
    public static void demonstrateStringManipulation(String str) {
        System.out.println("Original: '" + str + "'");
        System.out.println("Substring(0,4): '" + str.substring(0, 4) + "'");
        System.out.println("Substring(5): '" + str.substring(5) + "'");
        System.out.println("Replace 'a' with '@': '" + str.replace('a', '@') + "'");
        System.out.println("Replace 'Java' with 'Python': '" + str.replace("Java", "Python") + "'");
        
        // Split string
        String[] words = str.split(" ");
        System.out.print("Split by space: ");
        for (String word : words) {
            System.out.print("'" + word + "' ");
        }
        System.out.println();
        
        // Trim whitespace
        String strWithSpaces = "  " + str + "  ";
        System.out.println("With spaces: '" + strWithSpaces + "'");
        System.out.println("Trimmed: '" + strWithSpaces.trim() + "'");
    }
    
    // Count characters and analyze frequency
    public static void countCharacters(String str) {
        System.out.println("Analyzing: '" + str + "'");
        
        int vowels = 0, consonants = 0, digits = 0, spaces = 0, others = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            
            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            } else {
                others++;
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);
        System.out.println("Others: " + others);
    }
    
    // Check if string is palindrome
    public static boolean isPalindrome(String str) {
        // Remove spaces and convert to lowercase
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        
        int left = 0, right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // Reverse string using StringBuilder
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    // Alternative: Reverse string manually
    public static String reverseStringManual(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
}