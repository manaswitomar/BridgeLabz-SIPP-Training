public class Book {
    String title;
    String author;
    double price;
    
    public Book() {
        title = "Unknown Title";
        author = "Unknown Author";
        price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.displayDetails();

        System.out.println();
        Book book2 = new Book("room No. 102", "Chetan Bhagat", 399.0);
        book2.displayDetails();
    }
}
