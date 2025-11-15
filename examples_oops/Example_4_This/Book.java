package examples_oops.Example_4_This;

public class Book {
    String title;
    int pages;

    // Using this() to call another constructor

    // Constructor 1
    Book() {
        this("Unknown", 0); // Calling constructor 2
    }

    // Constructor 2
    Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    void printBook() {
        System.out.println("Title: " + title + ", Pages: " + pages);
    }
}
