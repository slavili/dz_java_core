package ru.geekbrains.task003;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Employee{
    private final double MIN_SALARY = 30000d;
    private Worker(String surName, String name, String familyStatus, double salary){
        super(surName, name, familyStatus,salary);
    }



    public static Employee getInstance(){
        return new Worker(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                famStatus[random.nextInt(famStatus.length)],
                random.nextInt(30000, 250000));
    }

    public static List<Employee> getEmployees(int count, List<Employee> employees){
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    @Override
    public void calculateSalary(double salary) {
        if (salary < MIN_SALARY){
            throw new RuntimeException("Уровень заработной платы должен быть не менее " + MIN_SALARY);
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Семейное положение: %s; Рабочий; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.)",
                surName, name, familyStatus, salary);
    }
}
