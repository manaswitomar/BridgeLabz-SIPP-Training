import java.util.*;

public class ArrayIndex{
    public static void generateException(String[] names, int index) {
        System.out.println("Accessing name at index " + index + ": " + names[index]);
    }
    public static void handleException(String[] names, int index) {
        try {
            System.out.println("Accessing name at index " + index + ": " + names[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of names: ");
        int size = sc.nextInt();
        sc.nextLine(); 
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name[" + i + "]: ");
            names[i] = sc.nextLine();
        }
        System.out.print("Enter the index to access: ");
        int index = sc.nextInt();
        try {
            generateException(names, index);
        } catch (Exception e) {
            System.out.println( e);
        }
        handleException(names, index);
        sc.close();
    }
}
