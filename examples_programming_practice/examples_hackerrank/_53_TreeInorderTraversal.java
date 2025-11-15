/*
 * PROBLEM STATEMENT:
 * Complete the inOrder function in the editor below.
 * It received 1 parameter: a pointer to the root of a binary tree.
 * It must print the values in the tree's inorder traversal as a single line of space-separated values.
 * 
 * Input: A binary tree
 * Output: Inorder traversal of the tree
 * 
 * Example:
 * Tree:     1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Output: 4 2 5 1 3
 * 
 * Constraints: 1 ≤ Nodes in the tree ≤ 500
 */

public class _53_TreeInorderTraversal {
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
    
    public static void main(String[] args) {
        // Create tree: 1->2->4,5 and 1->3
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        System.out.print("Inorder traversal: ");
        inOrder(root);
        System.out.println();
    }
}