import java.util.Scanner;

public class CountSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the main string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter the substring to count: ");
        String str2 = sc.nextLine();

        int count = 0;
        int index = 0;
        while ((index = str1.indexOf(str2, index)) != -1) {
            count++;
            index = index + str2.length();
        }
        System.out.println("The substring occurs " + count + " times.");
        sc.close();
    }
}
