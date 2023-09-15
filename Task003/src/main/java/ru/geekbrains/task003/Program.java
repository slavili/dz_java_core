package ru.geekbrains.task003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Worker.getEmployees(5, employees);
        Freelancer.getEmployees(5, employees);

        EmployeeIterator ei = new EmployeeIterator(employees);

        System.out.println("**************************************************************************************************");
        for (Employee item: ei) {
            System.out.println(item);
        }

        Collections.sort(employees);
        System.out.println("**************************************************************************************************");
        for (Employee item: ei) {
            System.out.println(item);
        }

        Collections.sort(employees, new EmployeeFamilyStatusSalaryComparator());
        System.out.println("\t**************************************************************************************************");
        for (Employee item: ei) {
            System.out.println(item);
        }

    }

}
