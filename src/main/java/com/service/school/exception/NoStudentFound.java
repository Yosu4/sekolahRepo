package com.service.school.exception;

public class NoStudentFound extends Exception{
    public NoStudentFound(String errorMessage) {
        super(errorMessage);
    }
}
