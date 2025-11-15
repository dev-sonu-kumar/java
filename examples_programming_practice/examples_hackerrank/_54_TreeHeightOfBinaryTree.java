/*
 * PROBLEM STATEMENT:
 * The height of a binary tree is the number of edges between the tree's root and its furthest leaf.
 * Complete the getHeight or height function in the editor. It must return the height of a binary tree as an integer.
 * 
 * Input: A binary tree
 * Output: Height of the tree
 * 
 * Example:
 * Tree:     3
 *          / \
 *         2   5
 *        /   / \
 *       1   4   6
 *              /
 *             7
 * Output: 3
 * 
 * Constraints: 1 ≤ node.data[i] ≤ 20, 1 ≤ number of nodes ≤ 20
 */

public class _54_TreeHeightOfBinaryTree {
    public static int height(Node root) {
        if (root == null) {
            return -1; // Height of empty tree is -1
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static void main(String[] args) {
        // Create tree with height 3
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);
        
        System.out.println("Height of tree: " + height(root));
        
        // Single node tree
        Node singleNode = new Node(1);
        System.out.println("Height of single node: " + height(singleNode));
    }
}