package org.example.exceptions;

public class UnderageUserException extends RuntimeException {

    public UnderageUserException(String message) {
        super(message);
    }
}
