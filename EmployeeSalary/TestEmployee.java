package EmployeeSalary;

import java.util.Scanner;

public class TestEmployee {
    public static void main (String[] args){
        Employee[] employees = new Employee[2];
        Scanner scan = new Scanner(System.in);
        for (int i = 0 ; i < employees.length; i ++){
            employees[i] = new Employee(scan.nextInt());
        }
        System.out.printf("The salary for the first employee is %d\n" , employees[0].getSalary());
        System.out.printf("The salary for the second employee is %d\n" , employees[1].getSalary());
        System.out.println();
        System.out.println(Employee.getTotal_salary());
        System.out.println(Employee.getTotal_emp());
        System.out.println(Employee.getMinSalary());
        System.out.println(Employee.MAX_SALARY);
    }
}
