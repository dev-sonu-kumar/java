/*
 * PROBLEM STATEMENT:
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * A valid BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 * 
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * 
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * 
 * Constraints: The number of nodes in the tree is in the range [1, 10^4], -2^31 ≤ Node.val ≤ 2^31 - 1
 */

public class _35_ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean validate(TreeNode node, long minVal, long maxVal) {
        if (node == null) {
            return true;
        }
        
        if (node.val <= minVal || node.val >= maxVal) {
            return false;
        }
        
        return validate(node.left, minVal, node.val) && 
               validate(node.right, node.val, maxVal);
    }
    
    // Alternative approach using inorder traversal
    public static boolean isValidBSTInorder(TreeNode root) {
        return inorderCheck(root, new TreeNode[]{null});
    }
    
    private static boolean inorderCheck(TreeNode node, TreeNode[] prev) {
        if (node == null) return true;
        
        if (!inorderCheck(node.left, prev)) return false;
        
        if (prev[0] != null && prev[0].val >= node.val) return false;
        prev[0] = node;
        
        return inorderCheck(node.right, prev);
    }
    
    public static void main(String[] args) {
        // Create valid BST: [2,1,3]
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        
        System.out.println("Tree [2,1,3] is valid BST: " + isValidBST(root1));
        
        // Create invalid BST: [5,1,4,null,null,3,6]
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        
        System.out.println("Tree [5,1,4,null,null,3,6] is valid BST: " + isValidBST(root2));
    }
}