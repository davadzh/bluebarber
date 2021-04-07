package com.davadzh.bluebeard.BLL.Exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
