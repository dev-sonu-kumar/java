/*
 * PROBLEM STATEMENT:
 * Happy Ladybugs is a board game having the following properties:
 * - The board is represented by a string, b, of length n.
 * - The ith character of the string, b[i], denotes the ith cell of the board.
 * - If b[i] is an underscore (i.e., _), it means the ith cell of the board is empty.
 * - If b[i] is an uppercase English letter (i.e., [A-Z]), it means the ith cell contains a ladybug of color b[i].
 * - A ladybug is happy if and only if its left or right adjacent cell (i.e., b[i±1]) is occupied by another ladybug having the same color.
 * - In a single move, you can move a ladybug from its current position to any empty cell.
 * 
 * Given the values of n and b for g games of Happy Ladybugs, determine if it's possible to make all the ladybugs happy.
 * 
 * Example:
 * Input: b = "RBY_YBR"
 * Output: YES
 * 
 * Constraints: 1 ≤ g ≤ 10, 1 ≤ n ≤ 100
 */

import java.util.*;

public class _72_HappyLadybugs {
    public static String happyLadybugs(String b) {
        Map<Character, Integer> count = new HashMap<>();
        boolean hasEmpty = false;
        
        // Count frequency of each character
        for (char c : b.toCharArray()) {
            if (c == '_') {
                hasEmpty = true;
            } else {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
        }
        
        // Check if any ladybug appears only once
        for (int freq : count.values()) {
            if (freq == 1) {
                return "NO";
            }
        }
        
        // If no empty spaces, check if already happy
        if (!hasEmpty) {
            return isAlreadyHappy(b) ? "YES" : "NO";
        }
        
        return "YES";
    }
    
    private static boolean isAlreadyHappy(String b) {
        for (int i = 0; i < b.length(); i++) {
            char current = b.charAt(i);
            boolean leftSame = (i > 0) && (b.charAt(i - 1) == current);
            boolean rightSame = (i < b.length() - 1) && (b.charAt(i + 1) == current);
            
            if (!leftSame && !rightSame) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("Happy ladybugs for 'RBY_YBR': " + happyLadybugs("RBY_YBR"));
        System.out.println("Happy ladybugs for 'AABBC': " + happyLadybugs("AABBC"));
        System.out.println("Happy ladybugs for 'AABBC_C': " + happyLadybugs("AABBC_C"));
    }
}