import java.util.*;

public class NumberFormat {
    public static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number); 
    }
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println( e.getMessage());
        } catch (RuntimeException e) {
            System.out.println( e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to parse as integer: ");
        String input = sc.nextLine();
        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Program crashed due to unhandled exception: " + e);
        }
        handleException(input);
        sc.close();
    }
}
