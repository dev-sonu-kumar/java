/*
 * PROBLEM STATEMENT:
 * A Discrete Mathematics professor has a class of students. Frustrated with their lack of discipline, the professor decides to cancel class if fewer than a threshold number of students are present when class starts.
 * Arrival times go from on time (arrivalTime ≤ 0) to arrived late (arrivalTime > 0).
 * 
 * Given the arrival time of each student and a threshold number of attendees, determine if the class is cancelled.
 * 
 * Example:
 * Input: k = 3, a = [-2, -1, 0, 1, 2]
 * Output: NO
 * Explanation: 3 students arrived on time or early, so class is not cancelled.
 * 
 * Constraints: 1 ≤ n ≤ 1000, 1 ≤ k ≤ n, -100 ≤ a[i] ≤ 100
 */

public class _88_AngryProfessor {
    public static String angryProfessor(int k, int[] a) {
        int onTimeCount = 0;
        
        for (int arrivalTime : a) {
            if (arrivalTime <= 0) {
                onTimeCount++;
            }
        }
        
        return onTimeCount >= k ? "NO" : "YES";
    }
    
    public static void main(String[] args) {
        int[] a1 = {-2, -1, 0, 1, 2};
        System.out.println("Class cancelled (k=3): " + angryProfessor(3, a1));
        
        int[] a2 = {0, -1, 2, 1};
        System.out.println("Class cancelled (k=2): " + angryProfessor(2, a2));
    }
}