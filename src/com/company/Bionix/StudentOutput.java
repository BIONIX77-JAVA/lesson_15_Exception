package com.company.Bionix;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class StudentOutput {
    public static void main(String[] args) {

        try (
                PrintWriter writer = new PrintWriter(
                        new FileOutputStream("StudentOutput.txt"))) {
            Student student = new Student("James", "Go", 23, 5, 11.3);
            writer.println(student.name+ "," + student.surname + "," + student.age + "," + student.group + ","+student.averageMark);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}