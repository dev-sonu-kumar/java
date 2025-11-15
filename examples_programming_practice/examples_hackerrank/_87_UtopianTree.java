/*
 * PROBLEM STATEMENT:
 * The Utopian Tree goes through 2 cycles of growth every year. Each spring, it doubles in height. Each summer, its height increases by 1 meter.
 * A Utopian Tree sapling with a height of 1 meter is planted at the onset of spring. How tall will the tree be after n growth cycles?
 * 
 * Example:
 * Input: n = 4
 * Output: 7
 * Explanation: Initial=1, Spring(1)=2, Summer(1)=3, Spring(2)=6, Summer(2)=7
 * 
 * Constraints: 1 ≤ T ≤ 10, 0 ≤ n ≤ 60
 */

public class _87_UtopianTree {
    public static int utopianTree(int n) {
        int height = 1;
        
        for (int cycle = 1; cycle <= n; cycle++) {
            if (cycle % 2 == 1) {
                // Spring: double the height
                height *= 2;
            } else {
                // Summer: increase by 1
                height += 1;
            }
        }
        
        return height;
    }
    
    public static void main(String[] args) {
        System.out.println("Height after 0 cycles: " + utopianTree(0));
        System.out.println("Height after 1 cycle: " + utopianTree(1));
        System.out.println("Height after 4 cycles: " + utopianTree(4));
        System.out.println("Height after 5 cycles: " + utopianTree(5));
    }
}