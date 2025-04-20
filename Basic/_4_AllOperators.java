package Basic;

public class _4_AllOperators {
    public static void main(String[] args) {

        System.out.println("=== Arithmetic Operators ===");
        int a = 10, b = 3;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        System.out.println("\n=== Relational Operators ===");
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));
        System.out.println("a > b  : " + (a > b));
        System.out.println("a < b  : " + (a < b));
        System.out.println("a >= b : " + (a >= b));
        System.out.println("a <= b : " + (a <= b));

        System.out.println("\n=== Logical Operators ===");
        boolean x = true, y = false;
        System.out.println("x && y = " + (x && y));
        System.out.println("x || y = " + (x || y));
        System.out.println("!x = " + (!x));

        System.out.println("\n=== Assignment Operators ===");
        int c = 5;
        c += 3;
        System.out.println("c += 3 => " + c);
        c -= 2;
        System.out.println("c -= 2 => " + c);
        c *= 4;
        System.out.println("c *= 4 => " + c);
        c /= 2;
        System.out.println("c /= 2 => " + c);
        c %= 3;
        System.out.println("c %= 3 => " + c);

        System.out.println("\n=== Unary Operators ===");
        int d = 5;
        System.out.println("++d = " + (++d));
        System.out.println("d++ = " + (d++));
        System.out.println("Now d = " + d);
        System.out.println("--d = " + (--d));
        System.out.println("d-- = " + (d--));
        System.out.println("Now d = " + d);

        System.out.println("\n=== Bitwise Operators ===");
        int e = 5, f = 3;
        System.out.println("e & f = " + (e & f));
        System.out.println("e | f = " + (e | f));
        System.out.println("e ^ f = " + (e ^ f));
        System.out.println("~e = " + (~e));

        System.out.println("\n=== Shift Operators ===");
        int g = 8;
        System.out.println("g << 1 = " + (g << 1));
        System.out.println("g >> 1 = " + (g >> 1));
        System.out.println("g >>> 1 = " + (g >>> 1));

        System.out.println("\n=== Ternary Operator ===");
        int h = 10, i = 20;
        int max = (h > i) ? h : i;
        System.out.println("Max of h and i = " + max);
    }
}
