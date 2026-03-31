import java.util.Scanner;

public class MergeSort{
    public static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = prices[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = prices[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k++] = leftArray[i++];
            } else {
                prices[k++] = rightArray[j++];
            }
        }
        while (i < n1) {
            prices[k++] = leftArray[i++];
        }
        while (j < n2) {
            prices[k++] = rightArray[j++];
        }
    }
    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            merge(prices, left, mid, right);
        }
    }
    public static void printArray(int[] arr) {
        for (int price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = scanner.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter the prices of the books:");
        for (int i = 0; i < n; i++) {
            System.out.print("Book " + (i + 1) + " Price: ");
            prices[i] = scanner.nextInt();
        }

        System.out.println("\nOriginal Prices:");
        printArray(prices);

        mergeSort(prices, 0, prices.length - 1);

        System.out.println("\nSorted Prices (Ascending):");
        printArray(prices);
    }
}
