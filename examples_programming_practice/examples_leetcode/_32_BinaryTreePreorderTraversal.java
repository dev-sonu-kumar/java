/*
 * PROBLEM STATEMENT:
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * 
 * Example 2:
 * Input: root = []
 * Output: []
 * 
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 * 
 * Constraints: The number of nodes in the tree is in the range [0, 100], -100 ≤ Node.val ≤ 100
 */

import java.util.*;

public class _32_BinaryTreePreorderTraversal {
    // Recursive solution
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }
    
    private static void preorderHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preorderHelper(node.left, result);
            preorderHelper(node.right, result);
        }
    }
    
    // Iterative solution
    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Create tree: [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        System.out.println("Preorder traversal (recursive): " + preorderTraversal(root));
        System.out.println("Preorder traversal (iterative): " + preorderTraversalIterative(root));
    }
}