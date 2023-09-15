package ru.geekbrains.task003;

import java.util.Random;

public abstract class Employee implements Comparable<Employee> {

    //region Public Methods

    /**
     * Расчет среднемесячной заработной платы
     * @return
     */
    public abstract void calculateSalary(double salary);

    @Override
    public int compareTo(Employee o) {
//        return Double.compare(getSalary(), o.getSalary());
        return this.getFamilyStatus().compareTo(o.getFamilyStatus());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                '}';
    }

    //endregion

    //region Constructors And Initializers

    {
        id = ++counter;
    }

//    private Employee(){
//        this("#Surnane#", "#Name#");
//    }

//    private Employee(String surName, String name){
//        this(surName, name, 500);
//    }

    protected Employee(String surName, String name, String familyStatus, double salary){
        calculateSalary(salary);
        this.surName = surName;
        this.name = name;
        this.familyStatus = familyStatus;
    }

    //endregion

    //region Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getFamilyStatus(){
        return this.familyStatus;
    }
    public double getSalary() {
        return salary;
    }

//    public void setSalary(double salary) {
//        if (salary < 30000){
//            throw new RuntimeException("Уровень заработной платы должен быть не менее 30000");
//        }
//        this.salary = salary;
//    }
//    public abstract void setSalary(double salary);



    //endregion

    //region Fields

    private int id;

    /**
     * Имя
     */
    protected String name;

    /**
     * Фамилия
     */
    protected String surName;
    /**
     * Семейное положение
     */
    protected String familyStatus;
    /**
     * Ставка заработной платы
     */
    protected double salary;

    //endregion

    //region Static Fields

    protected static String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    protected static String[] surNames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
    protected static String[] famStatus = new String[] { "женат","холост","неизвестно" };
    protected static Random random = new Random();
    private static int counter = 1000;

    //endregion

}
