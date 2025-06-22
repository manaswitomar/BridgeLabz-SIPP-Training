import java.util.Scanner;

public class Even_Odd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number (positive integer): ");
        int number = scanner.nextInt();

        if (number > 0) {
           
            for (int i = 1; i <= number; i++) {
                
                if (i % 2 == 0) {
                    System.out.println(i + " is an Even number");
                } else {
                    System.out.println(i + " is an Odd number");
                }
            }
        } else {
            System.out.println("Please enter a valid natural number (greater than 0).");
        }

        scanner.close();
    }
}
