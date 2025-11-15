/*
 * PROBLEM STATEMENT:
 * There is a collection of rocks where each rock has various minerals embeded in it. Each type of mineral is designated by a lowercase letter in the range a-z.
 * There may be multiple occurrences of a mineral in a rock. A mineral is called a gemstone if it occurs at least once in each of the rocks in the collection.
 * 
 * Given a list of minerals embedded in each of the rocks, display the number of types of gemstones in the collection.
 * 
 * Example:
 * Input: arr = ["abcdde", "baccd", "eeabg"]
 * Output: 2
 * Explanation: Only 'a' and 'b' are present in all rocks.
 * 
 * Constraints: 1 ≤ n ≤ 100, 1 ≤ |arr[i]| ≤ 100
 */

import java.util.*;

public class _29_Gemstones {
    public static int gemstones(String[] arr) {
        Set<Character> gemstones = new HashSet<>();
        
        // Initialize with characters from first rock
        for (char c : arr[0].toCharArray()) {
            gemstones.add(c);
        }
        
        // Check each subsequent rock
        for (int i = 1; i < arr.length; i++) {
            Set<Character> currentRock = new HashSet<>();
            for (char c : arr[i].toCharArray()) {
                currentRock.add(c);
            }
            
            // Keep only characters present in current rock
            gemstones.retainAll(currentRock);
        }
        
        return gemstones.size();
    }
    
    public static void main(String[] args) {
        String[] arr = {"abcdde", "baccd", "eeabg"};
        System.out.println("Number of gemstones: " + gemstones(arr));
    }
}