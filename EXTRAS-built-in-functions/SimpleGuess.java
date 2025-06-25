import java.util.Scanner;

public class SimpleGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1;
        int high = 100;
        String feedback = "";

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it. Respond with: low, high, or correct.");

        while (!feedback.equals("correct") && low <= high) {
            int guess = (low + high) / 2;
            System.out.println("Is your number " + guess + "?");

            System.out.print("Enter feedback (low/high/correct): ");
            feedback = sc.nextLine().toLowerCase();

            if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("correct")) {
                System.out.println("Yay! I guessed your number.");
            } else {
                System.out.println("Please enter only: low, high, or correct.");
            }
        }

        sc.close();
    }
}
