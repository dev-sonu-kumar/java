/*
 * PROBLEM STATEMENT:
 * You are given a pointer to the root of a binary search tree and values to be inserted into the tree.
 * Insert the values into their appropriate position in the binary search tree and return the root of the updated tree.
 * You just have to complete the function.
 * 
 * Input: Root of BST and value to insert
 * Output: Root of updated BST
 * 
 * Example:
 * Original BST: 4->2->1,3 and 4->7->6
 * Insert 5: 4->2->1,3 and 4->7->6,null and 7->5
 * 
 * Constraints: 1 ≤ N ≤ 300, 1 ≤ node.data ≤ 10^4
 */

public class _56_BinarySearchTreeInsertion {
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        // If data equals root.data, we don't insert (no duplicates)
        
        return root;
    }
    
    // Helper method for inorder traversal to verify BST
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
    
    public static void main(String[] args) {
        // Create initial BST: 4->2->1,3 and 4->7->6
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        
        System.out.print("Original BST (inorder): ");
        inOrder(root);
        System.out.println();
        
        // Insert 5
        root = insert(root, 5);
        System.out.print("After inserting 5: ");
        inOrder(root);
        System.out.println();
        
        // Insert 8
        root = insert(root, 8);
        System.out.print("After inserting 8: ");
        inOrder(root);
        System.out.println();
    }
}