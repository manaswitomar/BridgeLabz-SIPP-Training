import java.util.Scanner;

public class Sum_Zero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double total = 0.0;
        double number;
        number = scanner.nextDouble();
        while (number != 0) {
            total += number;  
            System.out.print("Enter a number (0 to stop): ");
            number = scanner.nextDouble();
        }

        
        System.out.println("Total sum = " + total);

        scanner.close();
    }
}
