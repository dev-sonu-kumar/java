/*
 * PROBLEM STATEMENT:
 * Complete the preOrder function in the editor below, which has 1 parameter: a pointer to the root of a binary tree.
 * It must print the values in the tree's preorder traversal as a single line of space-separated values.
 * 
 * Input: A binary tree
 * Output: Preorder traversal of the tree
 * 
 * Example:
 * Tree:     1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Output: 1 2 4 5 3
 * 
 * Constraints: 1 ≤ Nodes in the tree ≤ 500
 */

class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class _51_TreePreorderTraversal {
    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    public static void main(String[] args) {
        // Create tree: 1->2->4,5 and 1->3
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        System.out.print("Preorder traversal: ");
        preOrder(root);
        System.out.println();
    }
}