/*
 * PROBLEM STATEMENT:
 * A jail has a number of prisoners and a number of treats to pass out to them. Their jailer decides the fairest way to divide the treats is to seat the prisoners around a circular table in sequentially numbered chairs.
 * A chair number will be drawn from a hat. Beginning with the prisoner in that chair, one candy will be passed to each prisoner sequentially around the table until all have been distributed.
 * 
 * The jailer is playing a little joke, though. The last piece of candy looks like all the others, but it tastes awful. Determine the chair number occupied by the prisoner who will receive that candy.
 * 
 * Example:
 * Input: n = 5, m = 2, s = 1
 * Output: 2
 * Explanation: 5 prisoners, 2 candies, start at chair 1. Chairs 1,2 get candy. Chair 2 gets the last (awful) candy.
 * 
 * Constraints: 1 ≤ n ≤ 10^9, 1 ≤ m ≤ 10^9, 1 ≤ s ≤ n
 */

public class _91_SaveThePrisoner {
    public static int saveThePrisoner(int n, int m, int s) {
        // Calculate the position of the last candy
        int lastPosition = (s + m - 2) % n + 1;
        return lastPosition;
    }
    
    public static void main(String[] args) {
        System.out.println("Last candy position (n=5, m=2, s=1): " + saveThePrisoner(5, 2, 1));
        System.out.println("Last candy position (n=5, m=2, s=2): " + saveThePrisoner(5, 2, 2));
    }
}