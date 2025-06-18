import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentages = new double[n];
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));
            System.out.print("Physics: ");
            physics[i] = scanner.nextInt();
            if (physics[i] < 0) {
                System.out.println("Marks must be positive. Re-enter student " + (i + 1) + " data.");
                i--; continue;
            }
            System.out.print("Chemistry: ");
            chemistry[i] = scanner.nextInt();
            if (chemistry[i] < 0) {
                System.out.println("Marks must be positive. Re-enter student " + (i + 1) + " data.");
                i--; continue;
            }
            System.out.print("Maths: ");
            maths[i] = scanner.nextInt();
            if (maths[i] < 0) {
                System.out.println("Marks must be positive. Re-enter student " + (i + 1) + " data.");
                i--; continue;
            }
        }
        for (int i = 0; i < n; i++) {
            int total = physics[i] + chemistry[i] + maths[i];
            p[i] = total / 3.0;

             if (p[i] >= 80) {
                grades[i] = "A";
            } else if (p[i] >= 70 && p[i]<=79) {
                grades[i] = "B";
            } else if (p[i] >= 60 && p[i]<=69 ) {
                grades[i] = "C";
            } else if (p[i] >= 50 && p[i]<=59) {
                grades[i] = "D";
            } else if (p[i] >= 40 && p[i]<=49) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
        }
        System.out.println("\n=== Student Report ===");
        System.out.printf( "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        for (int i = 0; i < n; i++) {
            System.out.printf(physics[i], chemistry[i], maths[i], percentages[i], grades[i]);
        }

        scanner.close();
    }
}
