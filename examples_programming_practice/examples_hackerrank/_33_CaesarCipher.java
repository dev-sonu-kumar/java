/*
 * PROBLEM STATEMENT:
 * Julius Caesar protected his confidential information by encrypting it using a cipher.
 * Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet.
 * In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
 * 
 * Original alphabet:      abcdefghijklmnopqrstuvwxyz
 * Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc
 * 
 * Example:
 * Input: s = "middle-Outz", k = 2
 * Output: "okffng-Qwvb"
 * 
 * Constraints: 1 ≤ |s| ≤ 100, 0 ≤ k ≤ 100
 */

public class _33_CaesarCipher {
    public static String caesarCipher(String s, int k) {
        StringBuilder result = new StringBuilder();
        k = k % 26; // Handle cases where k > 26
        
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char shifted = (char) ((c - base + k) % 26 + base);
                result.append(shifted);
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("Caesar cipher of 'middle-Outz' with k=2: " + caesarCipher("middle-Outz", 2));
        System.out.println("Caesar cipher of 'Hello_World!' with k=4: " + caesarCipher("Hello_World!", 4));
    }
}