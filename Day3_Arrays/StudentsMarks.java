import java.util.*;

public class StudentMarksCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] marks = new int[n][3];  
        double[] p = new double[n];
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                while (true) {
                    System.out.print("Enter marks for " + subject + ": ");
                    int mark = scanner.nextInt();
                    if (mark >= 0 && mark <= 100) {
                        marks[i][j] = mark;
                        break;
                    } else {
                        System.out.println("Invalid marks");
                    }}}}
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
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
            }}
        System.out.println("\n Student Report Card");
        System.out.printf( "Physics", "Chemistry", "Maths", "Percentage", "Grade", "Status");
        for (int i = 0; i < n; i++) {
            String status = grades[i].equals("F") ? "Fail" : "Pass";
            System.out.println(marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i], status);
        }
    }
}
