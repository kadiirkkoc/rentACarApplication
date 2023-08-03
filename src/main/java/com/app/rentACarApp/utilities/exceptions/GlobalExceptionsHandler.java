package com.app.rentACarApp.utilities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler({ExistingNameExceptions.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleBrandAlreadyExistException(ExistingNameExceptions ex, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),webRequest.getDescription(false));

        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }
}
