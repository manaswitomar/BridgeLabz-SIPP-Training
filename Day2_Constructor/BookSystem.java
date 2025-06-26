public class BookSystem {
    String title;
    String author;
    double price;
    int availability;

    public BookSystem(){
        this.title="";
        this.author="";
        this.price=0.0;
        this.availability=0;
    }

    public BookSystem(String title,String author, double price, int availability){
        this.title=title;
        this.author=author;
        this.price=price;
        this.availability=availability;

    }

    public void displayborrow(){
        System.out.println("Title:"+title);
        System.out.println("Auhor:"+author);
        System.out.println("Price:"+price);
        System.out.println("Availability:"+availability);

    }
    public static void main(String[] args) {
        BookSystem book1=new BookSystem("The Half Girlfriend", "Chetan Bhagat", 424, 3);
        book1.displayborrow();

        
    }
}
