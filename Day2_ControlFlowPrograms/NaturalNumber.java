import java.util.Scanner;

public class NaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Error: Input must be a natural number (greater than 0).");
        } else {
            int i = 1;
            int sum = 0;
            while (i <= n) {
                sum += i;
                i++;
            }
            int sum1 = n * (n + 1) / 2;
            System.out.println("Sum using while loop: " + sum);
            System.out.println("Sum using formula:    " + sum1);

            if (sum == sum1) {
                System.out.println("✅ Both results match. The computation is correct.");
            } else {
                System.out.println("❌ Results do not match. There might be an error.");
            }
        }

        scanner.close();
    }
}
