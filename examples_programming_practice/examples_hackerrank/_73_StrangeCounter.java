/*
 * PROBLEM STATEMENT:
 * There is a strange counter. At the first second, it displays the number 3. Each second, the number displayed by decrements by 1 until it reaches 1.
 * In next second, the timer resets to 2 * the initial number for the prior cycle and continues counting down.
 * Find the value displayed by the counter at time t.
 * 
 * Example:
 * Time : 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 ...
 * Value: 3 2 1 6 5 4 3 2 1 12 11 10  9  8  7  6  5  4  3  2  1 ...
 * 
 * Input: t = 17
 * Output: 5
 * 
 * Constraints: 1 ≤ t ≤ 10^12
 */

public class _73_StrangeCounter {
    public static long strangeCounter(long t) {
        long cycleStart = 1;
        long cycleLength = 3;
        
        // Find which cycle t belongs to
        while (t >= cycleStart + cycleLength) {
            cycleStart += cycleLength;
            cycleLength *= 2;
        }
        
        // Calculate position within the cycle
        long positionInCycle = t - cycleStart;
        return cycleLength - positionInCycle;
    }
    
    public static void main(String[] args) {
        System.out.println("Counter value at t=17: " + strangeCounter(17));
        System.out.println("Counter value at t=4: " + strangeCounter(4));
        System.out.println("Counter value at t=1: " + strangeCounter(1));
    }
}