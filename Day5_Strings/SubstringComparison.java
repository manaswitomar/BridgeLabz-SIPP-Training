import java.util.*;

public class SubstringComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the original string: ");
        String input = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index (exclusive): ");
        int end = sc.nextInt();
        if (start < 0 || end > input.length() || start >= end)
        {
            System.out.println("Invalid index range.");
        }
        String manualSubstring = createSubstringUsingCharAt(input, start, end);
        String builtInSubstring = input.substring(start, end);
        boolean areEqual = compareStringsUsingCharAt(manualSubstring, builtInSubstring);
        System.out.println("Manual Substring: " + manualSubstring);
        System.out.println("Built-in Substring: " + builtInSubstring);
        System.out.println("Are both substrings equal? " + areEqual);
        sc.close();}
    public static String createSubstringUsingCharAt(String str, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(str.charAt(i));}
        return result.toString();}
    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
