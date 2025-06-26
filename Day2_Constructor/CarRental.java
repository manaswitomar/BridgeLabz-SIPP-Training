public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;

    CarRental(String customerName,String carModel, int rentalDays){
        this.customerName=customerName;
        this.carModel=carModel;
        this.rentalDays=rentalDays;
    }

    public void displayDetails(){
        System.out.println(customerName);
        System.out.println(carModel);
        System.out.println(rentalDays);

    }

    public void totalCost(){
        int totalcost= rentalDays*2000;
        System.out.println(totalcost);
    }

    public static void main(String[] args) {
        CarRental cars=new CarRental("John", "Baleno", 2);
        cars.displayDetails();
        cars.totalCost();
    }
    
}
