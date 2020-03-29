package com.sudip.rest.globalexceptionhandler;

import com.sudip.rest.errorresponses.CustomerErrorResponse;
import com.sudip.rest.exceptions.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CRMGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> customerNotFoundExceptionHandler
            (CustomerNotFoundException exc){
        CustomerErrorResponse response = new CustomerErrorResponse();

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exc.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> customerGenericException(Exception e){
        CustomerErrorResponse response = new CustomerErrorResponse();

        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(e.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
