package com.davadzh.bluebeard.BLL.Exceptions;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String errorMessage) {
        super(errorMessage);
    }
}
