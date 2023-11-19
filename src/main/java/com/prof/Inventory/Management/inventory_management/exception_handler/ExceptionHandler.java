package com.prof.Inventory.Management.inventory_management.exception_handler;

import com.prof.Inventory.Management.inventory_management.product.ProductNotFoundException;
import com.prof.Inventory.Management.inventory_management.product.ProductNotSavedException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    public static final String EXCEPTION_STATUS = "status";
    public static final String EXCEPTION_ERROR_MESSAGE = "error";
    public static final String EXCEPTION_TIMESTAMP = "timestamp";

    @org.springframework.web.bind.annotation.ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> error = new HashMap<>();
        e.getFieldErrors().forEach(fieldError -> {
                    error.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        error.put(EXCEPTION_STATUS, HttpStatus.BAD_REQUEST.toString());
        error.put(EXCEPTION_TIMESTAMP, LocalDateTime.now().toString());


        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity handleProductNotFoundException(RuntimeException e) {
        return getResponseEntity(e, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotSavedException.class)
    public ResponseEntity handleProductNotSavedException(RuntimeException e) {
        return getResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @org.springframework.web.bind.annotation.ExceptionHandler(OtherNotFoundException.class)
    public ResponseEntity handleOtherNotFoundException(RuntimeException e) {

        return getResponseEntity(e, HttpStatus.NOT_FOUND);
    }


    private ResponseEntity getResponseEntity(RuntimeException e, HttpStatus httpStatus) {
        Map<String, String> error = new HashMap<>();
        error.put(EXCEPTION_STATUS, httpStatus.toString());
        error.put(EXCEPTION_ERROR_MESSAGE, e.getMessage());
        error.put(EXCEPTION_TIMESTAMP, LocalDateTime.now().toString());

        return new ResponseEntity(error, httpStatus);
    }

}
