/*
 * PROBLEM STATEMENT:
 * HackerLand University has the following grading policy:
 * - Every student receives a grade in the inclusive range from 0 to 100.
 * - Any grade less than 40 is a failing grade.
 * - If the difference between the grade and the next multiple of 5 is less than 3, round the grade up to the next multiple of 5.
 * - If the grade is less than 38, no rounding occurs as the result will still be a failing grade.
 * 
 * Example:
 * Input: [73, 67, 38, 33]
 * Output: [75, 67, 40, 33]
 * 
 * Constraints: 1 ≤ n ≤ 60, 0 ≤ grades[i] ≤ 100
 */

import java.util.Arrays;

public class _10_GradingStudents {
    public static int[] gradingStudents(int[] grades) {
        int[] result = new int[grades.length];
        
        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];
            
            if (grade < 38) {
                result[i] = grade; // No rounding for failing grades
            } else {
                int nextMultipleOf5 = ((grade / 5) + 1) * 5;
                if (nextMultipleOf5 - grade < 3) {
                    result[i] = nextMultipleOf5;
                } else {
                    result[i] = grade;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] grades = {73, 67, 38, 33};
        System.out.println("Original: " + Arrays.toString(grades));
        System.out.println("Rounded: " + Arrays.toString(gradingStudents(grades)));
    }
}