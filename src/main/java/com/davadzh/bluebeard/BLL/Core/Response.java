package com.davadzh.bluebeard.BLL.Core;

import com.sun.istack.Nullable;

public class Response<T> {
    private T data;
    private boolean hasError;
    private String error;

    public Response(T data) {
        this.data = data;
        this.hasError = false;
        this.error = null;
    }

    public Response(String errorMessage) {
        this.data = null;
        this.hasError = true;
        this.error = errorMessage;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
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
