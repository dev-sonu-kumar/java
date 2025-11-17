/*
 * PROBLEM STATEMENT:
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 * 
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * 
 * Example 2:
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * 
 * Constraints: The number of nodes in the tree is in the range [0, 5000], -10^4 ≤ Node.val ≤ 10^4
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class _40_BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    
    private static int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // Left subtree is not balanced
        
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // Right subtree is not balanced
        
        // Check if current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static void main(String[] args) {
        // Create balanced tree: [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        
        System.out.println("Tree [3,9,20,null,null,15,7] is balanced: " + isBalanced(root1));
        
        // Create unbalanced tree: [1,2,2,3,3,null,null,4,4]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        
        System.out.println("Unbalanced tree is balanced: " + isBalanced(root2));
        
        // Single node
        TreeNode root3 = new TreeNode(1);
        System.out.println("Single node is balanced: " + isBalanced(root3));
    }
}