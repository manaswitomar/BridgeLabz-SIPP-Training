import java.util.Scanner;

public class Youngest_Tallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Amar's age: ");
        int ageAmar = scanner.nextInt();
        System.out.print("Enter Amar's height (in cm): ");
        int heightAmar = scanner.nextInt();

        System.out.print("Enter Akbar's age: ");
        int ageAkbar = scanner.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        int heightAkbar = scanner.nextInt();

        System.out.print("Enter Anthony's age: ");
        int ageAnthony = scanner.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        int heightAnthony = scanner.nextInt();
        String youngest = "";
        int minAge = ageAmar;

        if (ageAkbar < minAge) {
            minAge = ageAkbar;
            youngest = "Akbar";
        } else {
            youngest = "Amar";
        }

        if (ageAnthony < minAge) {
            minAge = ageAnthony;
            youngest = "Anthony";
        }
        String tallest = "";
        int maxHeight = heightAmar;

        if (heightAkbar > maxHeight) {
            maxHeight = heightAkbar;
            tallest = "Akbar";
        } else {
            tallest = "Amar";
        }

        if (heightAnthony > maxHeight) {
            maxHeight = heightAnthony;
            tallest = "Anthony";
        }
        System.out.println("\nYoungest friend: " + youngest + " (Age: " + minAge + ")");
        System.out.println("Tallest friend: " + tallest + " (Height: " + maxHeight + " cm)");

        scanner.close();
    }
}
