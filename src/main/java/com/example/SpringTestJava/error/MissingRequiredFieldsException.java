package com.example.SpringTestJava.error;

public class MissingRequiredFieldsException extends Exception{

    public MissingRequiredFieldsException() {
        super();
    }
    public MissingRequiredFieldsException(String message) {
        super(message);
    }
    public MissingRequiredFieldsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingRequiredFieldsException(Throwable cause) {
        super(cause);
    }
    protected MissingRequiredFieldsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
