public class Employee{
    String name;
    int id;
    double salary;
    public Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Salary : $" + salary);
    }
    public static void main(String[] args) {
        Employee emp1 = new Employee("John", 101, 50000);
        emp1.displayDetails();
    }
}
