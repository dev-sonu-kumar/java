# String Programming Guide 🚀

## 📚 Learning Path (Recommended Order)

**Master string fundamentals:**
1. **String Basics** - Fundamental operations and manipulations
2. **String Algorithms** - Advanced algorithms and pattern matching

---

## 1. String Basics

### Program Objectives
- Master fundamental string operations in Java
- Understand string immutability and performance implications
- Learn character manipulation and analysis techniques
- Practice string comparison and validation methods

### Key Operations Covered
- **String Creation** - Literal vs constructor, string pool
- **Basic Methods** - Length, charAt, substring operations
- **String Comparison** - equals, compareTo, equalsIgnoreCase
- **String Manipulation** - Replace, split, trim operations
- **Character Analysis** - Counting vowels, consonants, digits
- **Palindrome Detection** - Forward-backward comparison
- **String Reversal** - StringBuilder vs manual approach

### Time Complexity Analysis
| Operation | Time Complexity | Space Complexity | Notes |
|-----------|----------------|------------------|-------|
| charAt(i) | O(1) | O(1) | Direct array access |
| length() | O(1) | O(1) | Stored as field |
| substring() | O(n) | O(n) | Creates new string |
| equals() | O(n) | O(1) | Character comparison |
| replace() | O(n) | O(n) | Creates new string |
| split() | O(n) | O(k) | k = number of parts |
| Palindrome check | O(n/2) | O(1) | Two-pointer approach |
| String reversal | O(n) | O(n) | StringBuilder approach |

### String Immutability Impact
```java
// Inefficient - creates multiple string objects
String result = "";
for (int i = 0; i < n; i++) {
    result += "a"; // O(n²) time complexity
}

// Efficient - uses mutable StringBuilder
StringBuilder sb = new StringBuilder();
for (int i = 0; i < n; i++) {
    sb.append("a"); // O(n) time complexity
}
String result = sb.toString();
```

### Key Algorithms
```java
// Efficient palindrome check
public static boolean isPalindrome(String str) {
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

// Character frequency analysis
public static Map<Character, Integer> getCharFrequency(String str) {
    Map<Character, Integer> frequency = new HashMap<>();
    for (char c : str.toCharArray()) {
        frequency.put(c, frequency.getOrDefault(c, 0) + 1);
    }
    return frequency;
}
```

### Interview Questions
- Check if two strings are anagrams
- Find first non-repeating character
- Reverse words in a string
- Remove duplicates from string
- Check if string has all unique characters

---

## 2. String Algorithms

### Program Objectives
- Implement advanced string processing algorithms
- Master pattern matching techniques
- Understand dynamic programming with strings
- Learn string compression and optimization

### Advanced Algorithms Covered
- **Anagram Detection** - Sorting vs frequency counting
- **String Rotation** - Concatenation technique
- **Longest Common Subsequence** - Dynamic programming
- **Pattern Matching** - Naive and optimized approaches
- **String Compression** - Run-length encoding
- **Duplicate Removal** - Preserving order

### Algorithm Comparison
| Algorithm | Time Complexity | Space Complexity | Approach |
|-----------|----------------|------------------|----------|
| Anagram (Sort) | O(n log n) | O(n) | Sort and compare |
| Anagram (Frequency) | O(n) | O(1) | Character counting |
| String Rotation | O(n) | O(n) | Concatenation check |
| LCS (DP) | O(m×n) | O(m×n) | Dynamic programming |
| Pattern Match (Naive) | O(n×m) | O(1) | Brute force |
| String Compression | O(n) | O(n) | Single pass |
| Remove Duplicates | O(n) | O(n) | Set-based approach |

### Advanced Techniques
```java
// Anagram detection using frequency array
public static boolean areAnagrams(String str1, String str2) {
    if (str1.length() != str2.length()) return false;
    
    int[] frequency = new int[26];
    for (int i = 0; i < str1.length(); i++) {
        frequency[str1.charAt(i) - 'a']++;
        frequency[str2.charAt(i) - 'a']--;
    }
    
    for (int count : frequency) {
        if (count != 0) return false;
    }
    return true;
}

// String rotation check
public static boolean isRotation(String str1, String str2) {
    if (str1.length() != str2.length()) return false;
    return (str1 + str1).contains(str2);
}

// LCS using dynamic programming
public static String longestCommonSubsequence(String str1, String str2) {
    int m = str1.length(), n = str2.length();
    int[][] dp = new int[m + 1][n + 1];
    
    // Fill DP table
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    
    // Reconstruct LCS
    StringBuilder lcs = new StringBuilder();
    int i = m, j = n;
    while (i > 0 && j > 0) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            lcs.insert(0, str1.charAt(i - 1));
            i--; j--;
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            i--;
        } else {
            j--;
        }
    }
    return lcs.toString();
}
```

### Pattern Matching Algorithms
```java
// KMP Pattern Matching (Advanced)
public static List<Integer> KMPSearch(String text, String pattern) {
    List<Integer> matches = new ArrayList<>();
    int[] lps = computeLPSArray(pattern);
    
    int i = 0, j = 0; // i for text, j for pattern
    while (i < text.length()) {
        if (pattern.charAt(j) == text.charAt(i)) {
            i++; j++;
        }
        
        if (j == pattern.length()) {
            matches.add(i - j);
            j = lps[j - 1];
        } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
            if (j != 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
    }
    return matches;
}

private static int[] computeLPSArray(String pattern) {
    int[] lps = new int[pattern.length()];
    int len = 0, i = 1;
    
    while (i < pattern.length()) {
        if (pattern.charAt(i) == pattern.charAt(len)) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}
```

---

## String Processing Patterns

### Common Problem Types
1. **Validation Problems** - Palindrome, anagram, rotation
2. **Transformation Problems** - Reverse, compress, encode
3. **Search Problems** - Pattern matching, substring finding
4. **Analysis Problems** - Character frequency, longest subsequence
5. **Optimization Problems** - Edit distance, string alignment

### Problem-Solving Strategies
1. **Two-Pointer Technique** - Palindrome, reverse operations
2. **Sliding Window** - Substring problems with constraints
3. **Dynamic Programming** - LCS, edit distance, pattern matching
4. **Hashing** - Anagram detection, duplicate finding
5. **Preprocessing** - Sort for anagrams, build auxiliary arrays

---

## Performance Optimization

### String vs StringBuilder
```java
// Poor performance - O(n²)
String result = "";
for (String word : words) {
    result += word + " ";
}

// Good performance - O(n)
StringBuilder sb = new StringBuilder();
for (String word : words) {
    sb.append(word).append(" ");
}
String result = sb.toString();
```

### Memory Considerations
- **String Pool** - Literal strings are cached
- **Substring Memory Leak** - Pre-Java 7 issue
- **Character Arrays** - More efficient for heavy manipulation
- **Intern() Method** - Explicit string pool management

---

## Code Examples Summary

**📁 Study in this sequence:**
1. `_1_StringBasicsExample.java` - **START HERE** - Fundamental operations
2. `_2_StringAlgorithmsExample.java` - Advanced algorithms and patterns

---

## Practice Problems

### Beginner Level
1. Count vowels and consonants in string
2. Check if string is palindrome
3. Reverse each word in sentence
4. Find length of string without using length()
5. Convert string to uppercase/lowercase manually

### Intermediate Level
1. Find all anagrams in a list of strings
2. Implement string compression algorithm
3. Find longest palindromic substring
4. Check if strings are rotations of each other
5. Remove all duplicates from string

### Advanced Level
1. Implement edit distance algorithm
2. Find longest common substring
3. Pattern matching with wildcards
4. String matching with regular expressions
5. Implement Trie for string operations

---

## Interview Preparation Tips

### Must-Know Concepts
- **String immutability** and its implications
- **StringBuilder vs String** performance differences
- **Character encoding** (ASCII, Unicode)
- **Regular expressions** basics
- **Common string algorithms** (anagram, palindrome, LCS)

### Common Pitfalls
- **Null pointer exceptions** - Always check for null
- **Index out of bounds** - Validate string indices
- **Case sensitivity** - Consider case-insensitive comparisons
- **Unicode handling** - Be aware of multi-byte characters
- **Performance issues** - Avoid string concatenation in loops

### Optimization Strategies
- **Use StringBuilder** for multiple concatenations
- **Cache string length** if used multiple times
- **Use char arrays** for heavy character manipulation
- **Consider regex alternatives** for simple operations
- **Preprocess strings** when possible for multiple operations

This comprehensive guide covers all essential string programming concepts needed for technical interviews and competitive programming! 🎯