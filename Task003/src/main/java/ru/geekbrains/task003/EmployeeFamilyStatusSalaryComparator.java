package ru.geekbrains.task003;

import java.util.Comparator;

public class EmployeeFamilyStatusSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int res = o1.getFamilyStatus().compareTo(o2.getFamilyStatus());
        if (res == 0){
            return Double.compare(o1.salary, o2.salary);
        }
        return res;
    }
}
