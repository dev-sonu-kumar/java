package examples_basic;

public class _8_DoWhileLoop {
    public static void main(String[] args) {
        // print squre of 1 to 10
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);

        System.out.println("...........");

        // print 10 to 1

        int j = 10;
        do {
            System.out.println(j);
            j--;
        } while (j >= 1);

    }
}
