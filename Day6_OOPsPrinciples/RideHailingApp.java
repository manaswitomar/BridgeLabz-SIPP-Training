import java.util.ArrayList;

public class RideHailingApp {
    public static void main(String[] args) {
        ArrayList<Vehicle> rides = new ArrayList<>();

        Vehicle car = new Car("C001", "Amit", 15.0, "Connaught Place");
        Vehicle bike = new Bike("B001", "Raj", 8.0, "Karol Bagh");
        Vehicle auto = new Auto("A001", "Sita", 10.0, "Lajpat Nagar");

        rides.add(car);
        rides.add(bike);
        rides.add(auto);

        double[] distances = {12.5, 6.2, 8.0};

        System.out.println("---- Ride Fare Details ----");
        for (int i = 0; i < rides.size(); i++) {
            Vehicle v = rides.get(i);
            v.getVehicleDetails();

            if (v instanceof GPS) {
                System.out.println("Current Location: " + ((GPS) v).getCurrentLocation());
            }

            double fare = v.calculateFare(distances[i]);
            System.out.println("Distance Travelled: " + distances[i] + " km");
            System.out.println("Total Fare: ₹" + fare);
            System.out.println("---------------------------");
        }
    }
}
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    public Vehicle(String vehicleId, String driverName, double ratePerKm, String location) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Getters (Encapsulation)
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate/km: ₹" + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}
class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
        this.currentLocation = location;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50; // base charge for car
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
        this.currentLocation = location;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // no base charge
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
        this.currentLocation = location;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; // minimal base charge
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}
