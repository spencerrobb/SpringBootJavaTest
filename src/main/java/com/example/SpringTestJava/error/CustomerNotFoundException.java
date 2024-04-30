package com.example.SpringTestJava.error;

import java.util.function.Supplier;

public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException() {
        super();
    }
    public CustomerNotFoundException(String message) {
        super(message);
    }
    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotFoundException(Throwable cause) {
        super(cause);
    }
    protected CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
