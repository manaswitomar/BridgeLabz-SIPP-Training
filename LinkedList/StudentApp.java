class Student {
    int roll;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    Student head;

    // Add at beginning
    public void addAtBeginning(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, int roll, String name, int age, String grade) {
        if (position <= 0) {
            System.out.println("Position should be >= 1.");
            return;
        }
        Student newNode = new Student(roll, name, age, grade);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Student current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete by roll number
    public void deleteByRoll(int roll) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.roll == roll) {
            head = head.next;
            System.out.println("Record with Roll " + roll + " deleted.");
            return;
        }

        Student current = head;
        Student prev = null;

        while (current != null && current.roll != roll) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Record not found.");
            return;
        }

        prev.next = current.next;
        System.out.println("Record with Roll " + roll + " deleted.");
    }

    // Search by roll number
    public Student searchByRoll(int roll) {
        Student current = head;
        while (current != null) {
            if (current.roll == roll) {
                System.out.println("Found: Roll: " + current.roll + ", Name: " + current.name +
                                   ", Age: " + current.age + ", Grade: " + current.grade);
                return current;
            }
            current = current.next;
        }
        System.out.println("Record not found.");
        return null;
    }

    // Update grade by roll number
    public void updateGrade(int roll, String newGrade) {
        Student student = searchByRoll(roll);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated to " + newGrade + " for Roll " + roll);
        }
    }

    // Display all student records
    public void displayAll() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        System.out.println("Student Records:");
        Student current = head;
        while (current != null) {
            System.out.println("Roll: " + current.roll + ", Name: " + current.name +
                               ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtEnd(1, "Alice", 20, "A");
        list.addAtEnd(2, "Bob", 21, "B");
        list.addAtBeginning(3, "Charlie", 22, "C");
        list.addAtPosition(2, 4, "Diana", 23, "B+");

        list.displayAll();
        list.searchByRoll(2);
        list.updateGrade(2, "A+");
        list.deleteByRoll(3);
        list.displayAll();
    }
}
