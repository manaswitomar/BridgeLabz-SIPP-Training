import java.util.*;

public class LargestDigitsFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        while (num != 0) {
            if (index == maxDigit) {
                System.out.println("Only first 10 digits will be considered.");
                break;
            }
            int digit = num % 10;       
            digits[index] = digit;         
            index++;
            num = num/ 10;          
        }
        int largest = -1;
        int secondLargest = -1;
        for (int i = 0; i < index; i++) {
            int digit = digits[i];
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
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
