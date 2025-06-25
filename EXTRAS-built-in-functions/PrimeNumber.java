import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a number to check if it's prime: ");
        int number = sc.nextInt();
        boolean result = isPrime(number);
        if (result) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        sc.close();
    }
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false; 
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
 