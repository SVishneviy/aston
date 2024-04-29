package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee employee = new Employee()
                .setName("Ivan")
                .setSurname("Ivanov")
                .setAge(20);

        System.out.printf("ClassLoader: %s%n", employee.getClass().getClassLoader());
        System.out.printf("ClassName: %s%n", employee.getClass().getName());

        List<Employee> employees = EmployeeUtils.generateEmployeeList(10);

        EmployeeUtils.printEmployeeInfo(employees.get(1));
    }

}