import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private String gradeLevel;

    public Student(String name, String gradeLevel) {
        this.name = name;
        this.gradeLevel = gradeLevel;
    }

    public String getName() { return name; }
    public String getGradeLevel() { return gradeLevel; }
}

public class StudentResulting {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", "A"),
            new Student("Bob", "B"),
            new Student("Charlie", "A"),
            new Student("David", "C"),
            new Student("Eva", "B"),
            new Student("Frank", "A")
        );

        
        Map<String, List<String>> groupedResults = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGradeLevel,                      
                        Collectors.mapping(Student::getName, Collectors.toList()) 
                ));

       
        System.out.println("=== Students Grouped by Grade ===");
        groupedResults.forEach((grade, names) -> 
            System.out.println("Grade " + grade + " -> " + names)
        );
    }
}
