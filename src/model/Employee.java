package model;

public class Employee {
    private String employeeId;
    private String fullName;
    private String role;
    private double salary;

    // constructor

    public Employee(String employeeId, String fullName, String role, double salary) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.role = role;
        setSalary(salary);
    }

    // Methods
    public double increaseSalary(double amount) {
        return this.salary = this.salary + amount;
    }

    public double decreaseSalary(double amount) {
        if (salary < amount) throw new IllegalArgumentException("Salary can not be decreased to negative value");
        return this.salary = this.salary - amount;
    }

    // Getters
    public String getEmployeeId() { return employeeId; }
    public String getFullName() { return fullName; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }

    // Setters
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setRole(String role) { this.role = role; }
    public void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary can not be negative");
        this.salary = salary;
    }

    // output data

    @Override
    public String toString() {
        return "Model.Employee{" +
                "EmployeeId= '" + employeeId + '\'' +
                ", fullName= " + fullName + '\'' +
                ", role= '" + role + '\'' +
                '}';
    }
}