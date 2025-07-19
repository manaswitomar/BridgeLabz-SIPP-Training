import java.util.*;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
class TicketReservationSystem {
    private Ticket head = null;public class TicketReservationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();
        int choice;

        do {
            System.out.println("\n=== Online Ticket Reservation Menu ===");
            System.out.println("1. Book New Ticket");
            System.out.println("2. Cancel Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket (Customer or Movie)");
            System.out.println("5. Show Total Booked Tickets");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int id;
            String name, movie, seat, time;

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Customer Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    seat = sc.nextLine();
                    System.out.print("Enter Booking Time (e.g. 6:30 PM): ");
                    time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    id = sc.nextInt();
                    system.removeTicket(id);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer or Movie Name to search: ");
                    sc.nextLine();
                    String keyword = sc.nextLine();
                    system.search(keyword);
                    break;
                case 5:
                    System.out.println("Total Booked Tickets: " + system.totalTickets());
                    break;
                case 0:
                    System.out.println("Thank you for using the reservation system.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
        sc.close();
    }
}
    public void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, customer, movie, seat, time);

        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }

        System.out.println("Ticket booked successfully!");
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets found.");
            return;
        }

        Ticket current = head, prev = null;

        if (head.ticketId == ticketId) {
            if (head.next == head) {
                head = null;
            } else {
                Ticket last = head;
                while (last.next != head) last = last.next;
                head = head.next;
                last.next = head;
            }
            System.out.println("Ticket removed successfully.");
            return;
        }

        do {
            prev = current;
            current = current.next;
            if (current.ticketId == ticketId) {
                prev.next = current.next;
                System.out.println("Ticket removed successfully.");
                return;
            }
        } while (current != head);

        System.out.println("Ticket ID not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        System.out.println("\n--- Booked Tickets ---");
        do {
            printTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    private void printTicket(Ticket t) {
        System.out.println("ID: " + t.ticketId + ", Name: " + t.customerName + ", Movie: " + t.movieName
                + ", Seat: " + t.seatNumber + ", Time: " + t.bookingTime);
    }

    public void search(String keyword) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found with given Customer or Movie name.");
    }

    public int totalTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}
