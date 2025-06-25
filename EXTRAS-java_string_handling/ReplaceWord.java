import java.util.Scanner;

public class ReplaceWord {
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        return sentence.replace(oldWord, newWord);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        System.out.print("Enter the word to replace: ");
        String oldWord = scanner.nextLine();

        System.out.print("Enter the new word: ");
        String newWord = scanner.nextLine();
        String modifiedSentence = replaceWord(sentence, oldWord, newWord);
        System.out.println("Modified sentence: " + modifiedSentence);

        scanner.close();
    }
}
