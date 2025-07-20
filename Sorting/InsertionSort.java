import java.util.Scanner;

public class InsertionSort{
    public static void insertionSort(int[] empIds) {
        int n = empIds.length;
        for (int i = 1; i < n; i++) {
            int key = empIds[i];
            int j = i - 1;
            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j--;
            }
            empIds[j + 1] = key;
        }
    }
    public static void printArray(int[] arr) {
        for (int id : arr) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();

        int[] empIds = new int[n];
        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) {
            System.out.print("Employee " + (i + 1) + " ID: ");
            empIds[i] = scanner.nextInt();
        }

        System.out.println("\nOriginal Employee IDs:");
        printArray(empIds);

        insertionSort(empIds);

        System.out.println("\nSorted Employee IDs (Ascending):");
        printArray(empIds);
    }
}
