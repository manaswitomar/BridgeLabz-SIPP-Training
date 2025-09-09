package IntelligentStoreDashboard;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Item{
	String name,category;
	double price;
	public Item(String name,String category,double price) {
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
}

class Order{
	LocalDate date;
	List<Item> items;
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
class Customer{
	List<Order> orders;
	public Customer(List<Order> orders) {
		this.orders = orders;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
}

class Store{
	Map<Customer,List<Order>> customerOrders;
	public Store(Map<Customer,List<Order>> customerOrders) {
		this.customerOrders = customerOrders;
	}
	public Map<Customer, List<Order>> getCustomerOrders() {
		return customerOrders;
	}
}
class IntelligentStoreDashboard {
	public static void main(String[] args) {
		Map<String,List<Store>> cityToStoresMap = new HashMap<>();
		LocalDate cutoff = LocalDate.now().minusDays(60);
		List<Item> topAffordable = cityToStoresMap.values().stream()
	            .flatMap(List::stream)
	            .flatMap(store -> store.getCustomerOrders().entrySet().stream())
	            .filter(e -> e.getValue().stream().filter(o -> o.getDate().isAfter(cutoff)).count() >= 3)
	            .map(Map.Entry::getKey)
	            .flatMap(c -> c.getOrders().stream()
	                .filter(o -> o.getDate().isAfter(cutoff))
	                .flatMap(o -> o.getItems().stream()))
	            .distinct()
	            .sorted(Comparator.comparingDouble(Item::getPrice).reversed())
	            .peek(i -> System.out.println(i.getName() + " " + i.getPrice()))
	            .skip(2)
	            .limit(10)
	            .collect(Collectors.toList());
		
		
		Map<String, List<Item>> grouped = topAffordable.stream()
	            .collect(Collectors.groupingBy(Item::getCategory));

	        long electronicsCount = grouped.getOrDefault("Electronics", Collections.emptyList()).size();
	        boolean anyOver500 = topAffordable.stream().anyMatch(i -> i.getPrice() > 500);
	        boolean allAbove10 = topAffordable.stream().allMatch(i -> i.getPrice() > 10);
	        boolean noneEmptyName = topAffordable.stream().noneMatch(i -> i.getName() == null || i.getName().isEmpty());
	        Optional<Item> firstHome = topAffordable.stream().filter(i -> "Home Appliances".equals(i.getCategory())).findFirst();
	        Optional<Item> anyFitness = topAffordable.stream().filter(i -> "Fitness".equals(i.getCategory())).findAny();
	        double total = topAffordable.stream().mapToDouble(Item::getPrice).sum();

	        System.out.println("Electronics count: " + electronicsCount);
	        System.out.println("Any over 500: " + anyOver500);
	        System.out.println("All above 10: " + allAbove10);
	        System.out.println("None with empty name: " + noneEmptyName);
	        firstHome.ifPresent(i -> System.out.println("First Home Appliance: " + i.getName()));
	        anyFitness.ifPresent(i -> System.out.println("Any Fitness item: " + i.getName()));
	        System.out.println("Total price: " + total);

	}
}