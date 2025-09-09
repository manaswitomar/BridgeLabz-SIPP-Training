import java.util.ArrayList;

class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this); // associate from both ends
            System.out.println(name + " enrolled in " + course.getName());
        }
    }

    public void showCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("  - " + c.getName());
        }
    }
}

class Professor {
    private String name;
    private ArrayList<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.assignProfessor(this);
            System.out.println("Professor " + name + " assigned to " + course.getName());
        }
    }

    public void showCourses() {
        System.out.println("Professor " + name + " teaches:");
        for (Course c : courses) {
            System.out.println("  - " + c.getName());
        }
    }
}

class Course {
    private String name;
    private Professor professor;
    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void showDetails() {
        System.out.println("Course: " + name);
        if (professor != null) {
            System.out.println("  Professor: " + professor.getName());
        } else {
            System.out.println("  Professor: [Not assigned]");
        }
        System.out.println("  Enrolled Students:");
        for (Student s : students) {
            System.out.println("    - " + s.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        Professor drSmith = new Professor("Dr. Smith");
        Professor drJones = new Professor("Dr. Jones");

        Course math = new Course("Mathematics");
        Course cs = new Course("Computer Science");

        drSmith.assignCourse(math);
        drJones.assignCourse(cs);

        alice.enrollCourse(math);
        bob.enrollCourse(math);
        alice.enrollCourse(cs);
        System.out.println("\n--- Professor Course Info ---");
        drSmith.showCourses();
        drJones.showCourses();

        System.out.println("\n--- Student Course Info ---");
        alice.showCourses();
        bob.showCourses();

        System.out.println("\n--- Course Details ---");
        math.showDetails();
        cs.showDetails();
    }
}
