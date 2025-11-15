/*
 * PROBLEM STATEMENT:
 * A space explorer's ship crashed on Mars! They send a series of SOS messages to Earth for help.
 * Letters in some of the SOS messages are altered by cosmic radiation during transmission.
 * Given the signal received by Earth as a string, s, determine how many letters of the SOS message have been changed by radiation.
 * 
 * Example:
 * Input: s = "SOSSPSSQSSOR"
 * Output: 3
 * Explanation: Expected: SOSSOSSOSSOS, Received: SOSSPSSQSSOR, 3 letters changed.
 * 
 * Constraints: 1 ≤ |s| ≤ 99, |s| % 3 = 0, s will contain only uppercase English letters.
 */

public class _23_MarsExploration {
    public static int marsExploration(String s) {
        int alterations = 0;
        String expected = "SOS";
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != expected.charAt(i % 3)) {
                alterations++;
            }
        }
        
        return alterations;
    }
    
    public static void main(String[] args) {
        System.out.println("Alterations in 'SOSSPSSQSSOR': " + marsExploration("SOSSPSSQSSOR"));
        System.out.println("Alterations in 'SOSSOS': " + marsExploration("SOSSOS"));
    }
}