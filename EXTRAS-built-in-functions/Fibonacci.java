import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci terms to generate: ");
        int terms = sc.nextInt();
        printFibonacci(terms);

        sc.close();
    }
    public static void printFibonacci(int n) {
        int first = 0, second = 1;

        System.out.println("Fibonacci Sequence up to " + n + " terms:");
        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }
}
