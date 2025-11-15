/*
 * PROBLEM STATEMENT:
 * Two cats and a mouse are at various positions on a line. You will be given their starting positions.
 * Your task is to determine which cat will reach the mouse first, assuming the mouse does not move and the cats travel at the same speed.
 * If the cats arrive at the same time, the mouse will be able to escape and you should output "Mouse C".
 * 
 * Example:
 * Input: x = 1, y = 2, z = 3
 * Output: Cat B
 * Explanation: Cat A is at position 1, Cat B at position 2, Mouse at position 3. Cat B is closer.
 * 
 * Constraints: 1 ≤ x, y, z ≤ 100
 */

public class _98_CatsAndAMouse {
    public static String catAndMouse(int x, int y, int z) {
        int distanceA = Math.abs(z - x);
        int distanceB = Math.abs(z - y);
        
        if (distanceA < distanceB) {
            return "Cat A";
        } else if (distanceB < distanceA) {
            return "Cat B";
        } else {
            return "Mouse C";
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Winner (x=1, y=2, z=3): " + catAndMouse(1, 2, 3));
        System.out.println("Winner (x=1, y=3, z=2): " + catAndMouse(1, 3, 2));
    }
}