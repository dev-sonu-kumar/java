package Basic;

public class _9_IfElse {
    public static void main(String[] args) {

        // check number is even or odd

        int number = 4;
        if (number == 0) {
            System.out.println("It's zero.");
        } else if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
