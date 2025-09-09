package IntelligentSalesDashboard;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static Object stream() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stream'");
    }
}

class Item {
    private String name;
    private String category;
    private double price;

    public Item(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ", " + category + ")";
    }
}

class Order {
    private LocalDate date;
    private List<Item> items;

    public Order(LocalDate date, List<Item> items) {
        this.date = date;
        this.items = items;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Item> getItems() {
        return items;
    }
}
class SalesDashboard{
    public static void main(String[] args){
        
        List<Item> items = Arrays.asList(
            new Item("Smartphone", "Electronics", 699.99),
            new Item("Laptop", "Electronics", 999.99),
            new Item("Headphones", "Electronics", 199.99),
            new Item("Smartwatch", "Electronics", 299.99),
            new Item("Blender", "Home Appliances", 89.99),
            new Item("Toaster", "Home Appliances", 49.99),
            new Item("Kettle", "Home Appliances", 39.99),
            new Item("Treadmill", "Fitness", 499.99),
            new Item("Dumbbell Set", "Fitness", 149.99),
            new Item("Yoga Mat", "Fitness", 29.99)
        );

        LocalDate today = LocalDate.now();

        List<Order> order=Arrays.asList(
            new Order(today.minusDays(10), Arrays.asList(items.get(0), items.get(4))), 
            new Order(today.minusDays(20), Arrays.asList(items.get(1), items.get(7))), 
            new Order(today.minusDays(30), Arrays.asList(items.get(2), items.get(8))), 
            new Order(today.minusDays(70), Arrays.asList(items.get(3), items.get(5))), 
            new Order(today.minusDays(15), Arrays.asList(items.get(6))),               
            new Order(today.minusDays(5), Arrays.asList(items.get(9)))                
        );        
        
        Map<String, List<Order>> store1 = new HashMap<>();
        store1.put("Alice", Arrays.asList(order.get(0), order.get(1), order.get(2)));  
        store1.put("Bob", Arrays.asList(order.get(3), order.get(4)));           

        Map<String, List<Order>> store2 = new HashMap<>();
        store2.put("Charlie", Arrays.asList(order.get(0), order.get(5)));    

        Map<String, List<Map<String, List<Order>>>> cityToStoresMap = new HashMap<>();
        cityToStoresMap.put("New York", Arrays.asList(store1, store2));

        LocalDate cutoffDate = today.minusDays(60);

        Stream<Item> itemStream = cityToStoresMap.values().stream()
            .flatMap(List::stream)                               
            .flatMap(store -> store.values().stream())            
            .filter(orders -> orders.stream()
                    .filter(o -> o.getDate().isAfter(cutoffDate))
                    .count() >= 3)                                
            .flatMap(orders -> orders.stream()
                    .flatMap(ord -> ord.getItems().stream()));
                     

        
        Map<String, Double> categorySales = itemStream
            .collect(Collectors.groupingBy(
                Item::getCategory,
                Collectors.summingDouble(Item::getPrice)
            )); 
        categorySales.forEach((category, total) ->

            System.out.println("Category: " + category + ", Total Sales: $" + String.format("%.2f", total))
        );  
    }
}