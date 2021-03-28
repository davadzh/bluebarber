package com.davadzh.bluebeard.BLL.Core;

import com.sun.istack.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.bind.annotation.XmlRootElement;

public class ErrorResponse{
    @Nullable
    private String data;

    private boolean hasError;

    private String error;

    public ErrorResponse(String errorMessage) {
        this.data = null;
        this.hasError = true;
        this.error = errorMessage;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
