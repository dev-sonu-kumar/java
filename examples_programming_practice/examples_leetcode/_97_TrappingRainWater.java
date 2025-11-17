/*
 * PROBLEM STATEMENT:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * 
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * 
 * Constraints: n == height.length, 1 ≤ n ≤ 2 * 10^4, 0 ≤ height[i] ≤ 3 * 10^4
 */

public class _97_TrappingRainWater {
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        
        return water;
    }
    
    public static void main(String[] args) {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water: " + trap(height1));
        
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Trapped water: " + trap(height2));
    }
}