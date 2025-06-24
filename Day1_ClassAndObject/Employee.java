package OOPs.Day1_ClassAndObject;

public class Employee{
    // Attributes
    String name;
    int id;
    double salary;

    // Constructor
    public Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Salary : $" + salary);
    }

    // Main method to test the Employee class
    public static void main(String[] args) {
        Employee emp1 = new Employee("John", 101, 50000);
        emp1.displayDetails();
    }
}
