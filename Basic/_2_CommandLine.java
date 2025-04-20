package Basic;

public class _2_CommandLine {
    public static void main(String[] args) {

        // print all command-line argument

        for (int i = 0; i < args.length; i++) {
            System.out.println("args" + i + " " + args[i]);
        }
    }
}
