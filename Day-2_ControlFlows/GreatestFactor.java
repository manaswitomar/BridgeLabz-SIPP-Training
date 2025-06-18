import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        
        int greatestFactor = 1;

        
        int counter = number - 1;

        
        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break; 
            }
            counter--;
        }

        
        System.out.println("Greatest factor of " + number + " (excluding itself): " + greatestFactor);

        scanner.close();
    }
}
