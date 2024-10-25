package org.example.exceptions;

public class EmptyOrderException extends RuntimeException {

    public EmptyOrderException(String message) {
        super(message);
    }
}
