package org.lucifer.theemployeeswebservice.error;

public class EmployeeException extends RuntimeException{

    public EmployeeException() {
    }

    public EmployeeException(String message) {
        super(message);
    }
}
