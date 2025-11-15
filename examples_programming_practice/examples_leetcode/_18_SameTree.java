/*
 * PROBLEM STATEMENT:
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * 
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * 
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * 
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * 
 * Constraints: The number of nodes in both trees is in the range [0, 100], -10^4 ≤ Node.val ≤ 10^4
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

public class _18_SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }
        
        // One is null, other is not
        if (p == null || q == null) {
            return false;
        }
        
        // Values are different
        if (p.val != q.val) {
            return false;
        }
        
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public static void main(String[] args) {
        // Create tree p: [1,2,3]
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        
        // Create tree q: [1,2,3]
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        
        System.out.println("Trees are same: " + isSameTree(p, q));
        
        // Create different tree
        TreeNode r = new TreeNode(1);
        r.right = new TreeNode(2);
        
        System.out.println("Trees p and r are same: " + isSameTree(p, r));
    }
}