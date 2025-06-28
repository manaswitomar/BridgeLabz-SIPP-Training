import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("    Employee: " + name);
    }
}

class Department {
    String deptName;
    private List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name) {
        employees.add(new Employee(name));
    }

    public void showDepartment() {
        System.out.println("  Department: " + deptName);
        for (Employee emp : employees) {
            emp.showDetails();
        }
    }
}

class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addEmployeeToDepartment(String deptName, String empName) {
        for (Department dept : departments) {
            if (deptName.equalsIgnoreCase(dept.deptName)) {
                dept.addEmployee(empName);
                return;
            }
        }
        System.out.println("Department " + deptName + " not found.");
    }

    public void showCompanyStructure() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.showDepartment();
        }
    }

    public void deleteCompany() {
        departments.clear();
        System.out.println("Company " + companyName + " and all its departments/employees have been deleted.");
    }
}

public class Main {
    public static void main(String[] args) {
        Company myCompany = new Company("TechVision Pvt Ltd");

        myCompany.addDepartment("Engineering");
        myCompany.addDepartment("HR");

        myCompany.addEmployeeToDepartment("Engineering", "Alice");
        myCompany.addEmployeeToDepartment("Engineering", "Bob");
        myCompany.addEmployeeToDepartment("HR", "Charlie");

        myCompany.showCompanyStructure();
        myCompany.deleteCompany();
    }
}
