/*
 * PROBLEM STATEMENT:
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * 
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * 
 * Example 2:
 * Input: nums = [1,3]
 * Output: [3,1]
 * 
 * Constraints: 1 ≤ nums.length ≤ 10^4, -10^4 ≤ nums[i] ≤ 10^4
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

public class _37_ConvertSortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
    
    private static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        
        return root;
    }
    
    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = sortedArrayToBST(nums1);
        
        System.out.print("BST from [-10,-3,0,5,9]: ");
        inorderTraversal(root1);
        System.out.println();
        
        int[] nums2 = {1, 3};
        TreeNode root2 = sortedArrayToBST(nums2);
        
        System.out.print("BST from [1,3]: ");
        inorderTraversal(root2);
        System.out.println();
    }
}