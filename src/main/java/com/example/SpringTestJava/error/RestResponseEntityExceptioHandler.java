package com.example.SpringTestJava.error;

import com.example.SpringTestJava.response.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptioHandler  extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<StatusResponse> customerNotFoundException(CustomerNotFoundException exception, WebRequest request){
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setTransactionStatusCode(HttpStatus.NOT_FOUND.value());
        statusResponse.setTransactionStatusDescription("Customer Not Found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(statusResponse);
    }

}
