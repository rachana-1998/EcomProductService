package com.rachana.EcomProductService.productException;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException() {
    }

    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
