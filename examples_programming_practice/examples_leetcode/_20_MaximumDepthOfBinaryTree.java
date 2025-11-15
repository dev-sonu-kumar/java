/*
 * PROBLEM STATEMENT:
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * 
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 * 
 * Constraints: The number of nodes in the tree is in the range [0, 10^4], -100 ≤ Node.val ≤ 100
 */

public class _20_MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    public static void main(String[] args) {
        // Create tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        
        System.out.println("Maximum depth: " + maxDepth(root));
        
        // Create tree: [1,null,2]
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        
        System.out.println("Maximum depth of tree2: " + maxDepth(root2));
    }
}