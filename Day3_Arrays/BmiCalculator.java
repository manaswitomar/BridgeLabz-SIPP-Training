import java.util.*;

public class BMICalculator {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] heights = new double[n];       
        double[] weights = new double[n];       
        double[] bmis = new double[n];
        String[] status = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter data for Person " + (i + 1));
            do {
                System.out.print("Enter height (in meters): ");
                heights[i] = sc.nextDouble();
                if (heights[i] <= 0) {
                    System.out.println("Height must be positive");
                }
            } while (heights[i] <= 0);
            do {
                System.out.print("Enter weight (in kilograms): ");
                weights[i] = sc.nextDouble();
                if (weights[i] <= 0) {
                    System.out.println("Weight must be positive");
                }
            } while (weights[i] <= 0);}
        for (int i = 0; i < n; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);

            if (bmis[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmis[i] < 25) {
                status[i] = "Normal";
            } else if (bmis[i] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }}
        System.out.println("\n BMI Report");
        System.out.printf("Height", "Weight", "BMI", "Status");
        for (int i = 0; i < n; i++) {
            System.out.println(heights[i], weights[i], bmis[i], status[i]);
        }
    }
}
