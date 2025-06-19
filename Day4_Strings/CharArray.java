import java.util.*;

public class CharArray{
    public static char[] getCharacters(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    public static void printCharArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        char[] manualChars = getCharacters(input);
        char[] builtinChars = input.toCharArray();
        boolean isEqual = compareCharArrays(manualChars, builtinChars);
        System.out.print("\nManual Character Array:   ");
        printCharArray(manualChars);
        System.out.print("Built-in Character Array: ");
        printCharArray(builtinChars);
        System.out.println("Are both arrays equal? " + isEqual);
    }
}
