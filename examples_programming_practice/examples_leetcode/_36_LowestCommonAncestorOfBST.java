/*
 * PROBLEM STATEMENT:
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * 
 * Example 1:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * 
 * Example 2:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * 
 * Constraints: The number of nodes in the tree is in the range [2, 10^5]
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _36_LowestCommonAncestorOfBST {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        // If both p and q are smaller than root, LCA is in left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        // If both p and q are greater than root, LCA is in right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        // If p and q are on different sides, root is LCA
        return root;
    }
    
    // Iterative approach
    public static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        // Create BST: [6,2,8,0,4,7,9,null,null,3,5]
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        
        TreeNode p = root.left; // Node 2
        TreeNode q = root.right; // Node 8
        
        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 2 and 8: " + lca.val);
        
        TreeNode p2 = root.left; // Node 2
        TreeNode q2 = root.left.right; // Node 4
        
        TreeNode lca2 = lowestCommonAncestorIterative(root, p2, q2);
        System.out.println("LCA of 2 and 4: " + lca2.val);
    }
}