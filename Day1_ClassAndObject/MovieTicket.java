public class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;

    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = null;
        this.price = 0.0;
    }

    public void bookTicket(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully for '" + movieName + "'.");
    }

    public void displayTicketDetails() {
        if (seatNumber != null && price > 0) {
            System.out.println("----- Ticket Details -----");
            System.out.println("Movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("Ticket has not been booked yet.");
        }
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Interstellar");
        ticket.bookTicket("A10", 250.0);
        ticket.displayTicketDetails();
    }
}

