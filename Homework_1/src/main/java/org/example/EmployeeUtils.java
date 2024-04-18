package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class EmployeeUtils {

    private static final String NAME = "Name";
    private static final String SURNAME = "Surname";
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 60;

    public static List<Employee> generateEmployeeList(int count) {
        List<Employee> employees = new ArrayList<>(count);

        Random random = new Random();

        IntStream.rangeClosed(1, count)
                .forEach(i -> {
                    Employee employee = new Employee()
                            .setName(NAME + " " + i)
                            .setSurname(SURNAME + " " + i)
                            .setAge(random.nextInt(MIN_AGE, MAX_AGE));
                    employees.add(employee);
                });

        return employees;
    }

    public static void printEmployeeInfo(Employee employee) {
        System.out.println(
                "Employee{" +
                "name='" + employee.getName() + '\'' +
                ", surname='" + employee.getSurname() + '\'' +
                ", age=" + employee.getAge() +
                '}'
        );
    }

}
