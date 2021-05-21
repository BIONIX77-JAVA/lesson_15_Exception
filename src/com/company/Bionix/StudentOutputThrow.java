package com.company.Bionix;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class StudentOutputThrow {
        public static void main(String[] args) {

            try (
                    PrintWriter writer = new PrintWriter(
                            new FileOutputStream("StudentOutputThrow.txt"))) {
                Student student = new Student("Trump", "Trump", 34, 5, 11.5);
                writer.println(student.name+ "," + student.surname + "," + student.age + "," + student.group + ","+student.averageMark);
            } catch (
                    FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }