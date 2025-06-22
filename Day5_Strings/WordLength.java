import java.util.*;
public class WordLength{
    public static String[] splitWords(String text) {
        StringBuilder word = new StringBuilder();
        java.util.List<String> wordsList = new java.util.ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word.append(ch);
            } else {
                if (word.length() > 0) {
                    wordsList.add(word.toString());
                    word.setLength(0);
                }}}
        if (word.length() > 0) {
            wordsList.add(word.toString());
        }
        return wordsList.toArray(new String[0]);
    }
    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return count;
    }
    public static String[][] buildWordLengthTable(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getStringLength(words[i]));
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        String[] words = splitWords(input);
        String[][] wordLengths = buildWordLengthTable(words);
        System.out.println("\nWord\t\tLength");
        for (String[] row : wordLengths) {
            String word = row[0];
            int length = Integer.parseInt(row[1]);
            System.out.println(word + "\t\t" + length);
        }
        scanner.close();
    }
}
