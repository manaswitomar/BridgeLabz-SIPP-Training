import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void enqueue(int x) {
        stackIn.push(x);
    }

    public int dequeue() {
        transferIfNeeded();
        if (stackOut.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stackOut.pop();
    }

    public int peek() {
        transferIfNeeded();
        if (stackOut.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stackOut.peek();
    }

    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void transferIfNeeded() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front: " + queue.peek());
        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Front: " + queue.peek());  
        System.out.println("Is empty: " + queue.isEmpty());
    }
}
