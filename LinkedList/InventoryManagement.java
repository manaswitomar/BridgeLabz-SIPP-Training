import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    Item(String name, int id, int qty, double price) {
        this.itemName = name;
        this.itemId = id;
        this.quantity = qty;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head;

    // Add at beginning
    public void addAtBeginning(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }

    // Add at end
    public void addAtEnd(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newItem;
        }
    }

    // Add at position (1-based)
    public void addAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos <= 1) {
            addAtBeginning(name, id, qty, price);
            return;
        }
        Item newItem = new Item(name, id, qty, price);
        Item temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addAtEnd(name, id, qty, price);
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    // Delete by ID
    public void deleteById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
        else
            System.out.println("Item not found.");
    }

    // Update quantity by ID
    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by ID
    public void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by Name
    public void searchByName(String name) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                printItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("Item not found.");
    }

    // Calculate total value
    public void totalInventoryValue() {
        Item temp = head;
        double total = 0;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    // Display all items
    public void displayItems() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        System.out.println("\n--- Inventory Items ---");
        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    private void printItem(Item item) {
        System.out.println("[" + item.itemId + "] " + item.itemName +
                " | Qty: " + item.quantity + " | ₹" + item.price);
    }

    // Sort by name
    public void sortByName(boolean ascending) {
        head = mergeSort(head, "name", ascending);
    }

    // Sort by price
    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, "price", ascending);
    }

    // Merge Sort
    private Item mergeSort(Item head, String key, boolean asc) {
        if (head == null || head.next == null)
            return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, key, asc);
        Item right = mergeSort(nextOfMiddle, key, asc);

        return sortedMerge(left, right, key, asc);
    }

    private Item sortedMerge(Item a, Item b, String key, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        Item result;

        boolean condition;
        if (key.equals("name"))
            condition = asc ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                            : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        else
            condition = asc ? a.price <= b.price
                            : a.price > b.price;

        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, key, asc);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, key, asc);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
public class InventoryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Delete Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Display All Items");
            System.out.println("9. Total Inventory Value");
            System.out.println("10. Sort by Name (Asc)");
            System.out.println("11. Sort by Name (Desc)");
            System.out.println("12. Sort by Price (Asc)");
            System.out.println("13. Sort by Price (Desc)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int id, qty, pos;
            String name;
            double price;

            switch (choice) {
                case 1:
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    name = sc.next(); id = sc.nextInt(); qty = sc.nextInt(); price = sc.nextDouble();
                    inventory.addAtBeginning(name, id, qty, price);
                    break;
                case 2:
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    name = sc.next(); id = sc.nextInt(); qty = sc.nextInt(); price = sc.nextDouble();
                    inventory.addAtEnd(name, id, qty, price);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    name = sc.next(); id = sc.nextInt(); qty = sc.nextInt(); price = sc.nextDouble();
                    inventory.addAtPosition(pos, name, id, qty, price);
                    break;
                case 4:
                    System.out.print("Enter Item ID to delete: ");
                    id = sc.nextInt();
                    inventory.deleteById(id);
                    break;
                case 5:
                    System.out.print("Enter Item ID and new quantity: ");
                    id = sc.nextInt(); qty = sc.nextInt();
                    inventory.updateQuantity(id, qty);
                    break;
                case 6:
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();
                    inventory.searchById(id);
                    break;
                case 7:
                    System.out.print("Enter Item Name: ");
                    name = sc.next();
                    inventory.searchByName(name);
                    break;
                case 8:
                    inventory.displayItems();
                    break;
                case 9:
                    inventory.totalInventoryValue();
                    break;
                case 10:
                    inventory.sortByName(true);
                    break;
                case 11:
                    inventory.sortByName(false);
                    break;
                case 12:
                    inventory.sortByPrice(true);
                    break;
                case 13:
                    inventory.sortByPrice(false);
                    break;
                case 0:
                    System.out.println("Exiting Inventory App.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
