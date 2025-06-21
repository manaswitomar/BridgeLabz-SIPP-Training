import java.util.*;

public class StringLengthDemo {
    public static int WithoutUsingLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);  
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        int lengthManual = WithoutUsingLength(input);
        int lengthBuiltIn = input.length();
        System.out.println("\nLength using charAt() method: " + lengthManual);
        System.out.println("Length using length() method: " + lengthBuiltIn);
        if (lengthManual == lengthBuiltIn) {
            System.out.println("Both lengths match.");
        } else {
            System.out.println(" Lengths do not match.");
        }
        sc.close();
    }
}
