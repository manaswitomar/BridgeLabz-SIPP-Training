public class LibraryManagementSystem {
    
    static String libraryName = " ";

    private String author;
    private final int isbn;

    private String title;
    private double balance;
    public LibraryManagementSystem( String title,String author, int isbn, double balance) {
        this.title=title;
        this.author = author;
        this.isbn = isbn; 
        this.balance = balance;}


    public void displayLibraryName() {
        if ( this instanceof LibraryManagementSystem) {
            System.out.println(title);
            System.out.println("Library Name: " + libraryName);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
            System.out.println("Balance:" + balance);
        }
    }

    
    public static void main(String[] args) {
        LibraryManagementSystem book1 = new LibraryManagementSystem("Alice and Bob","Alice", 1001, 5000.0);
        LibraryManagementSystem book2 = new LibraryManagementSystem("Alice and Bob","Bob", 1002, 7500.0);

        book1.displayLibraryName();
        System.out.println();

        book2.displayLibraryName();
        System.out.println();

        
    }
}
