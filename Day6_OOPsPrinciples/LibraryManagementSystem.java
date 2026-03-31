import java.util.ArrayList;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        ArrayList<LibraryItem> items = new ArrayList<>();

        items.add(new Book("B101", "Java Programming", "Herbert Schildt"));
        items.add(new Magazine("M202", "National Geographic", "NG Staff"));
        items.add(new DVD("D303", "Inception", "Christopher Nolan"));

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Available? " + reservableItem.checkAvailability());
                reservableItem.reserveItem("John Doe");
                System.out.println("Available after reservation? " + reservableItem.checkAvailability());
            }

            System.out.println("-----------------------------------");
        }
    }
}
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isReserved = false;
    private String borrowerName;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Encapsulation: Getters and Setters
    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public String getBorrowerName() { return borrowerName; }

    protected void setReserved(boolean reserved) { this.isReserved = reserved; }
    protected void setBorrowerName(String borrowerName) { this.borrowerName = borrowerName; }

    public boolean isReserved() { return isReserved; }

    // Abstract method
    public abstract int getLoanDuration();  // days

    // Concrete method
    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 21; // 3 weeks
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setReserved(true);
            setBorrowerName(borrowerName);
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved();
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7; // 1 week
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setReserved(true);
            setBorrowerName(borrowerName);
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved();
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14; // 2 weeks
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setReserved(true);
            setBorrowerName(borrowerName);
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved();
    }
}
