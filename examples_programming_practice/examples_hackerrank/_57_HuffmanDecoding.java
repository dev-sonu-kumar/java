/*
 * PROBLEM STATEMENT:
 * Huffman coding assigns variable length codewords to characters based on their frequency.
 * Given a Huffman tree and an encoded string, decode the string.
 * 
 * Input: Root of Huffman tree and encoded string
 * Output: Decoded string
 * 
 * Example:
 * Tree represents: A=0, B=10, C=110, D=111
 * Input: "1001011"
 * Output: "BAC"
 * 
 * Constraints: 1 ≤ |s| ≤ 25
 */

class HuffmanNode {
    int frequency;
    char data;
    HuffmanNode left, right;
    
    HuffmanNode(int frequency, char data) {
        this.frequency = frequency;
        this.data = data;
        left = right = null;
    }
}

public class _57_HuffmanDecoding {
    public static void decode(String s, HuffmanNode root) {
        StringBuilder result = new StringBuilder();
        HuffmanNode current = root;
        
        for (char bit : s.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            
            // If we reach a leaf node
            if (current.left == null && current.right == null) {
                result.append(current.data);
                current = root; // Reset to root for next character
            }
        }
        
        System.out.print(result.toString());
    }
    
    public static void main(String[] args) {
        // Create Huffman tree for A=0, B=10, C=110, D=111
        HuffmanNode root = new HuffmanNode(0, '\0');
        root.left = new HuffmanNode(0, 'A');
        root.right = new HuffmanNode(0, '\0');
        root.right.left = new HuffmanNode(0, 'B');
        root.right.right = new HuffmanNode(0, '\0');
        root.right.right.left = new HuffmanNode(0, 'C');
        root.right.right.right = new HuffmanNode(0, 'D');
        
        System.out.print("Decoded string for '1001011': ");
        decode("1001011", root);
        System.out.println();
        
        System.out.print("Decoded string for '101111': ");
        decode("101111", root);
        System.out.println();
    }
}