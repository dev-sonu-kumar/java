/*
 * PROBLEM STATEMENT:
 * Complete the postOrder function in the editor below.
 * It received 1 parameter: a pointer to the root of a binary tree.
 * It must print the values in the tree's postorder traversal as a single line of space-separated values.
 * 
 * Input: A binary tree
 * Output: Postorder traversal of the tree
 * 
 * Example:
 * Tree:     1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Output: 4 5 2 3 1
 * 
 * Constraints: 1 ≤ Nodes in the tree ≤ 500
 */

public class _52_TreePostorderTraversal {
    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
    
    public static void main(String[] args) {
        // Create tree: 1->2->4,5 and 1->3
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        System.out.print("Postorder traversal: ");
        postOrder(root);
        System.out.println();
    }
}