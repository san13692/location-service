package com.parkingspot.demo.error;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(String errorMessage) {
        super(errorMessage);
    }

}
