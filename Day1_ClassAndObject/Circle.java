public class Circle {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
        
    }

    // Method to calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }

    // Main method
public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        circle.displayDetails();
    }
}