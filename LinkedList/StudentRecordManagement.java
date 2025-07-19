import java.util.*;
class Student{
    int rollno;
    String name;
    int age;
    char grade;
    Student next;
    public Student(int rollno, String name, int age, char grade) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentRecordManager{
    Student head = null; 
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }

    public void addAtPosition(int pos, int rollNumber, String name, int age, char grade) {
        if (pos <= 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student current = head;
        for (int i = 1; current != null && i < pos - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }

    public void deleteByRollNumber(int rollNumber) {
        if (head == null) return;

        if (head.rollno == rollNumber) {
            head = head.next;
            return;
        }

        Student current = head;
        while (current.next != null && current.next.rollno != rollNumber) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Student not found.");
            return;
        }

        current.next = current.next.next;
    }
    public void searchByRollNumber(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.rollno == rollNumber) {
                System.out.println("Found: " + current.rollno + " " + current.name + " " + current.age + " " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found.");
    }
    public void updateGrade(int rollNumber, char newGrade) {
        Student current = head;
        while (current != null) {
            if (current.rollno == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found.");
    }
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records.");
            return;
        }
        Student current = head;
        while (current != null) {
            System.out.println(current.rollno + " | " + current.name + " | " + current.age + " | " + current.grade);
            current = current.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentRecordManager list = new StudentRecordManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Record Menu ---");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Student Grade");
            System.out.println("7. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int roll, age, pos;
            String name;
            char grade;

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No, Name, Age, Grade: ");
                    roll = sc.nextInt(); name = sc.next(); age = sc.nextInt(); grade = sc.next().charAt(0);
                    list.addAtBeginning(roll, name, age, grade);
                    break;
                case 2:
                    System.out.print("Enter Roll No, Name, Age, Grade: ");
                    roll = sc.nextInt(); name = sc.next(); age = sc.nextInt(); grade = sc.next().charAt(0);
                    list.addAtEnd(roll, name, age, grade);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt();
                    System.out.print("Enter Roll No, Name, Age, Grade: ");
                    roll = sc.nextInt(); name = sc.next(); age = sc.nextInt(); grade = sc.next().charAt(0);
                    list.addAtPosition(pos, roll, name, age, grade);
                    break;
                case 4:
                    System.out.print("Enter Roll No to Delete: ");
                    roll = sc.nextInt();
                    list.deleteByRollNumber(roll);
                    break;
                case 5:
                    System.out.print("Enter Roll No to Search: ");
                    roll = sc.nextInt();
                    list.searchByRollNumber(roll);
                    break;
                case 6:
                    System.out.print("Enter Roll No and New Grade: ");
                    roll = sc.nextInt(); grade = sc.next().charAt(0);
                    list.updateGrade(roll, grade);
                    break;
                case 7:
                    list.displayAll();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 0);
    }

}