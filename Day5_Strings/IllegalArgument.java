import java.util.*;

public class IllegalArgument {
    public static void generateException(String str) {
        String result = str.substring(5, 2); 
        System.out.println("Substring: " + result); 
    }
    public static void handleException(String str) {
        try {
            String result = str.substring(5, 2);
            System.out.println("Substring: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println( e.getMessage());
        } catch (RuntimeException e) {
            System.out.println( e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        System.out.println("\n--- Generating Unhandled Exception ---");
        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Program crashed due to unhandled exception: " + e.getMessage());}
        System.out.println("\n--- Handling Exception with Try-Catch ---");
        handleException(input);
        sc.close();
    }
}
