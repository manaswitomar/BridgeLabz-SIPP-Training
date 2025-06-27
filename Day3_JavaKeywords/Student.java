public class Student {
    static String university_Name;
    String name;
    final long roll_no;
    char grade;

    Student(String university_Name, String name, long roll_no, char grade){
        this.university_Name=university_Name;
        this.name=name;
        this.roll_no=roll_no;
        this.grade=grade;
    }


    public void displayTotalStudents(){
        if(this instanceof Student)
        System.out.println(university_Name);
        System.out.println(name);
        System.out.println(roll_no);
        System.out.println(grade);
    }

    public static void main(String[] args) {
        Student student=new Student("GLA University","Mansi", 221500304, 'A');
        student.displayTotalStudents();
    }

}

    

