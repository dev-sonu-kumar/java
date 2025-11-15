/*
 * PROBLEM STATEMENT:
 * Louise joined a social networking site to stay in touch with her friends. The signup page required her to input a name and a password.
 * However, the password must be strong. The website considers a password to be strong if it satisfies the following criteria:
 * - Its length is at least 6.
 * - It contains at least one digit.
 * - It contains at least one lowercase English character.
 * - It contains at least one uppercase English character.
 * - It contains at least one special character. The special characters are: !@#$%^&*()-+
 * 
 * She typed a random string of length n in the password field but wasn't sure if it was strong.
 * Given the string she typed, can you find the minimum number of characters she must add to make it strong?
 * 
 * Example:
 * Input: password = "Ab1"
 * Output: 3
 * 
 * Constraints: 1 ≤ n ≤ 100
 */

public class _22_StrongPassword {
    public static int minimumNumber(int n, String password) {
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        String specialChars = "!@#$%^&*()-+";
        
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (specialChars.indexOf(c) != -1) hasSpecial = true;
        }
        
        int missing = 0;
        if (!hasLower) missing++;
        if (!hasUpper) missing++;
        if (!hasDigit) missing++;
        if (!hasSpecial) missing++;
        
        return Math.max(missing, 6 - n);
    }
    
    public static void main(String[] args) {
        System.out.println("Characters to add to 'Ab1': " + minimumNumber(3, "Ab1"));
        System.out.println("Characters to add to '#HackerRank': " + minimumNumber(11, "#HackerRank"));
    }
}