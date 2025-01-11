package com.duckky.sb_ecom.exception;

public class InvalidProductException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidProductException(){}

    public InvalidProductException(String message){
        super(message);
    }
}
