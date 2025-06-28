import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("The Hobbit", "J.R.R. Tolkien");
        Book b3 = new Book("The Alchemist", "Paulo Coelho");

        Library l1 = new Library("City Library");
        Library l2 = new Library("School Library");

        l1.addBook(b1);
        l1.addBook(b2);

        l2.addBook(b2); 
        l2.addBook(b3);

        l1.showBooks();
        System.out.println();
        l2.showBooks();
    }
}

class Book {
    String title;
    String author;
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return title + " by " + author;
    }
}

class Library {
    String name;
    List<Book> books; 

    Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void showBooks() {
        System.out.println("Books in " + name + ":");
        for (Book b : books) {
            System.out.println("- " + b);
        }
    }
}

