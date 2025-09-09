import java.util.*;
class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}
class TextEditor {
    private TextState head = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;
    public void type(String text) {
        TextState newState = new TextState(text);
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }
        if (current == null) {
            head = newState;
        } else {
            current.next = newState;
            newState.prev = current;
        }

        current = newState;
        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("Text added.");
    }
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Undo not possible.");
            return;
        }
        current = current.prev;
        System.out.println("Undo done.");
    }
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Redo not possible.");
            return;
        }
        current = current.next;
        System.out.println("Redo done.");
    }

    public void show() {
        if (current == null) {
            System.out.println("Editor is empty.");
        } else {
            System.out.println("Current Text: \"" + current.content + "\"");
        }
    }
}
public class TextEditorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int choice;

        do {
            System.out.println("\n--- Text Editor Menu ---");
            System.out.println("1. Type Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current Text");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    editor.type(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.show();
                    break;
                case 0:
                    System.out.println("Exiting editor.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
