import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        if (number == 0) {
            System.out.println("Number of digits: 1");
        } else {
           
            int count = 0;
            number = Math.abs(number); 
            
            while (number != 0) {
                number = number / 10; 
                count++; 
            }

           
            System.out.println("Number of digits: " + count);
        }

        scanner.close();
    }
}
