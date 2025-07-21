import java.util.*;

class CabInvoice {
    double distance;
    int time;
    String type;
    static final int COST_PER_KM = 10;
    static final int COST_PER_MIN = 1;

    CabInvoice(double distance, int time) {
        this.distance = distance;
        this.time = time;

    }

    public double calculateFare() {
        double fare = 0;
        fare = (distance * COST_PER_KM) + (time * COST_PER_MIN);
        return fare;
    }

   
    public double calculateFares(List<Integer> rides) {
        double total=0.0;
        double fare = (distance * COST_PER_KM) + (time * COST_PER_MIN);
        total=total+fare;
        return total;
    }
}
class Invoice extends CabInvoice{
    
    Invoice(double distance, int time) {
        super(distance, time);
    }
    public void enhancedInvoice(int numberOfRides , double totalFare  ){
        System.out.println("total number of rides :"+ numberOfRides );
        System.out.println("Total fare :"+totalFare);
        double avg=totalFare/numberOfRides;
        System.out.println("Average fare per ride :"+ avg);
    }
    public double premiumRides(double distance,int time){
        if(type.equals("NORMAL")){
            double fare=(distance*10.0)+(time*1);
            if(fare<5){
                return fare;
            }
            return 5;
        }
        if(type.equals("PREMIUM")){
            double fare=(distance*15.0)+(time*2);
            if(fare<20){
                return fare;
            }
            return 20;
        }
        return time;
    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CabInvoice cabInvoice = new CabInvoice(10, 4);
        System.out.println("Total fare for the ride is: " + cabInvoice.calculateFare());
        System.out.println("enter the type");


        List<Integer> rides = new ArrayList<>();
        System.out.println("Enter number of rides:");
        int numberOfRides = sc.nextInt();
        for (int i = 0; i < numberOfRides; i++) {

            System.out.println("Enter distance and time for ride " + (i + 1) + ":");
            int distance = sc.nextInt();
            int time = sc.nextInt();
            String type=sc.next();
            CabInvoice ride = new CabInvoice(distance, time);
            rides.add((int) ride.calculateFares(rides));
        }
        System.out.println("Total fare for all rides is: " +cabInvoice.calculateFares(rides) );

    }

}