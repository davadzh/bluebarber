package com.davadzh.bluebeard.BLL.Exceptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String errorMessage) {
        super(errorMessage);
    }
}
