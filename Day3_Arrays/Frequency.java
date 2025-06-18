import java.util.*;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong(); 
        int[] digits = new int[20]; 
        int index = 0;
        long temp = num;
        if (temp == 0) {
            digits[index++] = 0;  
        } else {
            while (temp > 0) {
                digits[index++] = (int)(temp % 10);  
                temp /= 10;
            }}
        int[] freq = new int[10];  
        for (int i = 0; i < index; i++) {
            freq[digits[i]]++;
        }
        System.out.println("\nFrequency of digits in number " + num + ":");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println("Digit " + i + " => " + freq[i] + " time(s)");
            }
        }
    }
}
