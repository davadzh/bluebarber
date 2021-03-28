package com.davadzh.bluebeard.BLL.Exceptions;

import com.sun.istack.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "General Error")
public class NotFoundException extends RuntimeException {

    public NotFoundException(String errorMessage, HttpStatus status) {
        super(errorMessage);
    }
}
