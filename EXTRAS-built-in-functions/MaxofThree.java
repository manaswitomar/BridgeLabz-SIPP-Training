import java.util.Scanner;

public class MaxofThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = getInput(scanner, "Enter first number: ");
        int num2 = getInput(scanner, "Enter second number: ");
        int num3 = getInput(scanner, "Enter third number: ");

        int max = findMaximum(num1, num2, num3);
        System.out.println("The maximum number is: " + max);

        scanner.close();
    }
    public static int getInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
    public static int findMaximum(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        return max;
    }
}
