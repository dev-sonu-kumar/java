/*
 * PROBLEM STATEMENT:
 * Marie invented a Time Machine and wants to test it by time-traveling to visit Russia on the Day of the Programmer (the 256th day of the year) during a year in the inclusive range from 1700 to 2700.
 * 
 * From 1700 to 1917, Russia's official calendar was the Julian calendar; since 1919 they used the Gregorian calendar system.
 * The transition from the Julian to Gregorian calendar system occurred in 1918, when the next day after January 31st was February 14th.
 * This means that in 1918, February 14th was the 32nd day of the year in Russia.
 * 
 * In both calendar systems, February is the only month with a variable amount of days; it has 29 days during a leap year, and 28 days during all other years.
 * In the Julian calendar, leap years are divisible by 4; in the Gregorian calendar, leap years are either:
 * - Divisible by 400.
 * - Divisible by 4 and not divisible by 100.
 * 
 * Given a year, find the date of the 256th day of that year according to the official Russian calendar during that year.
 * Then print it in the format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is y.
 * 
 * Example:
 * Input: year = 2017
 * Output: 13.09.2017
 * 
 * Constraints: 1700 ≤ year ≤ 2700
 */

public class _18_DayOfTheProgrammer {
    public static String dayOfProgrammer(int year) {
        if (year == 1918) {
            // Transition year: Feb 14 was day 32, so 256 - 215 = 41 days after July 31
            return "26.09.1918";
        }
        
        boolean isLeapYear;
        if (year < 1918) {
            // Julian calendar: divisible by 4
            isLeapYear = year % 4 == 0;
        } else {
            // Gregorian calendar: divisible by 400 OR (divisible by 4 AND not by 100)
            isLeapYear = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        }
        
        // Days in months Jan-Aug
        int daysInJanToAug = 31 + (isLeapYear ? 29 : 28) + 31 + 30 + 31 + 30 + 31 + 31;
        int dayInSeptember = 256 - daysInJanToAug;
        
        return String.format("%02d.09.%d", dayInSeptember, year);
    }
    
    public static void main(String[] args) {
        System.out.println("Day of Programmer 2017: " + dayOfProgrammer(2017));
        System.out.println("Day of Programmer 2016: " + dayOfProgrammer(2016));
        System.out.println("Day of Programmer 1918: " + dayOfProgrammer(1918));
    }
}