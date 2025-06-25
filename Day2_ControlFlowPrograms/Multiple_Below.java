import java.util.Scanner;

public class Multiple_Below{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer less than 100: ");
        int number = scanner.nextInt();
        if (number > 0 && number < 100) {
            int counter = number - 1;

            System.out.println("Numbers less than " + number + " that divide it exactly:");
            while (counter > 1) {
                
                if (number % counter == 0) {
                    
                    System.out.println(counter);
                }
                counter--;
            }
        } else {
            System.out.println("Please enter a valid positive integer less than 100.");
        }

        scanner.close();
    }
}
