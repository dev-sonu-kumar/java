/*
 * PROBLEM STATEMENT:
 * Alice has a binary string. She thinks a binary string is beautiful if and only if it doesn't contain the substring "010".
 * You can change any 0 to 1 or any 1 to 0. What is the minimum number of changes needed to make the string beautiful?
 * 
 * Example:
 * Input: b = "0101010"
 * Output: 2
 * Explanation: Change positions 2 and 4 (0-indexed) to get "0111110".
 * 
 * Constraints: 1 ≤ n ≤ 100, b[i] ∈ {0, 1}
 */

public class _31_BeautifulBinaryString {
    public static int beautifulBinaryString(String b) {
        int changes = 0;
        int i = 0;
        
        while (i <= b.length() - 3) {
            if (b.substring(i, i + 3).equals("010")) {
                changes++;
                i += 3; // Skip the next 2 characters
            } else {
                i++;
            }
        }
        
        return changes;
    }
    
    public static void main(String[] args) {
        System.out.println("Changes for '0101010': " + beautifulBinaryString("0101010"));
        System.out.println("Changes for '01010': " + beautifulBinaryString("01010"));
        System.out.println("Changes for '1111': " + beautifulBinaryString("1111"));
    }
}