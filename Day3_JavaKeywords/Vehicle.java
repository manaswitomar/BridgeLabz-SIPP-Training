public class Vehicle {
    static int registration_fee;
    String owner_name;
    String vehicle_type;
    int registration_no;


    Vehicle(int registration_fee, String owner_name, String vehicle_type, int registration_no,int product_id){
        if (this instanceof Vehicle){
            this.registration_fee=registration_fee;
            this.owner_name=owner_name;
            this.vehicle_type=vehicle_type;
            this.registration_no=registration_no;


        }

    }

    private static void updateRegistrationFee(){
        System.out.println(registration_fee);
        }


    public static void main(String[] args) {
        Vehicle vehicle=new Vehicle(250, "Abhay", "four-wheeler", 2345, 134);
        vehicle.updateRegistrationFee();
    }
}


