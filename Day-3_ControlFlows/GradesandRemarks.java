import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks for Physics: ");
        int physics = scanner.nextInt();

        System.out.print("Enter marks for Chemistry: ");
        int chemistry = scanner.nextInt();

        System.out.print("Enter marks for Maths: ");
        int maths = scanner.nextInt();
        int total = physics + chemistry + maths;
        double percentage = total / 3.0;
        String grade, remarks;
         if (percentage >= 80) {
            grade = "A";
            remarks = "Level-4, above agency-normalized standards";
        } else if (percentage >= 70 && percentage<=79) {
            grade = "B";
            remarks = "Level-3, at agency-normalized standards";
        } else if (percentage >= 60&& percentage<=69) {
            grade = "C";
            remarks = "Levl-2,below but approaching agency-normalized standards";
        } else if (percentage >= 50 && percentage<=59) {
            grade = "D";
            remarks = "Level-1, well below agency-normalized standards";
        } else if(percentage>=40 && percentage<=49){
            grade = "E";
            remarks = "Level-1, too below agency-normalized standards";
        }
        else{
            grade="R";
            remarks="Remedial standards"
        }

        
        System.out.println("\n--- Result ---");
        System.out.printf("Average Marks: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);

        scanner.close();
    }
}
