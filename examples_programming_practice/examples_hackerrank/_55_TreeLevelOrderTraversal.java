/*
 * PROBLEM STATEMENT:
 * Given a pointer to the root of a binary tree, you need to print the level order traversal of this tree.
 * In level-order traversal, nodes are visited level by level from left to right.
 * 
 * Input: A binary tree
 * Output: Level order traversal of the tree
 * 
 * Example:
 * Tree:     1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Output: 1 2 3 4 5
 * 
 * Constraints: 1 ≤ Nodes in the tree ≤ 500
 */

import java.util.*;

public class _55_TreeLevelOrderTraversal {
    public static void levelOrder(Node root) {
        if (root == null) return;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }
    
    public static void main(String[] args) {
        // Create tree: 1->2->4,5 and 1->3
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        System.out.print("Level order traversal: ");
        levelOrder(root);
        System.out.println();
    }
}