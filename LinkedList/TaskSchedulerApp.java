import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task current = null;

    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void deleteById(int id) {
        if (head == null) return;

        Task temp = head, prev = null;

        if (head.taskId == id && head.next == head) {
            head = null;
            current = null;
            return;
        }

        if (head.taskId == id) {
            Task last = head;
            while (last.next != head)
                last = last.next;
            head = head.next;
            last.next = head;
            if (current.taskId == id)
                current = head;
            return;
        }

        do {
            prev = temp;
            temp = temp.next;
            if (temp.taskId == id) {
                prev.next = temp.next;
                if (current == temp)
                    current = current.next;
                return;
            }
        } while (temp != head);

        System.out.println("Task ID not found.");
    }

    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        System.out.println("Current Task: [" + current.taskId + "] " + current.taskName +
                " | Priority: " + current.priority + " | Due: " + current.dueDate);
    }

    public void moveToNextTask() {
        if (current != null)
            current = current.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task temp = head;
        System.out.println("\n--- Task List ---");
        do {
            System.out.println("[" + temp.taskId + "] " + temp.taskName +
                    " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int prio) {
        if (head == null) {
            System.out.println("No tasks in list.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == prio) {
                System.out.println("[" + temp.taskId + "] " + temp.taskName +
                        " | Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tasks with priority " + prio);
    }
}

public class TaskSchedulerApp {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Delete Task by ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search by Priority");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int id, prio, pos;
            String name, date;

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID, Name, Priority, Due Date: ");
                    id = sc.nextInt(); name = sc.next(); prio = sc.nextInt(); date = sc.next();
                    scheduler.addAtBeginning(id, name, prio, date);
                    break;
                case 2:
                    System.out.print("Enter Task ID, Name, Priority, Due Date: ");
                    id = sc.nextInt(); name = sc.next(); prio = sc.nextInt(); date = sc.next();
                    scheduler.addAtEnd(id, name, prio, date);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    System.out.print("Enter Task ID, Name, Priority, Due Date: ");
                    id = sc.nextInt(); name = sc.next(); prio = sc.nextInt(); date = sc.next();
                    scheduler.addAtPosition(pos, id, name, prio, date);
                    break;
                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    id = sc.nextInt();
                    scheduler.deleteById(id);
                    break;
                case 5:
                    scheduler.viewCurrentTask();
                    break;
                case 6:
                    scheduler.moveToNextTask();
                    break;
                case 7:
                    scheduler.displayAllTasks();
                    break;
                case 8:
                    System.out.print("Enter Priority to search: ");
                    prio = sc.nextInt();
                    scheduler.searchByPriority(prio);
                    break;
                case 0:
                    System.out.println("Exiting Task Scheduler.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
 
