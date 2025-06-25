public class Circles {
    double radius;

    public Circles() {
        this(1.0); 
    }

    public Circles(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
    }

    public static void main(String[] args) {
        Circles c1 = new Circles();            
        Circles c2 = new Circles(5.5);  

        System.out.println("Circle 1:");
        c1.displayDetails();

        System.out.println("\nCircle 2:");
        c2.displayDetails();
    }
}
