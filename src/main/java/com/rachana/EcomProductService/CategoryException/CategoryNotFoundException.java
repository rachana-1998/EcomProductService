package com.rachana.EcomProductService.CategoryException;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }

    public CategoryNotFoundException() {
    }
}
