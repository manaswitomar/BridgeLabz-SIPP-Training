import java.util.*;

public class Reverse_String {

    public static <T> void reverseArrayList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {

            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static <T> void reverseLinkedList(LinkedList<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {

            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original ArrayList: " + arrayList);
        reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("\nOriginal LinkedList: " + linkedList);
        reverseLinkedList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
