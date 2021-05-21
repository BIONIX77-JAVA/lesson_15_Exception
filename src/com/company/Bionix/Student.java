package com.company.Bionix;

public class Student {

    public String name;
    public String surname;
    public int age;
    public int group;
    public double averageMark;

    public Student(String name, String surname, int age, int group, double averageMark) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.group = group;
        this.averageMark = averageMark;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getGroup() {
        return group;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void  setName(String name) {
        if (name == null) {
                throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(
                    "age cannot be negative: " + age);
        }
        else if (age > 90 || age < 16) {
            throw new IllegalArgumentException(
                    "a student cannot be older than 90 and younger than 16 "
            );
        }

        this.age = age;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
}