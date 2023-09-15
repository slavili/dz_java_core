package ru.geekbrains.task003;

import java.util.Iterator;
import java.util.List;

public class EmployeeIterator implements Iterable<Employee>{

    List<Employee> emp;

    public EmployeeIterator(List<Employee> emp) {
        this.emp = emp;
    }

    @Override
    public Iterator<Employee> iterator() {
        return this.emp.iterator();
    }
}
