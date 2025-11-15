/*
 * PROBLEM STATEMENT:
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * 
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * 
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * 
 * Constraints: The number of nodes in the tree is in the range [1, 1000], -100 ≤ Node.val ≤ 100
 */

public class _19_SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    
    private static boolean isMirror(TreeNode left, TreeNode right) {
        // Both nodes are null
        if (left == null && right == null) {
            return true;
        }
        
        // One is null, other is not
        if (left == null || right == null) {
            return false;
        }
        
        // Values are different
        if (left.val != right.val) {
            return false;
        }
        
        // Check if left subtree of left is mirror of right subtree of right
        // and right subtree of left is mirror of left subtree of right
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
    
    public static void main(String[] args) {
        // Create symmetric tree: [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        
        System.out.println("Tree is symmetric: " + isSymmetric(root));
        
        // Create asymmetric tree: [1,2,2,null,3,null,3]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        
        System.out.println("Tree2 is symmetric: " + isSymmetric(root2));
    }
}