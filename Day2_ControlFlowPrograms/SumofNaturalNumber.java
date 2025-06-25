import java.util.Scanner;

public class SumofNaturalNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("The number"+n+" is not a natural number");
        } else {
            int i = 1;
            int sum = 0;
            sum= n * (n+1) / 2;
            System.out.print(" The sum of"+n+"natural numbers is"+sum); 
        }
        sc.close();
    }
}