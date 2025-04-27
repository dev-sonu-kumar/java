package OOPS.Example_4_This;

public class BookDemo {
    public static void main(String[] args) {
        Book b1 = new Book(); // Uses constructor 1
        Book b2 = new Book("Java Basics", 300); // Uses constructor 2

        b1.printBook(); // Title: Unknown, Pages: 0
        b2.printBook(); // Title: Java Basics, Pages: 300
    }
}

// this.var Refers to current object’s variable
// this() Calls another constructor in the same class