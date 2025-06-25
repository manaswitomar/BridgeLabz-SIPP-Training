import java.util.*;

public class SplitWords {
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }
    public static String[] manualSplit(String text) {
        int len = getLength(text);
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }
        String[] words = new String[wordCount];
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    words[index++] = sb.toString();
                    sb.setLength(0);
                }
            }
        }
        if (sb.length() > 0 && index < wordCount) {
            words[index] = sb.toString();
        }
        return words;
    }
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }
    public static void displayArray(String[] arr, String title) {
        System.out.println("\n" + title);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Word " + (i + 1) + ": " + arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        String[] customSplit = manualSplit(input);
        String[] builtInSplit = input.trim().split("\\s+");
        displayArray(customSplit, "Manual Split (charAt):");
        displayArray(builtInSplit, "Built-in split():");
        boolean areEqual = compareArrays(customSplit, builtInSplit);
        System.out.println("\nAre both arrays equal? " + areEqual);
        scanner.close();
    }

}
