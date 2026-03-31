import java.util.ArrayList;

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        ArrayList<FoodItem> orderList = new ArrayList<>();

        FoodItem vegBurger = new VegItem("Veg Burger", 120, 2);
        FoodItem chickenWrap = new NonVegItem("Chicken Wrap", 180, 1);

        orderList.add(vegBurger);
        orderList.add(chickenWrap);

        // Apply discounts
        for (FoodItem item : orderList) {
            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount(10); // 10% discount
            }
        }

        // Process Order
        double grandTotal = 0;
        for (FoodItem item : orderList) {
            item.getItemDetails();
            if (item instanceof Discountable) {
                System.out.println(((Discountable) item).getDiscountDetails());
            }
            double total = item.calculateTotalPrice();
            System.out.println("Final Price: ₹" + total);
            grandTotal += total;
            System.out.println("-----------------------------------");
        }

        System.out.println("Total Order Amount: ₹" + grandTotal);
    }
}
interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation: Getters
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // Encapsulation: Setters
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: ₹" + price + ", Quantity: " + quantity);
    }
}
class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - discount;
    }

    @Override
    public void applyDiscount(double percentage) {
        discount = (getPrice() * getQuantity()) * (percentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount Applied: ₹" + discount;
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount;
    private static final double NON_VEG_CHARGE = 20.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double base = getPrice() * getQuantity();
        double total = base + NON_VEG_CHARGE;
        return total - discount;
    }

    @Override
    public void applyDiscount(double percentage) {
        discount = (getPrice() * getQuantity()) * (percentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount Applied: ₹" + discount + ", Additional Charge: ₹" + NON_VEG_CHARGE;
    }
}
