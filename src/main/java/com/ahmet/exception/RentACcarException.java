package com.ahmet.exception;

import lombok.Getter;

@Getter
public class RentACcarException extends RuntimeException{
    private final ErrorType errorType;
    public RentACcarException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }

    public RentACcarException(ErrorType errorType, String message){
        super(message);
        this.errorType=errorType;
    }
}
