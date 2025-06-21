import java.util.*;

public class TrimString{
    public static int[] getTrimIndexes(String str) {
        int start = 0, end = str.length() - 1;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }
    public static String customSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with leading/trailing spaces: ");
        String input = sc.nextLine();
        int[] trimIndexes = getTrimIndexes(input);
        int start = trimIndexes[0];
        int end = trimIndexes[1];
        String customTrimmed = (start <= end) ? customSubstring(input, start, end) : "";
        String builtInTrimmed = input.trim();
        boolean match = compareUsingCharAt(customTrimmed, builtInTrimmed);
        System.out.println("\nTrimmed using custom method: '" + customTrimmed + "'");
        System.out.println("Trimmed using built-in method: '" + builtInTrimmed + "'");
        System.out.println("Do both results match? " + (match ? " Yes" : " No"));
        sc.close();
    }
}
