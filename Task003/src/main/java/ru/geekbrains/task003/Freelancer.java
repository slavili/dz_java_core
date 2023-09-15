package ru.geekbrains.task003;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Доработать в рамках домашней работы
 */
public class Freelancer extends Employee{
    private final double MINIMUM_HOURLY_RATE = 500;

    public Freelancer(String surName, String name, String familyStatus, double hourlyRate) {
        super(surName, name, familyStatus,hourlyRate);
    }
    public static Employee getInstance(){
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                famStatus[random.nextInt(famStatus.length)],
                random.nextInt(500, 1000));
    }
    public static List<Employee> getEmployees(int count, List<Employee> employees){
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }
    @Override
    public void calculateSalary(double hourlyRate) {
        if (hourlyRate < MINIMUM_HOURLY_RATE){
            throw new RuntimeException("Почасовая ставка должна быть не менее " + MINIMUM_HOURLY_RATE);
        }
        this.salary = 20.8*8*hourlyRate;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Семейное положение: %s; Фрилансер; Почасовая оплата труда (фиксированная месячная оплата): %.2f (руб.)",
                surName, name, familyStatus, salary);
    }

}
