package com.company.Bionix;

public class MyDomainException extends Exception {

    public MyDomainException(String fileName, Exception e) {
        super(fileName);
    }

    public MyDomainException(String fileName) {
        super(fileName);
    }
}