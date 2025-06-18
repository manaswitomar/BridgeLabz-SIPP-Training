import java.util.*;

public class LargestDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = sc.nextLong();
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        if (num == 0) {
            digits[index++] = 0;
        } else {
            while (num != 0) {
                if (index == maxDigit) {
                    maxDigit *= 2;
                    int[] temp = new int[maxDigit];
                    for (int i = 0; i < index; i++) {
                        temp[i] = digits[i];
                    }
                    digits = temp;}
                int digit = (int) (num % 10);
                digits[index++] = digit;
                num /= 10;
            }}
        int largest = -1, secondLargest = -1;
        for (int i = 0; i < index; i++) {
            int digit = digits[i];
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }}
        System.out.print("\nDigits: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }
        System.out.println("\n\nLargest digit: " + largest);
        if (secondLargest != -1) {
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("all digits are the same");
        }
    }
}
