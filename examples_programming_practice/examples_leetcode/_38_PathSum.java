/*
 * PROBLEM STATEMENT:
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals targetSum.
 * 
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * 
 * Example 2:
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * 
 * Constraints: The number of nodes in the tree is in the range [0, 5000], -1000 ≤ Node.val ≤ 1000
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

public class _38_PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        // If it's a leaf node, check if remaining sum equals node value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        
        // Recursively check left and right subtrees with updated target
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
    
    public static void main(String[] args) {
        // Create tree: [5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        
        System.out.println("Has path sum 22: " + hasPathSum(root, 22));
        System.out.println("Has path sum 26: " + hasPathSum(root, 26));
        
        // Simple tree: [1,2,3]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        
        System.out.println("Tree [1,2,3] has path sum 5: " + hasPathSum(root2, 5));
        System.out.println("Tree [1,2,3] has path sum 4: " + hasPathSum(root2, 4));
    }
}