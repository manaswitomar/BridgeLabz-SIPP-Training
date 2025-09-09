import java.util.ArrayList;
import java.util.List;
class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public String getCourseName() {
        return courseName;
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this); 
    }

    public void showCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println(" - " + c.getCourseName());
        }
    }
}

class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showAllStudents() {
        System.out.println("Students at " + schoolName + ":");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        School school = new School("Sunrise Public School");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        Course history = new Course("History");

        school.addStudent(s1);
        school.addStudent(s2);

        s1.enrollInCourse(math);
        s1.enrollInCourse(science);

        s2.enrollInCourse(science);
        s2.enrollInCourse(history);

        school.showAllStudents();
        System.out.println();

        s1.showCourses();
        s2.showCourses();
        System.out.println();

        math.showEnrolledStudents();
        science.showEnrolledStudents();
        history.showEnrolledStudents();
    }
}
