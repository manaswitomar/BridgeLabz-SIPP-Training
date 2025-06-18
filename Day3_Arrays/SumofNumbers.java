import java.util.Scanner;
public class SumofNumbers{
    public static void main(String[] args){
        import java.util.Scanner;
        double[] numbers = new double[10];
        double total = 0.0;                
        int index = 0;                     
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter up to 10 positive numbers (0 or negative to stop):");
        while (true) {
            System.out.print("Enter number #" + (index + 1) + ": ");
            double input = scanner.nextDouble();

            if (input <= 0) {
                break; 
            }

            if (index == 10) {
                break; 
            }

            numbers[index] = input; 
            index++;                
        }
        System.out.println("\nYou entered:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }

        System.out.println("\nTotal sum = " + total);

        scanner.close();
    }
}

