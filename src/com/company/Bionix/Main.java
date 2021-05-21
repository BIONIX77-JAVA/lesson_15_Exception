package com.company.Bionix;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        try {
            deserialize("StudentOutput.txt");
        } catch (Exception e) {
            System.out.println("Be careful, respectable people shouldn't be damaging their reputation ");
            e.printStackTrace();
        }

        wrappedRun();

        getBestStudent();

        changeGroupNotLetCrime("StudentOutputThrow.txt", "Trump", 4);

        try {
           Student student = deserialize("StudentOutputThrow.txt");
            System.out.println(student.group);
            changeGroupNotLetCrime("StudentOutputThrow.txt", "Trump", 4);
            System.out.println("This will not be executed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("This will be executed");
        }
    }

    public static Student deserialize(String fileName) throws IOException, MyDomainException {
        String student;
        Student studentThis = new Student();
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            student = reader.readLine();
            String[] studentInString;
            String delimiter = ",";
            studentInString = student.split(delimiter);
            studentThis.setName(studentInString[0].equals("null") ? null : studentInString[0]);
            studentThis.setSurname(studentInString[1]);
            studentThis.setAge(Integer.parseInt(studentInString[2]));
            studentThis.setGroup(Integer.parseInt(studentInString[3]));
            studentThis.setAverageMark(Double.parseDouble(studentInString[4]));
            System.out.println(Arrays.toString(studentInString));

            if ((studentInString[0].equals("Trump") || studentInString[1].equals("Trump")) && studentThis.averageMark < 10.0) {
                throw new MyDomainException("Trump should only get excellent grades ");
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
        return studentThis;
    }

    private static void wrappedRun() {
        try {
            deserialize("StudentOutput.txt");
        } catch (IOException | MyDomainException e) {
            throw new IllegalArgumentException("You need to call the dean otherwise there will be problems. " +
                    "Urgently change the teaching staff. ");
        }
    }

    private static void getBestStudent() {

        try {
            Student student1ToCheck = new Student();
            try {
                student1ToCheck = deserialize("StudentOutputThrow.txt");
            } catch (IOException | MyDomainException e) {
                e.printStackTrace();
            }
            Student student2ToCheck = new Student();
            try {
                student2ToCheck = deserialize("StudentOutput.txt");
            } catch (IOException | MyDomainException e) {
                e.printStackTrace();
            }

            if (student1ToCheck.getAverageMark() > student2ToCheck.getAverageMark()) {
                System.out.println("The name of the best student is :" + student1ToCheck.name);
            } else if (student1ToCheck.getAverageMark() < student2ToCheck.getAverageMark()) {
                System.out.println("The name of the best student is :" + student2ToCheck.name);
            } else System.out.println("Both students are worthy of praise");
        } catch (RuntimeException runtimeException) {
            System.out.println("somehow your program is not working properly - \"there is division by zero\"");
            runtimeException.printStackTrace();
        }
    }

    public static void changeGroupNotLetCrime(String fileToDeserialize, String name, int i) {
        try {
            Student student = deserialize(fileToDeserialize);
            if (student.name.equals(name)) {
                student.group = i;
                if (student.surname.equals("Trump"))
                    throw new MyDomainException("Trump should only be in his group ");
            }
        } catch (Exception e) {
            System.out.println("Alarm : " + e.getMessage());
            System.out.println(e.getLocalizedMessage().toUpperCase(Locale.ROOT));
            try {
                throw new MyDomainException("Be careful about this name/surname", e);
            } catch (MyDomainException myDomainException) {
                myDomainException.printStackTrace();
                System.out.println(" You do some like a crime");
            }
        }
    }
}