import java.util.Scanner;

public class BMITracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int num = sc.nextInt();

        double[][] personData = new double[num][3]; 
        String[] status = new String[num];
        for (int i = 0; i < num; i++) {
            System.out.println("\nEnter data for Person " + (i + 1));

            double height;
            do {
                System.out.print("Enter height in meters: ");
                height = sc.nextDouble();
                if (height <= 0) {
                    System.out.println("Height must be positive");
                }
            } while (height <= 0);

            double weight;
            do {
                System.out.print("Enter weight in kilograms: ");
                weight = sc.nextDouble();
                if (weight <= 0) {
                    System.out.println("Weight must be positive");
                }
            } while (weight <= 0);

            personData[i][0] = height;
            personData[i][1] = weight;
            double bmi = weight / (height * height);
            personData[i][2] = bmi;
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 24.9) {
                status[i] = "Normal";
            } else if (bmi < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        System.out.println(" BMI Report");
        System.out.printf( "Height", "Weight", "BMI", "Status");
        for (int i = 0; i < num; i++) {
            System.out.printf(null,)(personData[i][0], personData[i][1], personData[i][2], status[i]);
        }
        sc.close();
    }
}
