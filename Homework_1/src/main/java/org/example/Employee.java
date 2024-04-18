package org.example;

public class Employee {

    private String name;
    private String surname;
    private int age;
    private static final int MIN_AGE = 18;

    public Employee() {
        name = "";
        surname = "";
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        if (name != null && name.length() > 3) {
            this.name = name;
        }
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Employee setSurname(String surname) {
        if (surname != null && surname.length() > 3) {
            this.surname = surname;
        }
        return this;
    }

    public int getAge() {
        return age;
    }

    public Employee setAge(int age) {
        if (age >= MIN_AGE) {
            this.age = age;
        }
        return this;
    }

}
