/*
 * PROBLEM STATEMENT:
 * Your local library needs your help! Given the expected and actual return dates for a library book, create a program that calculates the fine (if any).
 * The fee structure is as follows:
 * 1. If the book is returned on or before the expected return date, no fine will be charged (i.e.: fine = 0).
 * 2. If the book is returned after the expected return day but still within the same calendar month and year as the expected return date, fine = 15 Hackos × (the number of days late).
 * 3. If the book is returned after the expected return month but still within the same calendar year as the expected return date, fine = 500 Hackos × (the number of months late).
 * 4. If the book is returned after the calendar year in which it was expected, there is a fixed fine of 10000 Hackos.
 * 
 * Example:
 * Input: d1=9, m1=6, y1=2015, d2=6, m2=6, y2=2015
 * Output: 45
 * Explanation: 3 days late in same month: 15 * 3 = 45.
 * 
 * Constraints: 1 ≤ D ≤ 31, 1 ≤ M ≤ 12, 1 ≤ Y ≤ 3000
 */

public class _63_LibraryFine {
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // d1, m1, y1 = actual return date
        // d2, m2, y2 = expected return date
        
        if (y1 > y2) {
            return 10000; // Returned after expected year
        } else if (y1 < y2) {
            return 0; // Returned before expected year
        } else { // Same year
            if (m1 > m2) {
                return 500 * (m1 - m2); // Returned after expected month
            } else if (m1 < m2) {
                return 0; // Returned before expected month
            } else { // Same month
                if (d1 > d2) {
                    return 15 * (d1 - d2); // Returned after expected day
                } else {
                    return 0; // Returned on or before expected day
                }
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Fine for returning 9/6/2015 when due 6/6/2015: " + libraryFine(9, 6, 2015, 6, 6, 2015));
        System.out.println("Fine for returning 6/6/2015 when due 6/6/2015: " + libraryFine(6, 6, 2015, 6, 6, 2015));
        System.out.println("Fine for returning 1/1/2016 when due 1/1/2015: " + libraryFine(1, 1, 2016, 1, 1, 2015));
    }
}