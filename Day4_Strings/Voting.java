import java.util.*;

public class Voting {
    public static int[] generateAges(int numStudents) {
        Random rand = new Random();
        int[] ages = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            ages[i] = rand.nextInt(90) + 10;  
        }
        return ages;
    }
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            result[i][0] = String.valueOf(age);

            if (age < 0) {
                result[i][1] = "false";  
            } else if (age >= 18) {
                result[i][1] = "true";   
            } else {
                result[i][1] = "false";  
            }
        }
        return result;
    }
    public static void displayVotingStatus(String[][] eligibilityData) {
        System.out.printf("%-10s %-10s\n", "Age", "Can Vote?");
        for (int i = 0; i < eligibilityData.length; i++) {
            System.out.printf("%-10s %-10s\n", eligibilityData[i][0], eligibilityData[i][1]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = 10;
        int[] ages = generateAges(numberOfStudents);
        String[][] eligibility = checkVotingEligibility(ages);
        displayVotingStatus(eligibility);
    }
}
