package com.davadzh.bluebeard.DTO.CoreDto;

import com.sun.istack.Nullable;

public class ResponseDto<T>{
    T data;

    @Nullable
    boolean hasError;

    @Nullable
    String error;
}
