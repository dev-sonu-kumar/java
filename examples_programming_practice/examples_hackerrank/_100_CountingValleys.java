/*
 * PROBLEM STATEMENT:
 * An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly steps steps, for every step it was noted if it was an uphill, U, or a downhill, D step.
 * Hikes always start and end at sea level, and each step up or down represents a 1 unit change in altitude.
 * We define the following terms:
 * - A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * - A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * 
 * Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
 * 
 * Example:
 * Input: steps = 8, path = "UDDDUDUU"
 * Output: 1
 * 
 * Constraints: 2 ≤ steps ≤ 10^6, path[i] ∈ {U, D}
 */

public class _100_CountingValleys {
    public static int countingValleys(int steps, String path) {
        int altitude = 0;
        int valleys = 0;
        
        for (char step : path.toCharArray()) {
            if (step == 'U') {
                altitude++;
                // If we just reached sea level from below, we completed a valley
                if (altitude == 0) {
                    valleys++;
                }
            } else { // step == 'D'
                altitude--;
            }
        }
        
        return valleys;
    }
    
    public static void main(String[] args) {
        System.out.println("Valleys in 'UDDDUDUU': " + countingValleys(8, "UDDDUDUU"));
        System.out.println("Valleys in 'DDUUUUDD': " + countingValleys(8, "DDUUUUDD"));
    }
}