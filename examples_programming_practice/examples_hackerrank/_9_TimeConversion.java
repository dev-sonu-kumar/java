/*
 * PROBLEM STATEMENT:
 * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
 * 
 * Note: 
 * - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 * 
 * Example:
 * Input: s = "07:05:45PM"
 * Output: "19:05:45"
 * 
 * Input: s = "12:01:00AM"
 * Output: "00:01:00"
 * 
 * Constraints: All input times are valid
 */

public class _9_TimeConversion {
    public static String timeConversion(String s) {
        String period = s.substring(s.length() - 2);
        String time = s.substring(0, s.length() - 2);
        String[] parts = time.split(":");
        
        int hour = Integer.parseInt(parts[0]);
        String minute = parts[1];
        String second = parts[2];
        
        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else { // PM
            if (hour != 12) {
                hour += 12;
            }
        }
        
        return String.format("%02d:%s:%s", hour, minute, second);
    }
    
    public static void main(String[] args) {
        System.out.println("07:05:45PM -> " + timeConversion("07:05:45PM"));
        System.out.println("12:01:00AM -> " + timeConversion("12:01:00AM"));
        System.out.println("12:01:00PM -> " + timeConversion("12:01:00PM"));
    }
}