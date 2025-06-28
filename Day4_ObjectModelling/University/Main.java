import java.util.ArrayList;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    private String name;
    private ArrayList<Faculty> facultyList;

    public Department(String name) {
        this.name = name;
        facultyList = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }

    public void displayInfo() {
        System.out.println("Department: " + name);
        for (Faculty f : facultyList) {
            System.out.println("  - " + f.getName());
        }
    }
}

class University {
    private String name;
    private ArrayList<Department> departments;

    public University(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void displayInfo() {
        System.out.println("University: " + name);
        for (Department d : departments) {
            d.displayInfo();
        }
    }

    public void deleteUniversity() {
        System.out.println("Deleting university: " + name);
        departments.clear();
    }
}

public class Main {
    public static void main(String[] args) {
        Faculty alice = new Faculty("Alice");
        Faculty bob = new Faculty("Bob");

        University uni = new University("Tech University");

        Department cs = new Department("Computer Science");
        cs.addFaculty(alice);

        Department math = new Department("Mathematics");
        math.addFaculty(bob);

        uni.addDepartment(cs);
        uni.addDepartment(math);

        uni.displayInfo();

        System.out.println("\nIndependent Faculty:");
        alice.displayInfo();
        bob.displayInfo();

        uni.deleteUniversity();

        System.out.println("\nAfter deleting university, faculty still exist:");
        alice.displayInfo();
        bob.displayInfo();
    }
}
