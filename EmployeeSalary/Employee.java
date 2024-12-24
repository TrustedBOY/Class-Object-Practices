package EmployeeSalary;

public class Employee {
    private static int total_salary = 0;
    private static int total_emp = 0;
    private int salary;
    private static final int MIN_SALARY = 50;
    public static final int MAX_SALARY = 1000;

    public Employee(int salary) {
        this.salary = salary;
        total_emp += 1;
        total_salary += salary;
    }

    public int getSalary() {
        return salary;
    }

    public static int getTotal_emp() {
        return total_emp;
    }

    public static int getTotal_salary() {
        return total_salary;
    }

    public static int getMinSalary(){
        return MIN_SALARY;
    }
}
