import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int[] freq = new int[256];
        char mostFreqChar = ' ';
        int maxCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;

            if (freq[ch] > maxCount) {
                maxCount = freq[ch];
                mostFreqChar = ch;
            }
        }
        System.out.println("Most Frequent Character: '" + mostFreqChar + "'");
        sc.close();
    }
}
