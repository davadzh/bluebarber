package com.davadzh.bluebeard.BLL.Core;

import com.davadzh.bluebeard.DTO.CoreDto.ResponseDto;
import com.sun.istack.Nullable;

public class Response<T> {
    @Nullable
    T data;

    boolean hasError;

    @Nullable
    String error;

    public Response(T data) {
        this.data = data;
        this.hasError = false;
        this.error = null;
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
