import java.util.Scanner;

public class GCDLCM {

    public static void main(String[] args) {
        int[] num = getInput();
        int num1 = num[0];
        int num2 = num[1];
        int gcd = findGCD(num1, num2);
        int lcm = findLCM(num1, num2, gcd);
        displayResult(num1, num2, gcd, lcm);
    }
    public static int[] getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int a = sc.nextInt();
        System.out.print("Enter the second number: ");
        int b = sc.nextInt();
        sc.close();
        return new int[]{a, b};
    }
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int findLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
    public static void displayResult(int a, int b, int gcd, int lcm) {
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
    }
}
