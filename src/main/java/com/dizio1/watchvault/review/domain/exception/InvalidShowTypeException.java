package com.dizio1.watchvault.review.domain.exception;

public class InvalidShowTypeException extends RuntimeException {
    public InvalidShowTypeException(String message) {
        super("Invalid show type value : " + message);
    }
}
