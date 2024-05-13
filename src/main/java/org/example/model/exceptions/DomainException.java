package org.example.model.exceptions;

public class DomainException extends Exception{
    private static final Long SerialVersionUID;

    static {
        SerialVersionUID = 1L;
    }

    public DomainException(String message){
        super(message);
    }
}
