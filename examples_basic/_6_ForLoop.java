package examples_basic;

public class _6_ForLoop {
    public static void main(String[] args) {
        // print 1 to 10
        System.out.println("printing 1 to 10");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        // print in reverse way 10 to 1
        System.out.println("reversing 10 to 1");
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
