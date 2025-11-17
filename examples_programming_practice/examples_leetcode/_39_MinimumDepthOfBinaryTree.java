/*
 * PROBLEM STATEMENT:
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * 
 * Example 2:
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 * 
 * Constraints: The number of nodes in the tree is in the range [0, 10^5], -1000 ≤ Node.val ≤ 1000
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

public class _39_MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // If one subtree is null, return depth of other subtree + 1
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        
        // Both subtrees exist, return minimum depth + 1
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    
    public static void main(String[] args) {
        // Create tree: [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        
        System.out.println("Minimum depth of tree [3,9,20,null,null,15,7]: " + minDepth(root1));
        
        // Create skewed tree: [2,null,3,null,4,null,5,null,6]
        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(6);
        
        System.out.println("Minimum depth of skewed tree: " + minDepth(root2));
        
        // Single node
        TreeNode root3 = new TreeNode(1);
        System.out.println("Minimum depth of single node: " + minDepth(root3));
    }
}