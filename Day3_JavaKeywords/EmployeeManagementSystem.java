public class EmployeeManagementSystem {
    static String companyName;
    String name;
    final int id;
    String designation;

    EmployeeManagementSystem(String companyName, String name, int id,String designation){
        EmployeeManagementSystem.companyName=companyName;
        this.name=name;
        this.id=id;
        this.designation=designation;
    }


    public void displayTotalEmployee(){
        if(this instanceof EmployeeManagementSystem)
        System.out.println("Company Name :"+companyName);
        System.out.println("Name :"+name);
        System.out.println("id :"+ id);
        System.out.println("Designation :"+ designation);
    }

    public static void main(String[] args) {
        EmployeeManagementSystem employee=new EmployeeManagementSystem("Amway","Mansi", 121, "Manager");
        employee.displayTotalEmployee();
    }

}
