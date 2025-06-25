import java.util.Scanner;

public class Prime_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number greater than 13: ");
        int number = scanner.nextInt();

        boolean isPrime = true;  
        if (number <= 13) {
            System.out.println("Please enter a number greater than 13.");
        } else {
            
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false; 
                    break;           
                }
            }
            if (isPrime) {
                System.out.println(number + " is a Prime Number.");
            } else {
                System.out.println(number + " is Not a Prime Number.");
            }
        }

        scanner.close();
    }
}
