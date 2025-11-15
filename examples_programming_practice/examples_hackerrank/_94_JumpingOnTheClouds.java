/*
 * PROBLEM STATEMENT:
 * A child is playing a cloud hopping game. In this game, there are sequentially numbered clouds that can be thunderheads or cumulus clouds.
 * The child must jump from cloud to cloud until they reach the start again.
 * There is an array of clouds, c and an energy level e=100. The child starts from c[0] and uses 1 unit of energy to make a jump of size k to cloud c[(i+k)%n].
 * If the child lands on a thundercloud, c[i] = 1, they lose 2 additional units of energy. If they land on a cumulus cloud, c[i] = 0, they don't lose additional energy.
 * The game ends when the child lands back on cloud c[0].
 * 
 * Given the values of n, k, and the configuration of the clouds as an array c, determine the final value of e after the game ends.
 * 
 * Example:
 * Input: c = [0, 0, 1, 0, 0, 1, 1, 0], k = 2
 * Output: 92
 * 
 * Constraints: 2 ≤ n ≤ 25, 1 ≤ k ≤ n, 0 ≤ c[i] ≤ 1
 */

public class _94_JumpingOnTheClouds {
    public static int jumpingOnClouds(int[] c, int k) {
        int n = c.length;
        int energy = 100;
        int position = 0;
        
        do {
            position = (position + k) % n;
            energy -= 1; // Energy for jump
            
            if (c[position] == 1) {
                energy -= 2; // Additional energy for thundercloud
            }
        } while (position != 0);
        
        return energy;
    }
    
    public static void main(String[] args) {
        int[] c = {0, 0, 1, 0, 0, 1, 1, 0};
        System.out.println("Final energy: " + jumpingOnClouds(c, 2));
        
        int[] c2 = {1, 1, 1, 0, 1, 1, 0, 0, 0, 0};
        System.out.println("Final energy: " + jumpingOnClouds(c2, 3));
    }
}