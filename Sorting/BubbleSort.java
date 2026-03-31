import java.util.Scanner;

public class BubbleSort{

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    public static void printArray(int[] arr) {
        for (int mark : arr) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[] marks = new int[n];

        System.out.println("Enter the marks of " + n + " students:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        System.out.println("\nOriginal Marks:");
        printArray(marks);
        bubbleSort(marks);

        System.out.println("\nSorted Marks (Ascending):");
        printArray(marks);
    }
}
