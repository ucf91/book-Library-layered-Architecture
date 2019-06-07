package com.booklibrary.common.exceptions;

public class AppException extends Exception{
    public AppException(){
        super();
    }

    public AppException(String message){
        super(message);
    }
}
