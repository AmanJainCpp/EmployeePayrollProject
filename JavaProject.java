
                                          /*Employee Payroll System*/



  import java.util.Scanner;
  import java.lang.String;
  import java.util.ArrayList;

    
    
  abstract class Employee {
    private String name;
    private int id;

    
    // Constructor
    
    public Employee(String name, int id) {
    
        this.name = name;
    
        this.id = id;
    
    }

    public String getName() {
    
        return name;
    
    }

    public int getId() {

        return id;
    
    }
        
    // abstract method
    
    public abstract double calculateSalary();

    public String toString() {

        return "Employee[name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";

    }

}

// inheritance

class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {

        // because we are using parent class constructor so we have to use super kryword

        super(name, id);
        
        this.monthlySalary = monthlySalary;

    }

    public double calculateSalary() {

        return monthlySalary;
    
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hourlyRate = hoursWorked;
        this.hourlyRate = hourlyRate;

    }

    public double calculateSalary() {

        return (hourlyRate * hourlyRate);
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();

    }

    public void addEmployee(Employee employee) {

        employeeList.add(employee);

    }

    // remove employee by their id
    public void removeEmployee(int id) {
        Employee employeeToEmployee = null;

        for (Employee employee : employeeList) {

            if (employee.getId() == id) {
                employeeToEmployee = employee;
                break;
            }
        }

        if (employeeToEmployee != null) {
            employeeList.remove(employeeToEmployee);
        }
    }

    public void displayEmployees() {

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

    }

}

public class JavaProject {
    public static void main(String[] args) {

        PayrollSystem payrollSystem = new PayrollSystem();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees you want to add: ");

        int numEmployees = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numEmployees; i++) {

            System.out.print("Enter employee type (1 for Full-Time, 2 for Part-Time): ");

            int employeeType = scanner.nextInt();

            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter employee name: ");

            String name = scanner.nextLine();

            System.out.print("Enter employee ID: ");

            int id = scanner.nextInt();

            scanner.nextLine(); // Consume the newline character

            if (employeeType == 1) {

                System.out.print("Enter monthly salary: ");

                double monthlySalary = scanner.nextDouble();

                scanner.nextLine(); // Consume the newline character

                FullTimeEmployee emp = new FullTimeEmployee(name, id, monthlySalary);

                payrollSystem.addEmployee(emp);
            } else if (employeeType == 2) {
                System.out.print("Enter hours worked: ");
                int hoursWorked = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter hourly rate: ");
                double hourlyRate = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                PartTimeEmployee emp = new PartTimeEmployee(name, id, hoursWorked, hourlyRate);
                payrollSystem.addEmployee(emp);
            } else {
                System.out.println("Invalid employee type. Please enter 1 for Full-Time or 2 for Part-Time.");
                i--;
            }
        }

        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();

        String removeChoice = "yes";

        while (removeChoice.equalsIgnoreCase("yes")) {
            System.out.print("Do you want to remove an employee? (yes/no): ");
            removeChoice = scanner.nextLine().toLowerCase();

            if (removeChoice.equals("yes")) {
                System.out.print("Enter the ID of the employee you want to remove: ");
                int idToRemove = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                payrollSystem.removeEmployee(idToRemove);
            }
        }

        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployees();
    }
}