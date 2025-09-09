import java.util.*;
import java.util.Stack;

public class StockSpan {
    public static int[] calculateSpan(int[] price) {
        int n = price.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); 

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            stack.push(i);
        }

        return span;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] price = new int[n];
        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        int[] span = calculateSpan(price);

        System.out.print("Stock spans: ");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
