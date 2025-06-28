import java.util.ArrayList;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayInfo() {
        System.out.println(name + " - ₹" + price);
    }
}

class Order {
    int orderId;
    private ArrayList<Product> productList;

    public Order(int orderId) {
        this.orderId = orderId;
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void displayOrder() {
        System.out.println("Order #" + orderId + " contains:");
        for (Product p : productList) {
            p.displayInfo();
        }
    }

    public double getTotal() {
        double total = 0;
        for (Product p : productList) {
            total += p.getPrice();
        }
        return total;
    }
}

class Customer {
    private String name;
    private ArrayList<Order> orders;

    public Customer(String name) {
        this.name = name;
        orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        System.out.println(name + " placed Order #" + order.orderId);
        orders.add(order);
    }

    public void displayOrders() {
        System.out.println("\nOrders placed by " + name + ":");
        for (Order o : orders) {
            o.displayOrder();
            System.out.println("Total: ₹" + o.getTotal() + "\n");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Product laptop = new Product("Laptop", 55000);
        Product phone = new Product("Smartphone", 20000);
        Product earphones = new Product("Earphones", 1500);

        Customer john = new Customer("John");

        Order order1 = new Order(101);
        order1.addProduct(laptop);
        order1.addProduct(earphones);
        john.placeOrder(order1);

        Order order2 = new Order(102);
        order2.addProduct(phone);
        john.placeOrder(order2);

        john.displayOrders();
    }
}
