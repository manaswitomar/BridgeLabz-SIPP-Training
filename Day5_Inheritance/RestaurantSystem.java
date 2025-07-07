class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID  : " + id);
    }
}
interface Worker {
    void performDuties(); // abstract method to be implemented by all workers
}
class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Duties     : Cooking " + specialty + " dishes");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role       : Chef");
        System.out.println("Specialty  : " + specialty);
    }
}
class Waiter extends Person implements Worker {
    private int tableCount;

    public Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

    @Override
    public void performDuties() {
        System.out.println("Duties     : Serving " + tableCount + " tables");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role       : Waiter");
        System.out.println("Tables     : " + tableCount);
    }
}
public class RestaurantSystem {
    public static void main(String[] args) {
        Worker w1 = new Chef("Raj", 101, "Italian");
        Worker w2 = new Waiter("Anjali", 102, 6);

        System.out.println("=== Restaurant Staff ===");

        if (w1 instanceof Person) {
            ((Person) w1).displayInfo();
            w1.performDuties();
        }

        if (w2 instanceof Person) {
            ((Person) w2).displayInfo();
            w2.performDuties();
        }
    }
}

