import java.util.*;

public class StringCompare {
    public static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.next();
        System.out.print("Enter second string: ");
        String str2 = sc.next();
        boolean manualCompare = compareUsingCharAt(str1, str2);
        boolean builtInCompare = str1.equals(str2);
        System.out.println("\nComparison using charAt(): " + manualCompare);
        System.out.println("Comparison using equals(): " + builtInCompare);
        if (manualCompare == builtInCompare) {
            System.out.println(" Both methods give the same result.");
        } else {
            System.out.println(" Methods give different results (unexpected).");
        }
        sc.close();
    }
}
