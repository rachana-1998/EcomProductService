package com.rachana.EcomProductService.productException;

public class InvalidTitleException extends Exception{
    public InvalidTitleException() {
    }

    public InvalidTitleException(String message) {
        super(message);
    }

    public InvalidTitleException(String message, Throwable cause) {
        super(message, cause);
    }
}
